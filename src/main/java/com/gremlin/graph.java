package com.gremlin;

import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import static org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class graph {
    public static void main(String[] args) {
        // 创建集群连接
        Cluster cluster = Cluster.build()
                .addContactPoint("localhost") // Gremlin Server 地址
                .port(8182)
                .create();

        // 创建远程连接
        GraphTraversalSource g = traversal()
                .withRemote(DriverRemoteConnection.using(cluster));

        try {
            String[] edgeLabels = new String[] { "hive_2_hive", "hive_2_metric", "dt_2_hive" };
            String[] vertexLabels = new String[] { "hive", "dt", "metric" };

            getInPaths(g, "113", vertexLabels, edgeLabels);

            System.out.println("*********************");
            System.out.println("*********************");

            int firstIsDT = getMetric2DT(g, "metric", edgeLabels, "dt");

            System.out.println("*********************");
            System.out.println("*********************");

            Long allMetricCount = getAllEndVertexCount(g, "metric");
            double coverage = allMetricCount == 0 ? 0.0 : (double) firstIsDT / allMetricCount;
            System.out.println("Metric2DT Lineage Coverage is: " + coverage);

        } finally {
            cluster.close();
        }
    }

    public static Long getAllEndVertexCount(GraphTraversalSource g, String endVertexLabel) {
        return g.V().hasLabel(endVertexLabel).count().next();
    }

    public static int getMetric2DT(GraphTraversalSource g, String endVertexLabel, String[] edgeLabels,
            String firstVertexLabel) {
        List<Vertex> vertices = g.V().hasLabel(endVertexLabel)
                .repeat(
                        __.in(edgeLabels))
                .until(
                        __.hasLabel(firstVertexLabel))
                .hasLabel(firstVertexLabel).dedup().toList();

        System.out.println("找到的节点数量：" + vertices.size());
        for (Vertex v : vertices) {
            System.out.println("节点ID: " + v.property("id").value());
        }
        return vertices.size();
    }

    public static void getInPaths(GraphTraversalSource g, String vetexId, String[] vertexLabels, String[] edgeLabels) {
        List<List<String>> paths = g.V(vetexId)
                .hasLabel("", vertexLabels)
                .repeat(__.in(edgeLabels))
                .times(4)
                .emit()
                .path()
                .by("id")
                .toList()
                .stream()
                .map(x -> {
                    List<String> nodes = new ArrayList<>();
                    for (int i = 0; i < x.size(); i++) {
                        nodes.add(x.get(i).toString());
                    }
                    return nodes;
                })
                .collect(Collectors.toList());

        for (List<String> path : paths) {
            System.out.println(path);
        }
    }
}
