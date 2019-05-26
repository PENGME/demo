package com.cullen.demo.image.Mapper;

import com.cullen.demo.image.domain.MyImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;


@Mapper
public interface ImageMapper {


    @Insert("insert DELAYED ignore into img(site,title,src,finalSrc,suffix,cate) values(#{site},#{title},#{src},#{finalSrc},#{suffix},#{cate})")
    boolean saveRecord(MyImage image);


    @Select("select site,sum(imgcount) as c from imagecount GROUP BY site ORDER BY c desc")
    List<Map<String, Object>> getAllBigTypeAndCount();


    @Select("select cate,imgcount from imagecount where site=#{bigType}  ORDER BY imgcount desc")
    List<Map<String, Object>> getAllSmallTypeAndCount(@Param("bigType") String bigType);


    @Select("select * from img where site=#{bigType} and cate=#{type}")
    List<MyImage> getListByType(@Param("bigType") String bigType, @Param("type") String type, RowBounds rowBounds);

    @Select("select count(*) from img")
    Long getAllCount();


    @Select("SELECT imgcount as c from imagecount where site=#{bigType} and cate=#{type}")
    int getCountByType(@Param("bigType") String bigType, @Param("type") String type);


    @Select("select * from img where id>#{recordNumber} limit  #{pageSize}")
    List<MyImage> getImgByPage(@Param("recordNumber") int recordNumber, @Param("pageSize") int pageSize);

}
