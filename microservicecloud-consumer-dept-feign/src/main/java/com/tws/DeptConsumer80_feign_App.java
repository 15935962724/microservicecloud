package com.tws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.tws")
@ComponentScan("com.tws")
public class DeptConsumer80_feign_App {


    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_feign_App.class, args);
        System.err.println(Thread.currentThread().getStackTrace()[1].getClassName()+"启动完毕");
    }

}
