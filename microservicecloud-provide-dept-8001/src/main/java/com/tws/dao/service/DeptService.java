package com.tws.dao.service;

import com.tws.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DeptService {
    int deleteByPrimaryKey(Long deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Long deptno);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept> findAll();
}