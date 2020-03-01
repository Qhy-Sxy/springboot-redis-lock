package com.aaa;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringbootRedisLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisLockApplication.class, args);
    }
   /* @Bean
    public Redisson redisson(){
        Config config=new Config();
        config.useSingleServer().setAddress("redis://192.168.43.155:6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }*/
}

