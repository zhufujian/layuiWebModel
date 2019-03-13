
package com.study.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.demo.entity.ApiResult;
import com.study.demo.enums.RetCodeEnum;
import com.study.demo.utils.ApiResultUtil;
import com.study.demo.utils.LogUtil;


/**
 * 
*
* @Description: web统一异常捕捉 使用@ControllerAdvice注解实现全局异常捕获 basePackages可添加多个{"A","B"}
* @ClassName: GlobalExceptionHandler 
* @author zhufj
* @date 2019年3月12日 下午2:30:48 
*
 */
@ControllerAdvice(basePackages = { "com.study.demo.controler" })
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 系统异常捕获
	 * 
	 * @param request
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ApiResult<Object> exceptionHandler(HttpServletRequest request, Exception exception) {
		LogUtil.error(logger, exception.getMessage(), exception); // 系统错误日志，打印级别error
		return handleErrorInfo(request, RetCodeEnum.SYSTEM_ERROR.getCode(), RetCodeEnum.SYSTEM_ERROR.getDesc(), exception);
	}

	/**
	 * 业务异常捕获
	 * 
	 * @param request
	 * @return
	 */
	@ExceptionHandler(BizException.class)
	@ResponseBody
	public ApiResult<Object> bizExceptionHandler(HttpServletRequest request, BizException bizException) {
//		LogUtil.warn(logger, bizException.toString()); // 业务异常日志，打印级别warn
		LogUtil.info(logger, bizException.getMessage()); // 业务异常日志，打印级别info
		return handleErrorInfo(request, bizException.getCode(), bizException.getMessage(), bizException);
	}

	/**
	 * 请求参数校验异常
	 * 
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ApiResult<Object> methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException validException) {
		BindingResult bindingResult = validException.getBindingResult();
		String errorMesssage = "";
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			errorMesssage += fieldError.getDefaultMessage() + ",";
		}
		errorMesssage = errorMesssage.substring(0, errorMesssage.length()-1);
//		LogUtil.info(logger, errorMesssage); // 请求参数校验异常日志，打印级别info
		LogUtil.info(logger,errorMesssage); // 业务异常日志，打印级别info
		return handleErrorInfo(request, RetCodeEnum.PARAM_ILLEGAL.getCode(), errorMesssage, validException);
	}

	/**
	 * 错误信息处理
	 * 
	 * @param request
	 * @param code
	 * @param message
	 * @param exception
	 * @return
	 */
	private ApiResult<Object> handleErrorInfo(HttpServletRequest request, String code, String message, Exception exception) {
		return ApiResultUtil.error(code, message);
	}

}
