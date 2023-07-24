package com.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private Integer userId;// 编号
    private String username;// 用户名
    private String password;// 密码
    private int  deleted; //逻辑删除
    private String createTime;//创建时间
    private String updateTime;//更新时间
}
