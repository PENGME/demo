package com.cullen.demo;

import com.cullen.demo.image.domain.MyImage;
import com.cullen.demo.image.service.IMyImageService;
import com.cullen.demo.service.SsqCreateService;
import com.cullen.demo.ssq.domain.SsqDo;
import com.cullen.demo.ssq.service.ISsqService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/25 23:56
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageTest {

    @Resource
    IMyImageService myImageService;




    @Test
    public void testData() {

//        boolean saveRecord(List< MyImage > list);
//
//        public Map<String, Integer> getAllBigTypeAndCount();
//
//        Map<String, Integer> getAllSmallTypeAndCount(String bigType);
//
//        List<MyImage> getListByType(String bigType, String type, int page, int pageSize);
//
//
//        Long getAllCount();
//
//        int getCountByType(String bigType, String type);
//
//
//
//        List<MyImage> getImgByPage(int recordNumber, int pageSize);

        System.out.println("getAllBigTypeAndCount" + myImageService.getAllBigTypeAndCount());


        System.out.println("getAllSmallTypeAndCount" + myImageService.getAllSmallTypeAndCount("百度图片"));


        System.out.println("getAllCount" + myImageService.getAllCount());


        System.out.println("getCountByType" + myImageService.getCountByType("百度图片", "美食"));


        System.out.println("getListByType ----start" );
        List<MyImage> images =  myImageService.getListByType("百度图片", "美食", 0, 10);
        for(MyImage image: images) {
            System.out.println(image.getTitle());
        }
        System.out.println("getListByType ----end" );



        System.out.println("getImgByPage ----start" );
        myImageService.getImgByPage(60, 10);
        for(MyImage image: images) {
            System.out.println(image.getTitle());
        }
        System.out.println("getImgByPage ----end" );

    }



}
