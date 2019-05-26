package com.cullen.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cullen.demo.ssq.domain.SsqDo;
import com.cullen.demo.ssq.service.ISsqService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import javax.annotation.Resource;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/27 18:26
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FutureTaskTests {


    @Resource
    private ISsqService ssqService;

    //    ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
    ExecutorService fixExecutorService = Executors.newFixedThreadPool(3);

    public void testThread() {

        Callable<JSONObject> query = () -> {
            SsqDo ssqDo = ssqService.selectSsqById(1000);
            String msg = JSONObject.toJSONString(ssqDo);
            return JSON.parseObject(msg);
        };


        Callable<JSONObject> query2 = () -> {
            SsqDo ssqDo = ssqService.selectSsqById(1000);
            String msg = JSONObject.toJSONString(ssqDo);
            return JSON.parseObject(msg);
        };


        FutureTask<JSONObject> query1Task = new FutureTask<>(query);
        FutureTask<JSONObject> query2Task = new FutureTask<>(query2);


        fixExecutorService.submit(query1Task);
        fixExecutorService.submit(query2Task);

        JSONObject result = new JSONObject();


        try {
            JSONObject result1 = query1Task.get();
            JSONObject result2 = query2Task.get();
            System.out.println(result1.toJSONString());
            System.out.println(result2.toJSONString());
            result.putAll(result1);
            result.putAll(result2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println(result.toJSONString());


    }


    @Test
    public void test() {
//        System.out.println(testThread());
//        testThread();

        System.out.println(10|3);
        System.out.println(20^3);
    }

}
