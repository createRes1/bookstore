package com.service.impl;


import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    /**
     * 根据username和password查询用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return 查询结果
     */
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return this.userDao.findByUsernameAndPassword(username, password);
    }
}
