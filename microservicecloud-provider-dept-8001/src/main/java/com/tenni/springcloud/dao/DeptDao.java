package com.tenni.springcloud.dao;

import com.tenni.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

     void addDept(Dept dept);

     Dept findById(Long id);

     List<Dept> findAll();


}
