package com.cullen.demo.ssq.service;


import com.cullen.demo.ssq.domain.SsqDo;

import java.util.List;

/**
 * Ssq 服务层
 *
 * @author ruoyi
 * @date 2019-03-25
 */
public interface ISsqService {
    /**
     * 查询Ssq信息
     *
     * @param period SsqID
     * @return Ssq信息
     */
    SsqDo selectSsqById(Integer period);

    /**
     * 查询Ssq列表
     *
     * @param ssq Ssq信息
     * @return Ssq集合
     */
    List<SsqDo> selectSsqList(SsqDo ssq);

    /**
     * 新增Ssq
     *
     * @param ssq Ssq信息
     * @return 结果
     */
    int insertSsq(SsqDo ssq);

    /**
     * 修改Ssq
     *
     * @param ssq Ssq信息
     * @return 结果
     */
    int updateSsq(SsqDo ssq);

    /**
     * 删除Ssq信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSsqByIds(String ids);

}
