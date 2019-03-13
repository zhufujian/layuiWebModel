
package com.study.demo.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.demo.annotation.PerfAnalyzer;
import com.study.demo.entity.ApiResult;
import com.study.demo.entity.UserInfo;
import com.study.demo.enums.RetCodeEnum;
import com.study.demo.enums.TrxCodeEnum;
import com.study.demo.exception.BizException;
import com.study.demo.utils.ApiResultUtil;

/**
 * 
*
* @Description: 
* @ClassName: LoginController 
* @author zhufj
* @date 2019年3月11日 下午4:38:45 
*
 */
@Controller
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	/**
	 * 登录
	 * 
	 * @return
	 */
	//@PerfAnalyzer(trx = TrxCodeEnum.USER_LOGIN_IN)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ApiResult<UserInfo> login(UserInfo loginRequest, HttpServletRequest request,HttpServletResponse response) {
		//单点登录认证，获取token
		if(loginRequest!=null&&"xiaozhu".equals(loginRequest.getLoginName())&&"123456".equals(loginRequest.getPassword())){
			return ApiResultUtil.success();
		}
		return ApiResultUtil.error(RetCodeEnum.PARAM_ILLEGAL);
	}
	//@PerfAnalyzer(trx = TrxCodeEnum.USER_LOGIN_IN)
	//@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@PostMapping("/login.do")
	@ResponseBody
	public ApiResult<UserInfo> login2(@RequestBody @Valid UserInfo loginRequest, HttpServletRequest request,HttpServletResponse response) {
		
		//单点登录认证，获取token
		/*if(loginRequest!=null&&"xiaozhu".equals(loginRequest.getLoginName())&&"123456".equals(loginRequest.getPassword())){
			return ApiResultUtil.success();
		}*/
	/*	ApiResult<UserInfo> result=new ApiResult<UserInfo>(RetCodeEnum.SUCCESS.getCode(), RetCodeEnum.SUCCESS.getDesc());
		response.getWriter().print(result);*/
		
		//单点登录认证，获取token
				if(loginRequest!=null&&"xiaozhu".equals(loginRequest.getLoginName())&&"a11111111".equals(loginRequest.getPassword())){
					return ApiResultUtil.success();
				}
				return ApiResultUtil.error(RetCodeEnum.PARAM_ILLEGAL);
		  /* R r=new R();
           r.setCode(0);
           r.setMsg("获得数据成功");
           r.setCount(500);
           UserInfo info=new UserInfo();
           info.setLoginName("xiaozhu");
           info.setPassword("123456");
           r.setData(info);
           try {
			response.getWriter().print(JSON.toJSON(r));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//return;
	}
	//@PerfAnalyzer(trx = TrxCodeEnum.USER_LOGIN_IN)
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ApiResult<UserInfo> login3(UserInfo loginRequest, HttpServletRequest request,HttpServletResponse response) {
		//单点登录认证，获取token
		if(loginRequest!=null&&"xiaozhu".equals(loginRequest.getLoginName())&&"123456".equals(loginRequest.getPassword())){
			return ApiResultUtil.success();
		}
		return ApiResultUtil.error(RetCodeEnum.PARAM_ILLEGAL);
	}
	//@RequestMapping(value = "/login2.do", method = RequestMethod.POST)
	@PostMapping("/login2.do")
	public ApiResult<RetCodeEnum> login22(UserInfo loginRequest, HttpServletRequest request,HttpServletResponse response) {
		//return new ApiResult<RetCodeEnum>(RetCodeEnum.SUCCESS.getCode(), RetCodeEnum.SUCCESS.getDesc());
		throw new BizException(RetCodeEnum.SYSTEM_ERROR);
	}
	
	
}
