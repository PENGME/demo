package com.cullen.demo.ssq.service.impl;



import com.cullen.demo.ssq.domain.SsqDo;
import com.cullen.demo.ssq.mapper.SsqMapper;
import com.cullen.demo.ssq.service.ISsqService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Ssq 服务层实现
 *
 * @author ruoyi
 * @date 2019-03-25
 */
@Service
public class SsqServiceImpl implements ISsqService {
    @Autowired
    private SsqMapper ssqMapper;

    /**
     * 查询Ssq信息
     *
     * @param period SsqID
     * @return Ssq信息
     */
    @Override
    public SsqDo selectSsqById(Integer period) {
        return ssqMapper.selectSsqById(period);
    }

    /**
     * 查询Ssq列表
     *
     * @param ssq Ssq信息
     * @return Ssq集合
     */
    @Override
    public List<SsqDo> selectSsqList(SsqDo ssq) {
        return ssqMapper.selectSsqList(ssq);
    }

    /**
     * 新增Ssq
     *
     * @param ssq Ssq信息
     * @return 结果
     */
    @Override
    public int insertSsq(SsqDo ssq) {
        return ssqMapper.insertSsq(ssq);
    }

    /**
     * 修改Ssq
     *
     * @param ssq Ssq信息
     * @return 结果
     */
    @Override
    public int updateSsq(SsqDo ssq) {
        return ssqMapper.updateSsq(ssq);
    }

    /**
     * 删除Ssq对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSsqByIds(String ids) {
        return ssqMapper.deleteSsqByIds(StringUtils.split(ids, ","));
    }



}
