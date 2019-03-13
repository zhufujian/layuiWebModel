package com.study.demo.utils;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 
*
* @Description: 正则表达式校验
* @ClassName: Validator 
* @author zhufj
* @date 2019年3月13日 上午9:34:42 
*
 */
public class Validator {
	/**
	 * 
	 * 是否为minLength到maxLength位之间的由英文数字下划线和减号组成的字符串序列号
	*
	* @param str
	* @param minLength
	* @param maxLength
	* @return
	 */
	public static boolean isRightSerialNumber(String str,int minLength,int maxLength){
		if(StringUtils.isEmpty(str)){
			return false;
		}
		return Pattern.matches("^[a-zA-Z0-9_-]{"+minLength+","+maxLength+"}$", str);
	}
	/**
	 * 检查是否为中文名称
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isChinaName(String name) {
		if (StringUtils.isEmpty(name)) {
			return false;
		}
		return Pattern.matches("[\u4e00-\u9fa5]{*,*}", name);
	}

	/**
	 * 姓名为中文，英文以及符号“·”（对私付款) +生僻字：䶮（4DAE）、（E863）、兼容汉字（\uf900-\ufad9）+任何不可见字符(空格、制表符、换页符等)
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNameForPrivate(String name) {
		if (StringUtils.isEmpty(name)) {
			return false;
		}
		return Pattern.matches("[\u4DAE\uE863\uf900-\ufad9\u4e00-\u9FA5a-zA-Z·\\s]{2,}", name);//U4DAE
	}

	/**
	 * 姓名为中文，英文以及符号“,.”(对公付款)+任何不可见字符(空格、制表符、换页符等)
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNameForPublic(String name) {
		if (StringUtils.isEmpty(name)) {
			return false;
		}
		return Pattern.matches("[\u4E00-\u9FA5a-zA-Z0-9,.\\(\\)\\（\\）\\-\\s]{2,}", name);
	}

	/**
	 * 检查是否为中文名称
	 * 
	 * @param 校验为2位到10位的中文
	 * @return
	 */
	public static boolean isChinaName2(String name) {
		if (StringUtils.isEmpty(name)) {
			return false;
		}
		return Pattern.matches("[\u4e00-\u9fa5]{2,10}", name);
	}

	/**
	 * 手机号码检查
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isCellPhone(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		return Pattern.matches("1[0-9]{10}", str.trim());
	}

	/**
	 * 手机号码检查
	 * 
	 * @param str
	 * @return 可以不填写
	 */
	public static boolean isCellPhone2(String str) {
		return Pattern.matches("^(1[0-9]{10})?$", str.trim());
	}

	/**
	 * 固定号码检查
	 * 
	 * @param str
	 * @return只检查格式为057158110033
	 */
	public static boolean isFixedPhone(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		return Pattern.matches("^[08][0-9]{10,11}$", str.trim());
	}

	/**
	 * 固定号码检查
	 * 
	 * @param str
	 *            可以不填写
	 * @return 检查0571（021）-58110033（5432191）格式的电话号码
	 */
	public static boolean isFixedPhone2(String str) {
		return Pattern.matches("^(0\\d{2,3}-\\d{7,8})?$", str.trim());
	}

	/**
	 * 检查EMAIL 匹配市面大多数email格式 update by yuanyh for 12.4.2012
	 * 
	 * @param str
	 */
	public static boolean isMailAddress(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		return Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", str.trim());
	}

	/**
	 * 4-15字母和数字 不分区大小写,不能以数字开头
	 * 
	 * @param str
	 */
	public static boolean isNr(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		return Pattern.matches("^[a-zA-Z][0-9a-zA-Z]{3,14}$", str.trim());
	}

	/**
	 * 4位纯数字
	 * 
	 * @param str
	 */
	public static boolean isNrAll(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		return Pattern.matches("^[0-9]{4}$", str.trim());
	}

	/**
	 * 纯数字
	 * 
	 * @param str
	 */
	public static boolean isNr12(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		return Pattern.matches("^\\d{12}$", str.trim());
	}

	/**
	 * 判断输入的字符串 是否 符合月份
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNrAllMonth(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		return Pattern.matches("^[1-9]|0[1-9]|1[0-2]$", str.trim());
	}

	/**
	 * 判断天数(1~31之间)
	 */
	public static boolean isNrAllDay(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		return Pattern.matches("^[1-9]|0[1-9]|[1-2][0-9]|3[0-1]$", str.trim());
	}

	/**
	 * 检查密码有效性 密码规则：6-20位数字字母组合 不能以纯数字纯英文
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isPassword(String password) {
		if (StringUtils.isEmpty(password))
			return false;
		if (Pattern.matches("^[a-z]+|[A-Z]+|[0-9]+$", password.trim())) {
			return false;
		}
		return Pattern.matches("^[\\w\\W]{6,20}$", password.trim());
	}

	/**
	 * 15或者18位身份证校验
	 * 
	 * @param str
	 */
	public static boolean isIdCard(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		return IdCard.getInstance().IdCardValidate(str);
	}

	/**
	 * 
	 * 功能描述：金额校验，必须大于0.01
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMoney(String money) {
		if (StringUtils.isEmpty(money)) {
			return false;
		}
		if (!DataTypeUtil.isNumeric(money)) {
			return false;
		}
		if (Double.parseDouble(money) >= 0.01) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 功能描述：QQ号码校验
	 * 
	 * @param qq
	 * @return
	 */
	public static boolean checkQQNumber(String qq) {
		if (qq == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{4,10}");
		return pattern.matcher(qq).matches();
	}

	public static void main(String args[]) {
		/*
		 * boolean x = isName("吉姆·格林"); System.out.print(x);
		 */
		// System.out.println(isName1("is,.()（sa12）--"));
		// System.out.println(isName(""));
		System.out.println(isNameForPrivate("党䶮乐"));
		System.out.println(isRightSerialNumber("@#$@321123421231de", 1, 32));
		
	}
}
