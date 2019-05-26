package com.cullen.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/23 22:44
 */
@Service
public class TestRemoteData {




    public List<Map<String, Object>> getDatasBatch(List<String> codes) {

        List<Map<String, Object>> results = new ArrayList<>();


        for(String code: codes) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", code);
            map.put("money", new Random().nextInt(9999));
            map.put("time", new Date().toLocaleString());
            results.add(map);
        }


        return results;

    }

}
