package com.cullen.demo.image.service.impl;


import com.cullen.demo.image.Mapper.ImageMapper;
import com.cullen.demo.image.domain.MyImage;
import com.cullen.demo.image.service.IMyImageService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyImageService implements IMyImageService {

    @Autowired
    ImageMapper imageMapper;

    @Override
    public boolean saveRecord(List<MyImage> list) {


        try {
            for (MyImage image : list) {
                imageMapper.saveRecord(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public Map<String, Integer> getAllBigTypeAndCount() {

        List<Map<String, Object>> dataList = imageMapper.getAllBigTypeAndCount();

        Map<String, Integer> result = new LinkedHashMap<String, Integer>();

        for (Map<String, Object> map : dataList) {
            result.put(map.get("site").toString(), Integer.valueOf(map.get("c").toString()));
        }

        return result;
    }

    @Override
    public Map<String, Integer> getAllSmallTypeAndCount(String bigType) {
        List<Map<String, Object>> dataList = imageMapper.getAllSmallTypeAndCount(bigType);

        Map<String, Integer> result = new LinkedHashMap<String, Integer>();

        for (Map<String, Object> map : dataList) {
            result.put(map.get("cate").toString(), Integer.valueOf(map.get("imgcount").toString()));
        }

        return result;
    }

    @Override
    public List<MyImage> getListByType(String bigType, String type, int page, int pageSize) {
        RowBounds rowBounds = new RowBounds(page, pageSize);
        return imageMapper.getListByType(bigType, type, rowBounds);
    }

    @Override
    public Long getAllCount() {
        return imageMapper.getAllCount();
    }

    @Override
    public int getCountByType(String bigType, String type) {
        return imageMapper.getCountByType(bigType, type);
    }

    @Override
    public List<MyImage> getImgByPage(int recordNumber, int pageSize) {
        return imageMapper.getImgByPage(recordNumber, pageSize);
    }
}
