package com.cullen.demo;

import com.cullen.demo.service.OrderService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/20 21:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadsTest {


    @Resource
    public OrderService orderService;

    int num = 1000;

    CountDownLatch countDownLatch = new CountDownLatch(num);


    @Test
    public void testInterface() {


        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {

                try {
                    countDownLatch.await();
                    Map<String, Object> map = orderService.queryOrderInfos("123");
                    System.out.println("result:" + map);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

            thread.start();

            countDownLatch.countDown();


        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
