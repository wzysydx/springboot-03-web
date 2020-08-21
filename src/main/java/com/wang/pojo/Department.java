package com.wang.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


//部门表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private int id;
    private String departmentName;
}
