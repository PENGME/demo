package com.cullen.demo.ssq.domain;

import java.util.Date;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/25 20:04
 */

public class SsqDo {


    public Integer period; // '期号',
    public Integer red1; // '红球1',
    public Integer red2; // '红球2',
    public Integer red3; // '红球3',
    public Integer red4; // '红球4',
    public Integer red5; // '红球5',
    public Integer red6; // '红球6',
    public Integer blue; // '篮球',
    public Date lotteryDate; // '开奖日期',
    public String md5; // MD5(红球+篮球)


    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getRed1() {
        return red1;
    }

    public void setRed1(Integer red1) {
        this.red1 = red1;
    }

    public Integer getRed2() {
        return red2;
    }

    public void setRed2(Integer red2) {
        this.red2 = red2;
    }

    public Integer getRed3() {
        return red3;
    }

    public void setRed3(Integer red3) {
        this.red3 = red3;
    }

    public Integer getRed4() {
        return red4;
    }

    public void setRed4(Integer red4) {
        this.red4 = red4;
    }

    public Integer getRed5() {
        return red5;
    }

    public void setRed5(Integer red5) {
        this.red5 = red5;
    }

    public Integer getRed6() {
        return red6;
    }

    public void setRed6(Integer red6) {
        this.red6 = red6;
    }

    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }

    public Date getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(Date lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
