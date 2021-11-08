package com.tws.dao.service.Impl;

import com.tws.dao.DeptMapper;
import com.tws.dao.service.DeptService;
import com.tws.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int deleteByPrimaryKey(Long deptno) {
        return 0;
    }

    @Override
    public int insert(Dept record) {
        return  deptMapper.insert(record);
    }

    @Override
    public int insertSelective(Dept record) {
        return 0;
    }

    @Override
    public Dept selectByPrimaryKey(Long deptno) {
        return deptMapper.selectByPrimaryKey(deptno);
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return 0;
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
