package com.dao;


import com.model.Book;
import com.model.Company;
import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@Repository("companyDao")
public interface CompanyDao extends JpaRepository<Company, String> {
//    /**
//     * 查询所有的
//     * @return
//     */
//    List<Company> selectAll();
}
