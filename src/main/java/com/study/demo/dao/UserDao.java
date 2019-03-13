package com.study.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.study.demo.entity.User;

/**
 * 
*
* @Description: 用户数据访问
* @ClassName: UserDao 
* @author zhufj
* @date 2019年3月11日 上午11:13:34 
*
 */
public class UserDao {
	private static List<User> users = new ArrayList<User>();
	
	static {

        for (int i = 1; i <= 50; i += 3) {
            users.add(new User(i, "张国立" + UUID.randomUUID(), "中国北京" + UUID.randomUUID(),UUID.randomUUID().toString()));
            users.add(new User(i + 1, "张学友" + UUID.randomUUID(), "中国香港" + UUID.randomUUID(),UUID.randomUUID().toString()));
            users.add(new User(i + 2, "张慧妹" + UUID.randomUUID(), "中国珠海" + UUID.randomUUID(),UUID.randomUUID().toString()));
        }
    }
	

    /** 获得所有用户 */
    public List<User> getPager(int page,int limit) {
        List<User> list = new ArrayList<User>();
        int start=(page-1)*limit;
        for (int i =start; i <start+limit&&i<users.size(); i++) {
            list.add(users.get(i));
        }
        return list;
    }
    
    /** 获得所有用户 */
    public List<User> getAllUsers() {
        return users;
    }

    /** 添加用户 */
    public void addUser(User user) {
        if (user.getId() <= 0) { // 未设置id
            int index = users.size() - 1; // 获得最后一个用户的索引号
            if (index < 0) { // 如没有一个用户
                user.setId(1); // 编号为1
            } else {
                user.setId(users.get(index).getId() + 1); // 获得最后一个用户的编号+1
            }
        }
        users.add(user);
    }

    /** 删除用户 */
    public void delUser(int id) {
        User delUser = null;
        for (User user : users) {
            if (user.getId() == id) {
                delUser = user;
                break;
            }
        }
        users.remove(delUser);
    }

    public void updateUser(User obj) {
        User editUser = null;
        for (User user : users) {
            if (user.getId() == obj.getId()) {
                editUser = user;
                break;
            }
        }
        editUser.setName(obj.getName());
        editUser.setCity(obj.getCity());
    }

}
