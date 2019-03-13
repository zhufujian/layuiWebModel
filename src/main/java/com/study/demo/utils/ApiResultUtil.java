package com.study.demo.utils;

import com.study.demo.entity.ApiResult;
import com.study.demo.enums.RetCodeEnum;

public class ApiResultUtil<T> {

	/**
	 * 成功返回
	 * 
	 * @return
	 */
	public static <T> ApiResult<T> success() {
		return new ApiResult<T>(RetCodeEnum.SUCCESS.getCode(), RetCodeEnum.SUCCESS.getDesc());
	}
	/**
	 * 成功返回
	 * 
	 * @param data
	 *            返回数据
	 * @return
	 */
	public static <T> ApiResult<T> success(T data) {
		return new ApiResult<T>(RetCodeEnum.SUCCESS.getCode(), RetCodeEnum.SUCCESS.getDesc(), data);
	}
	/**
	 * 成功返回(分页)
	 * 
	 * @param data
	 *            返回数据
	 * @param count
	 *            总条数
	 * @return
	 */
	public static <T> ApiResult<T> success(T data, Integer count) {
		ApiResult<T> apiResult = new ApiResult<T>(RetCodeEnum.SUCCESS.getCode(), RetCodeEnum.SUCCESS.getDesc(), data);
		apiResult.setCount(count);
		return apiResult;
	}

	/**
	 * 错误返回
	 * 
	 * @param errorCodeEnum
	 *            错误枚举
	 * @return
	 */
	public static <T> ApiResult<T> error(RetCodeEnum errorCodeEnum) {
		return new ApiResult<T>(errorCodeEnum.getCode(), errorCodeEnum.getDesc());
	}

	/**
	 * 错误返回
	 * 
	 * @param code
	 *            错误码
	 * @param msg
	 *            错误信息
	 * @return
	 */
	public static <T> ApiResult<T> error(String code, String msg) {
		return new ApiResult<T>(code, msg);
	}
}
