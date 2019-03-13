package com.study.demo.entity;

import java.io.Serializable;

import com.study.demo.enums.RetCodeEnum;

public class BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 返回码
	private String retCode = RetCodeEnum.SUCCESS.getCode();

	// 返回提示
	private String retMsg = RetCodeEnum.SUCCESS.getDesc();

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	@Override
	public String toString() {
		// ReflectionToStringBuilder.setDefaultStyle(ToStringStyle.SHORT_PREFIX_STYLE);
		// 过滤Base64文件流
		// return ReflectionToStringBuilder.toStringExclude(this,
		// "fileStreamList");
		return "BaseResponse [retCode=" + retCode + ", retMsg=" + retMsg + "]";
	}

}
