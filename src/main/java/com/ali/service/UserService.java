package com.ali.service;

import com.ali.model.User;

/**
 * @author QingzheHu
 * @date 2021/7/2 17:41
 */
public interface UserService {

    /**
     * 使用传递过来的User对象在数据库中进行查找
     * 并根据对象中封装的属性是否存在从而返回一个对象
     *
     * @param user 前端页面传递的User对象
     * @return 返回一个User对象
     */
    User login(User user);
}
