package com.cullen.demo.image.domain;

import org.apache.commons.lang3.StringUtils;


public class MyImage {

    private int id;

    /**
     * 图片标题
     */
    private String title;

    /**
     * 图片来自哪个网站
     */
    private String site;

    /**
     * 图片地址
     */
    private String src;

    /**
     * 图片后缀名
     */
    private String suffix;

    /**
     * 图片保存地址
     */
    private String savePath;

    /**
     * 图片大小
     */
    private long fileSize;

    /**
     * 相同图片个数
     */
    private int count;
    /**
     * 图片最终地址
     */
    private String finalSrc;
    private String cate;

    public MyImage() {
    }

    public MyImage(String src) {
        this.src = src;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return StringUtils.isNotEmpty(title) ? title.replace(" ", "") : "";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getFinalSrc() {
        return finalSrc;
    }

    public void setFinalSrc(String finalSrc) {
        this.finalSrc = finalSrc;
    }


    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }



    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }


}
