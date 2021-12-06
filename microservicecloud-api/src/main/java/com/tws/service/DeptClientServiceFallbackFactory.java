package com.tws.service;

import com.tws.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClienService> {


    @Override
    public DeptClienService create(Throwable throwable) {
        return new DeptClienService() {
            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).
                        setDname("该ID:"+id+"没有对应的信息，consumer客户端提供的降级信息，此刻服务Provider已经关闭").
                        setDbSource("no this database in Mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public int add(Dept dept) {
                return 0;
            }
        };
    }


}
