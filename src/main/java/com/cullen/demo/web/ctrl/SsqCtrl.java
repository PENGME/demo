package com.cullen.demo.web.ctrl;

import com.cullen.demo.service.SsqCreateService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/26 00:15
 */

@Controller
@RequestMapping("ssq")
public class SsqCtrl {


    @Resource
    SsqCreateService ssqService2;

    @GetMapping("/choose")
    @ResponseBody
    public String getChooses() {

        return ssqService2.generaterSSQ();
    }

}
