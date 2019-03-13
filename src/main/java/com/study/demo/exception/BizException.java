package com.study.demo.exception;

import org.springframework.util.StringUtils;

import com.study.demo.enums.RetCodeEnum;


/**
 * 
*
* @Description: 自定义业务异常
* @ClassName: BizException 
* @author zhufj
* @date 2019年3月12日 下午2:31:36 
*
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -7815030607374292379L;

    private String            code;

    private String            msg;

    private String            detailMessage;

    public BizException() {
        super();
    }

    public BizException(RetCodeEnum resultCode) {
        super();
        this.code = resultCode.getCode();
        this.msg = resultCode.getDesc();
    }

    public BizException(String code, String message) {
        super();
        this.code = code;
        this.msg = message;
    }

    public BizException(RetCodeEnum resultCode, String detailMessage) {
        super();
        this.code = resultCode.getCode();
        this.msg = resultCode.getDesc();
        this.detailMessage = detailMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    @Override
    public String getMessage() {
        return StringUtils.isEmpty(detailMessage) ? msg : msg + ":" + detailMessage;
    }

    @Override
    public String toString() {
        StringBuffer controlExceptionStr = new StringBuffer();
        controlExceptionStr.append("[BizException]");
        controlExceptionStr.append("code:");
        controlExceptionStr.append(code);
        controlExceptionStr.append(",msg:");
        controlExceptionStr.append(msg);
        controlExceptionStr.append(",detailMessage:");
        controlExceptionStr.append(detailMessage);

        return controlExceptionStr.toString();
    }

}
