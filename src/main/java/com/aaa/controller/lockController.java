package com.aaa.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 钱浩洋
 * @date 2019/11/18 - 22:55
 */
@RestController
public class lockController {
  /*  @Autowired
    private Redisson redisson;*/
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
   //高并发分布式索
    @RequestMapping("stock")
    public String Stock(){
        //jdk内置锁  同一时间执行一个 如果使用集群就出错
/*        synchronized (this){

        }*/
        String lockKey="project_001";
        String clientId = UUID.randomUUID().toString();
        //RLock redisLock = redisson.getLock(lockKey);
        try {
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId,30, TimeUnit.SECONDS);
            if (!result){
                return "error";
            }
           // redisLock.lock();
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock>0){
                int realStock=stock-1;
                stringRedisTemplate.opsForValue().set("stock",realStock+"");
                System.out.println("成功"+realStock+"");
            }else {
                System.out.println("失败");
            }
        }finally {
           // redisLock.unlock();
           if (clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))){
                stringRedisTemplate.delete(lockKey);
            }
        }
        return "  end>>>>sxy  ";
    }

}
