package com.study.demo.entity;

import javax.validation.constraints.NotNull;

public abstract class BasePageRequest extends BaseRestRequest{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 页码 */
	@NotNull(message = "page不能为空")
	private Integer page;

	/** 每页显示条数 */
	@NotNull(message = "limit不能为空")
	private Integer limit = 20;
	
	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getLimit() {
		return limit;
	}


	public void setLimit(Integer limit) {
		this.limit = limit;
	}


}
