package com.study.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.study.demo.enums.TrxCodeEnum;

/**
 * 
*
* @Description: 接口日志记录
* @ClassName: WebLog 
* @author zhufj
* @date 2019年3月12日 上午9:47:35 
*
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebLog {
	/** 接口名称 */
	public TrxCodeEnum trx();
}
