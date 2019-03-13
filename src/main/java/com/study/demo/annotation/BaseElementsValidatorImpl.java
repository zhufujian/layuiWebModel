package com.study.demo.annotation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
*
* @Description: 基本参数规则验证
* @ClassName: BaseElementsValidatorImpl 
* @author zhufj
* @date 2019年3月12日 下午3:15:09 
*
 */
public class BaseElementsValidatorImpl implements ConstraintValidator<BaseElementsValidator, Object> {

	private String accountFiled = null;
	private String phoneFiled = null;
	private String emailFiled = null;
	private String usernameFiled = null;
	private String passwordFiled = null;
	@Override
	public void initialize(BaseElementsValidator constraintAnnotation) {
		accountFiled = constraintAnnotation.account();
		phoneFiled = constraintAnnotation.phone();
		emailFiled = constraintAnnotation.email();
		usernameFiled = constraintAnnotation.username();
		passwordFiled=constraintAnnotation.passwordNew();
		//
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(value));
		String account = jsonObject.getString(accountFiled);
		String phone = jsonObject.getString(phoneFiled);
		String email = jsonObject.getString(emailFiled);
		String username = jsonObject.getString(usernameFiled);
		String password = jsonObject.getString(passwordFiled);
		if (!isCellPhone(account) && !isMailAddress(account)) {
			customErrorMessage(context, accountFiled, "登录账号格式不正确");
			return false;
		}
		if (!isCellPhone(phone)) {
			customErrorMessage(context, phoneFiled, "手机号格式不正确");
			return false;
		}
		if (!isMailAddress(email)) {
			customErrorMessage(context, emailFiled, "邮箱格式不正确");
			return false;
		}
		if (!isName(username)) {
			customErrorMessage(context, usernameFiled, "姓名格式不正确");
			return false;
		}
		if (!isPassword(password)) {
			customErrorMessage(context, passwordFiled, "密码为8-20位数字、字母、或字符组合");
			return false;
		}
		return true;
	}

	/**
	 * 自定义详细错误信息
	 */
	private void customErrorMessage(ConstraintValidatorContext context, String field, String errorMessage) {
		context.disableDefaultConstraintViolation();
		ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(errorMessage);
		violationBuilder.addPropertyNode(field).addConstraintViolation();
	}

	public static boolean isName(String str) {
		if (StringUtils.isEmpty(str)) {
			return true;
		}
		if (!str.matches("^([\u2E80-\uFE4Fa-zA-Z]*)([.|·]*)([\u2E80-\uFE4Fa-zA-Z]*)$")) {
			return false;
		}
		return true;
	}

	public static boolean isMailAddress(String str) {
		if (StringUtils.isEmpty(str)) {
			return true;
		}
		return Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", str.trim());
	}

	public static boolean isCellPhone(String str) {
		if (StringUtils.isEmpty(str)) {
			return true;
		}
		return Pattern.matches("^1[0-9]{10}$", str.trim());
	}
	/**
	 * 检查密码有效性 密码规则：8-20位数字字母组合 不能以纯数字纯英文
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isPassword(String password) {
		if (StringUtils.isEmpty(password)) {
			return true;
		}
		if (Pattern.matches("^[a-z]+|[A-Z]+|[0-9]+$", password.trim())) {
			return false;
		}
		return Pattern.matches("^[\\w\\W]{8,20}$", password.trim());
	}
}
