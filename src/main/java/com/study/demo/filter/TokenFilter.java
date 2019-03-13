/**
 * Copyright © 2004-2018 LianlianPay.All Rights Reserved.
 */
/**
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
*
* @Description: 登录过滤器 验证登录状态
* @ClassName: TokenFilter 
* @author zhufj
* @date 2019年3月12日 下午2:12:09 
*
 */
public class TokenFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

	/**
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
	 *      javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String uri = request.getRequestURI().replace(request.getContextPath(), "");
		String httpMethod = request.getMethod();
		boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With")) ? true : false;
		if (uri.startsWith("/static")) {
			// 静态资源不进行过滤
			chain.doFilter(servletRequest, servletResponse);
			return;
		}else {
				chain.doFilter(servletRequest, servletResponse);
				return;
		}
	}

	/**
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
	}
}
