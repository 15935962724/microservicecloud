package com.tws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DeptConsumer80_App {


    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
        System.err.println("DeptConsumer80_App启动完毕");
    }

}