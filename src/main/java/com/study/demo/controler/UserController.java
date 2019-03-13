package com.study.demo.controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.demo.entity.ApiResult;
import com.study.demo.entity.AuthUserMultQueryRequest;
import com.study.demo.entity.AuthUserMultQueryResponse;
import com.study.demo.entity.AuthUserPageQueryRequest;
import com.study.demo.entity.AuthUserSingleQueryResponse;
import com.study.demo.enums.RetCodeEnum;
import com.study.demo.utils.ApiResultUtil;
import com.study.demo.utils.FuncUtils;
/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/operator/*")
public class UserController{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
    //private UserDao userDao = new UserDao();
    @PostMapping("/operatorMultQuery.do")
    @ResponseBody
	public ApiResult<List<AuthUserSingleQueryResponse>> operatorMultQuery(@RequestBody @Valid AuthUserPageQueryRequest request){
    	  AuthUserMultQueryRequest authUserMultQueryRequest=new AuthUserMultQueryRequest();
    		//authUserMultQueryRequest.setOffset((request.getPage()-1)*request.getLimit());
    		authUserMultQueryRequest.setLimit(request.getLimit());
    		//authUserMultQueryRequest.setUserOwner(UserContextUtil.getUserContext().getUserOwner());
    		//authUserMultQueryRequest.setUserType(UserTypeEnum.OPERATOR.getCode());
    		//uthUserMultQueryRequest.setPlatform(UserContextUtil.getUserContext().getPlatform());
    		if(StringUtils.isNotEmpty(request.getUserId())){
    			authUserMultQueryRequest.setUserId(request.getUserId());
    		}
    		if(StringUtils.isNotEmpty(request.getUsername())){
    			authUserMultQueryRequest.setUsername(request.getUsername());
    		}
    		//AuthUserMultQueryResponse multQueryResponse= operatorService.multQueryAuthUser(authUserMultQueryRequest);
    		
    		//TODO 测试模拟数据
    		AuthUserMultQueryResponse multQueryResponse=new AuthUserMultQueryResponse();
    		 List<AuthUserSingleQueryResponse> result=new ArrayList<AuthUserSingleQueryResponse>(21);
    		for(int i=0;i<21;i++){
    			AuthUserSingleQueryResponse authUserSingleQueryResponse=new AuthUserSingleQueryResponse();
    			authUserSingleQueryResponse.setAccount("account");
    			authUserSingleQueryResponse.setCreateTime(new Date());
    			result.add(authUserSingleQueryResponse);
    		}
    		multQueryResponse.setResult(result);
    		multQueryResponse.setCount(100);
    		multQueryResponse.setRetCode(RetCodeEnum.SUCCESS.getCode());
    		multQueryResponse.setRetMsg(RetCodeEnum.SUCCESS.getDesc());
    		//隐藏敏感信息展示
    		return ApiResultUtil.success(hiddenOporatorList(multQueryResponse.getResult()),multQueryResponse.getCount());
    }
  
    /**
	 * 
	* @Title: hiddenOporatorList 
	* @Description: 隐藏敏感信息
	* @param reqList
	* @return List<AuthUserSingleQueryResponse>
	 */
	private List<AuthUserSingleQueryResponse> hiddenOporatorList(List<AuthUserSingleQueryResponse> reqList){
		if(reqList==null||reqList.size()<1){
			return reqList;
		}
		for(int i=0;i< reqList.size();i++){
			reqList.set(i, hiddenOporatorObj(reqList.get(i)));
		}
		return reqList;
	}
	/**
	 * 
	* @Title: hiddenOporatorObj 
	* @Description: 隐藏敏感信息
	* @param reqObj
	* @return AuthUserSingleQueryResponse
	 */
	private AuthUserSingleQueryResponse hiddenOporatorObj(AuthUserSingleQueryResponse reqObj){
		reqObj.setEmail(FuncUtils.hiddenEmail(reqObj.getEmail()));
		reqObj.setUsername(FuncUtils.hiddenName(reqObj.getUsername()));
		reqObj.setPhone(FuncUtils.hiddenMobile(reqObj.getPhone()));
		return reqObj;
	}
}
