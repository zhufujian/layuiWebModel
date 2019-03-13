package com.study.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
*
* @Description: 基本参数规则验证
* @ClassName: BaseElementsValidator 
* @author zhufj
* @date 2019年3月12日 下午3:10:38 
*
 */
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BaseElementsValidatorImpl.class)
@Documented
public @interface BaseElementsValidator {

	// 默认错误消息
	String message() default "request elements is not valid";
	
    // 
	/**
     * 绑定手机号字段
     */
    String phone() default "phone";

    /**
     * 登录名
     */
    String account() default "account";
    
    /**
     * 用户名称
     */
    String username() default "username";
    
    /**
     * 邮箱
     */
    String email() default "email";
    /**
     * 密码
     */
    String passwordNew() default "password";
    
	// 分组
	Class<?>[] groups() default {};

	// 负载
	Class<? extends Payload>[] payload() default {};
}
