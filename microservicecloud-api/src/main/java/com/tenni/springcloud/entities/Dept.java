package com.tenni.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptno;//主键
    private String dname;
    private String db_source;//每个微服务不同的数据库

    public Dept(String dname) {
        super();
        this.dname = dname;
    }
}
