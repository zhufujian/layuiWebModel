package com.study.demo.utils;

import java.util.HashMap;
import java.util.UUID;

/**
 * 
*
* @Description: 上下文操作对象
* @ClassName: ContextHolder 
* @author zhufj
* @date 2019年3月12日 上午11:27:08 
*
 */
public class ContextHolder {

    private static final ThreadLocal<HashMap<String, Object>> threadLocal = new ThreadLocal<HashMap<String, Object>>() {
                                                                              @Override
                                                                              protected HashMap<String, Object> initialValue() {
                                                                                  return new HashMap<String, Object>();
                                                                              }
                                                                          };

    public static void setCorrelationID(String correlationID) {
        if (null == threadLocal.get()) {
            threadLocal.set(new HashMap<String, Object>());
        }
        threadLocal.get().put("correlationID", correlationID);
    }

    public static void setRequestIP(String requestIP) {
        if (null == threadLocal.get()) {
            threadLocal.set(new HashMap<String, Object>());
        }
        threadLocal.get().put("IP", requestIP);
    }

    public static void setLoginId(String loginId) {
        if (null == threadLocal.get()) {
            threadLocal.set(new HashMap<String, Object>());
        }
        threadLocal.get().put("loginId", loginId);
    }

    public static String getCorrelationID() {
        if (null == threadLocal.get()) {
            threadLocal.set(new HashMap<String, Object>());
        }
        Object object = threadLocal.get().get("correlationID");
        if (null == object) {
            object = UUID.randomUUID();
            threadLocal.get().put("correlationID", object.toString());
        }
        return object.toString();
    }

    public static String getRequestIP() {
        if (null == threadLocal.get()) {
            return null;
        }
        return threadLocal.get().get("IP").toString();
    }

    public static String getLoginId() {
        if (null == threadLocal.get()) {
            return null;
        }
        Object loginId = threadLocal.get().get("loginId");
        return loginId == null ? "" : loginId.toString();
    }

    public static void clear() {
        if (null != threadLocal.get()) {
            threadLocal.get().clear();
        }
    }

}
