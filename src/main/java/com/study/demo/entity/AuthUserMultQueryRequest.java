package com.study.demo.entity;

import java.util.Date;

public class AuthUserMultQueryRequest extends BasePageRequest{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 用户ID
     */
    private String userId;

    /**
     * 登录名
     */
    private String account;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户拥有者(默认ROOT)
     */
    private String userOwner;
    /**
     * 用户拥有者名称
     */
    private String userOwnerName;
    /**
     * 应用标识：
     */
    private String platform;

    /**
     * 状态（ENABLE:启用，DISABLE:禁用）
     */
    private String state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户类型：ADMIN 管理员 OPERATOR 操作员
     */
    private String userType;
    
    
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUserOwner() {
		return userOwner;
	}



	public void setUserOwner(String userOwner) {
		this.userOwner = userOwner;
	}



	public String getUserOwnerName() {
		return userOwnerName;
	}



	public void setUserOwnerName(String userOwnerName) {
		this.userOwnerName = userOwnerName;
	}



	public String getPlatform() {
		return platform;
	}



	public void setPlatform(String platform) {
		this.platform = platform;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public Date getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	public String getUserType() {
		return userType;
	}



	public void setUserType(String userType) {
		this.userType = userType;
	}



	@Override
	public void validateLogic() {
		// TODO Auto-generated method stub
		
	}

}
