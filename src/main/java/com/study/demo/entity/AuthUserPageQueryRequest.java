package com.study.demo.entity;

public class AuthUserPageQueryRequest extends BasePageRequest{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名称
     */
    private String username;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void validateLogic() {
		// TODO Auto-generated method stub
		
	}
    
}
