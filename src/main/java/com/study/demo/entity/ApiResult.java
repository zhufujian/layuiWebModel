package com.study.demo.entity;

import java.io.Serializable;

public class ApiResult<T extends Object> implements Serializable  {

	/** 序列号 */
	private static final long serialVersionUID = 5309825731677338650L;

	/** 返回码 */
	private String code;

	/** 返回信息 */
	private String msg;
	
	/** 分页查询时有值，总条数 */
	private Integer count;

	/** 返回数据 */
	private T data;

	public ApiResult(String code2, String desc) {
		this.code=code2;
		this.msg=desc;
	}

	public ApiResult(String code2, String desc, T data2) {
		this.code=code2;
		this.msg=desc;
		this.data=data2;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
