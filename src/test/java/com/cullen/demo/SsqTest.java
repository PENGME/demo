package com.cullen.demo;

import com.cullen.demo.service.SsqCreateService;
import com.cullen.demo.ssq.domain.SsqDo;
import com.cullen.demo.ssq.service.ISsqService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/25 23:56
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsqTest {

    @Resource
    ISsqService ssqService;


    @Resource
    SsqCreateService ssqService2;

    @Test
    public void testData() {

        SsqDo ssqDo = new SsqDo();
        ssqDo.blue = 10;
        List<SsqDo> ssqs = ssqService.selectSsqList(ssqDo);
        System.out.println(ssqs.size());


    }


    @Test
    public void testCreateSSQ() {
        for (int i = 0; i < 10; i++) {
            System.out.println(ssqService2.generaterSSQ());
        }

        String str = "10-11-12-13-26-28-11";


        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        System.out.println(md5);

    }
}
