package com.tws.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer
public class EurekaServer7001_App {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServer7001_App.class,args);
        System.err.println("eureka7001服务启动完毕");
    }

}
