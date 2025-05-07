package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author stalwarthuang
 * @description
 * @since 2025-04-29 星期二 23:44:57
 */

@Data
@AllArgsConstructor
public class Vertex extends MetaData {
    private String uid;
    private String label;
    private String prop;
    public static String name = "点";

    public Vertex() {
    };

    @Override
    public void selfIntroduction() {
        System.out.println("我是元数据中的原子点");
    }

    public void selfIntroduction1() {
        super.selfIntroduction();
    }

    public void show() {
        System.out.println(super.name);
    }

    public int getData() {
        return 1;
    }

}
