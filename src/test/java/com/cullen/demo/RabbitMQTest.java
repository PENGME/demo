package com.cullen.demo;

import com.cullen.demo.rabbitmq.HelloSender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/17 10:41
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RabbitMQTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void testRabbit() {
        helloSender.send();
    }
}
