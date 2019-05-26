package com.cullen.demo.image.service;

import com.cullen.demo.image.domain.MyImage;

import java.util.List;
import java.util.Map;

public interface IMyImageService {


    boolean saveRecord(List<MyImage> list);

    public Map<String, Integer> getAllBigTypeAndCount();

    Map<String, Integer> getAllSmallTypeAndCount(String bigType);

    List<MyImage> getListByType(String bigType, String type, int page, int pageSize);


    Long getAllCount();

    int getCountByType(String bigType, String type);



    List<MyImage> getImgByPage(int recordNumber, int pageSize);

}
