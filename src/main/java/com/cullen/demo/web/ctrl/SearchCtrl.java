package com.cullen.demo.web.ctrl;


import com.cullen.demo.image.domain.MyImage;
import com.cullen.demo.image.service.IMyImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SearchCtrl  {

    @Resource
    IMyImageService myImageService;

    private static final int pageSize = 10;

    /***
     * 大类大全
     * @return
     */
    @GetMapping("search/bigType")
    public String bigType(ModelMap mmap) {
        mmap.put("allBigType", myImageService.getAllBigTypeAndCount()); //大类集合
        mmap.put("allCount", myImageService.getAllCount()); //大类集合
        return "bigType";


    }


    /***
     * 小类大全
     * @return
     */
    @GetMapping("search/smallType")
    public String smallType(ModelMap mmap, String bigType) {
        mmap.put("allSmallType", myImageService.getAllSmallTypeAndCount(bigType)); //小类集合
        mmap.put("bigType", bigType);
        return "smallType";
    }


    /***
     * 列表页
     * @return
     */
    @GetMapping("search/list")
    public String list(ModelMap mmap, String bigType, String type, @RequestParam(value="page",defaultValue="1",required=false) int page) {
        List<MyImage> list = myImageService.getListByType(bigType, type, page, pageSize);
        mmap.put("list", list);
        mmap.put("count", myImageService.getCountByType(bigType, type));
        mmap.put("start", (page - 1) * pageSize + 1);
        mmap.put("showCount", pageSize);
        mmap.put("bigType", bigType);
        mmap.put("type", type);

        return "list";
    }


   



}
