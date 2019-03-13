package com.study.demo.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.study.demo.annotation.BaseElementsValidator;
@BaseElementsValidator(message = "请求参数错误")
public class UserInfo extends BaseRestRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank(message="登录名称不能为空")
	private String loginName;
	@NotBlank(message="登录密码不能为空")
	private String password;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void validateLogic() {
		// TODO Auto-generated method stub
		
	}
	
	
}
