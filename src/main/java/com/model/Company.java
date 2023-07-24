package com.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@Data
@Table(name = "company")
@Entity
public class Company implements Serializable {
    @Id
    private String companyId;
    private  String companyName;
    private  String tel;

}
