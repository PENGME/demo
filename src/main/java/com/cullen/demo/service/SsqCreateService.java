package com.cullen.demo.service;

import com.cullen.demo.ssq.domain.SsqDo;
import com.cullen.demo.ssq.service.ISsqService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/26 00:20
 */
@Service
public class SsqCreateService {


    @Resource
    ISsqService ssqService;


    public String generaterSSQ() {


        return createSSQ();


    }


    public String createSSQ() {


        ArrayList<Integer> balls = new ArrayList<>();
        while (true) {
            int ball = (int) (Math.random() * 33) + 1;// 获取33以内的数字
            if (!balls.contains(ball)) {
                balls.add(ball);//将元素存入集合中
                if (balls.size() == 6) {//存满六个红色球，则结束循环
                    break;
                }
            }
        }


        Collections.sort(balls);


        int blue = (int) (Math.random() * 16) + 1;// 获取16以内的数字

        balls.add(blue);


        String ballsString = StringUtils.join(balls, "-");


        String ballMd5 = DigestUtils.md5DigestAsHex(ballsString.getBytes());

        SsqDo ssqDo = new SsqDo();
        ssqDo.setMd5(ballMd5);

        List<SsqDo> ssqDos = ssqService.selectSsqList(ssqDo);

        if (ssqDos.size() < 1) {
            return ballsString;
        }

        return createSSQ();

    }

}
