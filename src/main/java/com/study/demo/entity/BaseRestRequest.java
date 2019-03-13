package com.study.demo.entity;

import java.io.Serializable;

/**
 * 
*
* @Description: rest接口请求参数基类
* @ClassName: BaseRestRequest 
* @author zhufj
* @date 2019年3月12日 下午3:18:37 
*
 */
public abstract class BaseRestRequest implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 3848884122968364361L;
	
	/**
	 * 请求参数逻辑校验
	 */
	public abstract void validateLogic();

}