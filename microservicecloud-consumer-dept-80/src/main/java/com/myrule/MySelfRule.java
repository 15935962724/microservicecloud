package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
//        return new RandomRule();  //用我们重新选择的随机算法替代默认的轮询
        return new RandomRule_ZY();  //每个服务调用5次 进行轮询

    }



}
