package com.study.demo.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        return escapeXSS(super.getHeader(name));
    }

    @Override
    public String getQueryString() {
        return escapeXSS(super.getQueryString());
    }

    @Override
    public String getParameter(String name) {
        return escapeXSS(super.getParameter(name));
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values != null) {
            int length = values.length;
            String[] escapseValues = new String[length];
            for (int i = 0; i < length; i++) {
                escapseValues[i] = escapeXSS(values[i]);
            }
            return escapseValues;
        }
        return super.getParameterValues(name);
    }

    /**
     * 过滤跨站脚本
     * 
     * @param value
     * @return
     */
    private String escapeXSS(String value) {
        if (value != null) {
            value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
            value = value.replaceAll("eval\\((.*)\\)", "");
            value = value.replaceAll("alert\\((.*)\\)", "");
            value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
            value = value.replaceAll("script", "");
            value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
            value = value.replaceAll("'", "& #39;");
        }
        return value;
    }

}
