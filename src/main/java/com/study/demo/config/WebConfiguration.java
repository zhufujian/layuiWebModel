package com.study.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * 
*
* @Description: WEB拦截器配置
* @ClassName: WebConfiguration 
* @author zhufj
* @date 2019年3月12日 下午2:11:28 
*
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setSuffix(".html"); // 设置页面后缀
		resolver.setContentType("text/html; charset=UTF-8");
		resolver.setRequestContextAttribute("ctx"); // web请求上下文（页面中获取项目根路径${ctx.contextPath}）
		return resolver;
	}

}
