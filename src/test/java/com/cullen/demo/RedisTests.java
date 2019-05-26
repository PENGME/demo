package com.cullen.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {




    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testSet() {
//        this.redisTemplate.opsForValue().set("study", "java");
//        redisTemplate.get
        System.out.println(this.redisTemplate.opsForValue().get("study"));

        //        this.redisTemplate.opsForValue().set("study", "java");
//        redisTemplate.get
//        System.out.println(this.redisTemplate.opsForValue().get("study"));
    }

}
