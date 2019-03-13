package com.study.demo.entity;

import java.util.List;

/**
 * 
 *
 * @Description: 查询用户列表返回
 * @ClassName: AuthUserMultQueryResponse
 * @author zhufj
 * @date 2019年3月13日 上午9:30:47
 *
 */
public class AuthUserMultQueryResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<AuthUserSingleQueryResponse> result;
	private int count;// 总比数

	public List<AuthUserSingleQueryResponse> getResult() {
		return result;
	}

	public void setResult(List<AuthUserSingleQueryResponse> result) {
		this.result = result;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
