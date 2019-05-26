package com.cullen.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/23 23:19
 */
@Service
public class OrderService {

    @Resource
    TestRemoteData testRemoteData;


    LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    public class Request {

        String orderCode;
        CompletableFuture future;

    }

    public Map<String, Object> queryOrderInfos(String orderCode) throws ExecutionException, InterruptedException {

        Request request = new Request();

        request.orderCode = orderCode;

        CompletableFuture<Map<String, Object>> future = new CompletableFuture<>();

        request.future = future;

        queue.add(request);

        return future.get();
    }


    @PostConstruct  // servlet init
    public void init() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.scheduleAtFixedRate(() -> {

            int size = queue.size();
            if (size == 0) {
                return;
            }


            System.out.println("size:" + size);

            ArrayList<Request> requests = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Request request = queue.poll();
                requests.add(request);
            }

            ArrayList<String> orderCodes = new ArrayList<>();
            for (Request request : requests) {
                orderCodes.add(request.orderCode);

            }

            // 调用接口
            List<Map<String, Object>> results = testRemoteData.getDatasBatch(orderCodes);


            Map<String, Map<String, Object>> responseMap = new HashMap<>();
            for (Map<String, Object> response : results) {
                String orderCode = response.get("code").toString();
                responseMap.put(orderCode, response);

            }


            for (Request request : requests) {
                Map<String, Object> map = responseMap.get(request.orderCode);
//                System.out.println("----" + map);
                request.future.complete(map);

            }


        }, 0, 10, TimeUnit.MILLISECONDS);
    }
}
