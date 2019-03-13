package com.study.demo.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.study.demo.R;
import com.study.demo.dao.UserDao;
import com.study.demo.entity.User;

/**
 * 用户控制器
 */
@WebServlet("/UserController")
public class UserController2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");

        if (action.equals("list")) {
            list(response);  //获得所有用户
        }else if (action.equals("add")) {
            add(request, response);  //添加新用户
        }
        else if (action.equals("del")) { //删除用户
            delUser(request, response);
        }
        else if (action.equals("update")) { //更新用户
            int id =Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String city = request.getParameter("city");
            userDao.updateUser(new User(id,name, city));
            
            delay();
            response.getWriter().print("{\"msg\":\"更新成功\"}");
        }
        else if (action.equals("pager")) { //分页
            int page =Integer.parseInt(request.getParameter("page"));
            int limit =Integer.parseInt(request.getParameter("limit"));
            
            R r=new R();
            r.setCode(0);
            r.setMsg("获得数据成功");
            r.setCount(500);
            r.setData(userDao.getPager(page, limit));
            
            delay();
            response.getWriter().print(JSON.toJSON(r));
        }
    }

    /**删除用户*/
    public void delUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        userDao.delUser(id);
        delay();
        response.getWriter().print("{\"msg\":\"删除成功\"}");
    }

    /**添加新用户*/
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        userDao.addUser(new User(name, city));
        
        delay();
        response.getWriter().print("{\"msg\":\"添加成功\"}");
    }

    /**获得所有用户*/
    public void list(HttpServletResponse response) throws IOException {
        
        //Java 对象 - > 字符串 序列化成JSON
        //字符串 -> Java对象 反序列化
        
        String result = "[";
        for (User user : userDao.getAllUsers()) {
            result += "{\"id\":" + user.getId() + ",\"name\":\"" + user.getName() + "\",\"city\":\""
                    + user.getCity() + "\"},";
        }
        if (result.substring(result.length() - 1, result.length()).equals(",")) {
            result = result.substring(0, result.length() - 1);
        }
        result += "]";
        
        delay();
        response.getWriter().print(result);
    }
    
    public void delay(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
