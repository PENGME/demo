//package com.cullen.demo.annotation;
//
//import com.future.danyuan.common.enums.BusinessType;
//import com.future.danyuan.common.enums.OperatorType;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
///**
// * 自定义操作日志记录注解
// *
// * @Author: 谢洋   newxieyang@msn.cn
// */
//@Target({ElementType.PARAMETER, ElementType.METHOD})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//public @interface Log {
//    /**
//     * 模块
//     */
//    String title() default "";
//
//    /**
//     * 功能
//     */
//    BusinessType businessType() default BusinessType.OTHER;
//
//    /**
//     * 操作人类别
//     */
//    OperatorType operatorType() default OperatorType.MANAGE;
//
//    /**
//     * 是否保存请求的参数
//     */
//    boolean isSaveRequestData() default true;
//}
