package com.dao;


import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
    /**
     * 根据username和password查询记录
     *
     * @param username 用户名
     * @param password 密码
     * @return 查询结果
     */
    public User findByUsernameAndPassword(String username, String password);
}
