package com.cullen.demo.ssq.mapper;


import com.cullen.demo.ssq.domain.SsqDo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Ssq 数据层
 *
 * @author ruoyi
 * @date 2019-03-25
 */
@Mapper
public interface SsqMapper {
    /**
     * 查询Ssq信息
     *
     * @param period SsqID
     * @return Ssq信息
     */
    public SsqDo selectSsqById(Integer period);

    /**
     * 查询Ssq列表
     *
     * @param ssq Ssq信息
     * @return Ssq集合
     */
    public List<SsqDo> selectSsqList(SsqDo ssq);

    /**
     * 新增Ssq
     *
     * @param ssq Ssq信息
     * @return 结果
     */
    public int insertSsq(SsqDo ssq);

    /**
     * 修改Ssq
     *
     * @param ssq Ssq信息
     * @return 结果
     */
    public int updateSsq(SsqDo ssq);

    /**
     * 删除Ssq
     *
     * @param period SsqID
     * @return 结果
     */
    public int deleteSsqById(Integer period);

    /**
     * 批量删除Ssq
     *
     * @param periods 需要删除的数据ID
     * @return 结果
     */
    public int deleteSsqByIds(String[] periods);

}