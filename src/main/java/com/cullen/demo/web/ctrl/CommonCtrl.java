package com.cullen.demo.web.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/26 00:15
 */

@Controller
public class CommonCtrl {



    @GetMapping("/index")
    public String index() {

        return "index";
    }

}
