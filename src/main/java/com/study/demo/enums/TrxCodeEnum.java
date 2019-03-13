package com.study.demo.enums;

public enum TrxCodeEnum {

	
	
	USER_LOGIN_IN("1001","用户登入"),
	USER_LOGIN_OUT("1002","用户登出");
	
	public final String code;
	public final String msg;
	/** 
	* @Title:
	* @Description: 
	* @param code
	* @param msg
	*/
	private TrxCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
