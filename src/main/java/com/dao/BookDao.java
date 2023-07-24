package com.dao;


import com.model.Book;
import com.model.BookQuery;
import com.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@Repository("bookDao")
public interface BookDao  extends JpaRepository<Book, String>, JpaSpecificationExecutor<Book> {

}
