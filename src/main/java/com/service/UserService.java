package com.service;

import com.model.User;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
public interface UserService {
    /**
     * 根据username和password查询用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return 查询结果
     */
    public User findByUsernameAndPassword(String username, String password);
}
