package com.service;

import com.common.util.Pager;
import com.model.Book;
import com.model.BookQuery;
import com.model.Company;

import java.util.List;
import java.util.Map;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
public interface BookService {

    /**
     * 查询全部图书信息
     *
     * @param pageNo :页码
     * @param pageSize :每页记录数
     * @return 查询结果
     */
    Pager<Book> findAllBook(int pageNo, int pageSize,BookQuery bookQuery);

    /**
     * 多条件查询并分页
     * @param pageNo 开始索引
     * @param pageSize 分页条数
     * @param bookQuery 封装的搜索条件
     * @return
     */
    Pager<Book> findAll(int pageNo, int pageSize, BookQuery bookQuery);

    /**
     * 查询全部出版社信息
     *
     * @return 查询结果
     */
    public List<Company> findAllCompany();

    /**
     * 根据图书编号删除图书
     *
     * @param id 图书编号
     * @return 操作成功返回true, 操作失败返回false
     */
    public boolean removeBook(String id);

    /**
     * 增加新图书
     * @param book 封装的图书信息
     * @return 操作成功返回true, 操作失败返回false
     */
    boolean addBook(Book book);

    /**
     * 跳转modify页面并且根据id做数据回显
     * @param id
     * @return
     */
    Book findBookById(String id);

    /**
     * 更改图书的请求
     * @param obj 封装的图书信息
     * @return 结果
     */
    boolean modifyBook(Book obj);

}
