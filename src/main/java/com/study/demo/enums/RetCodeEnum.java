package com.study.demo.enums;

/**
 * 
 *
 * @Description: 返回结果码
 * @ClassName: RetCodeEnum
 * @author zhufj
 * @date 2019年3月11日 上午11:40:40
 *
 */
public enum RetCodeEnum {

	// 业务提示0000~7999
	SUCCESS("0000", "请求处理成功"), REQUEST_ILLEGAL("0001", "请求报文非法"), PARAM_ILLEGAL(
			"0002", "参数校验未通过"), RECORD_NOT_EXIST("0003", "未查询到记录"),
	// 系统异常8000~9999
	SYSTEM_TIMEOUT("8000", "服务调用超时"), SYSTEM_ERROR("8001", "系统错误");

	private final String code;
	private final String desc;

	/**
	 * @Title:
	 * @Description:
	 * @param code
	 * @param desc
	 */
	RetCodeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
