package com.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;

@Configuration
public class RandomRule_ZY extends AbstractLoadBalancerRule {

//    Random random;
//
//    public RandomRule(){
//        random = new Random();
//    }

    private int total = 0; // 总共被调用的次数，目前要求每台被调用5次
    private int currentIndex = 0; // 当前提供服务的机器号

    public Server choose(ILoadBalancer lb, Object key){
        if (lb == null) {//加载哪种负载均衡算法，至少加载一种，这里永远都不会null
            return null;
        }
        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();//活着的对外提供的机器
            List<Server> allList = lb.getAllServers();//获取所有的微服务
            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
// int index = random.nextInt(serverCount);// java.util.Random().nextInt(3);
// server = upList.get(index);
            if(total < 5)
            {
                server = upList.get(currentIndex);
                total++;
            }else {
                total = 0;
                currentIndex++;
                if(currentIndex >= upList.size())
                {
                    currentIndex = 0;
                }
            }
            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
// Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig)
    {

    }

}
