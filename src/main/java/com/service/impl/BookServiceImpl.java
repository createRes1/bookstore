package com.service.impl;


import com.common.util.Pager;
import com.common.util.StringUtil;
import com.dao.BookDao;
import com.dao.CompanyDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.BookQuery;
import com.model.Book;
import com.model.Company;
import com.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @Resource
    private CompanyDao companyDao;

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    /**
     * 查询全部图书信息
     *
     * @param pageNo :页码
     * @param pageSize :每页记录数
     * @return 查询结果
     */
    @Override
    public Pager<Book> findAllBook(int pageNo, int pageSize,BookQuery bookQuery) {
        //按id降序
        Order order1 = new Order(Sort.Direction.DESC,"bookId");
        Sort sort  = Sort.by(order1);
        //springdata默认页码自0始
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);
        Page<Book> result = null;
        if (bookQuery != null) {
            //编写Specification接口匿名实现对象，构建查询条件
            Specification<Book> specification = new Specification<Book>() {
                private static final long serialVersionUID = 1L;

                @Override
                public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                    ArrayList<Predicate> list = new ArrayList<>();
                    if (bookQuery.getIsbn() != null && !bookQuery.getIsbn().isEmpty()) {
                        list.add(cb.equal(root.get("isbn").as(String.class), bookQuery.getIsbn()));
                    }
                    if (bookQuery.getBookName() != null && !bookQuery.getBookName().isEmpty()) {
                        list.add(cb.equal(root.get("bookName").as(String.class), bookQuery.getBookName()));
                    }
                    if (bookQuery.getAuthor() != null && !bookQuery.getAuthor().isEmpty()) {
                        list.add(cb.equal(root.get("author").as(String.class), bookQuery.getAuthor()));
                    }
                    if (bookQuery.getCompanyId() != null && !bookQuery.getCompanyId().isEmpty()) {
                        list.add(cb.equal(root.get("company").get("companyId").as(String.class), bookQuery.getCompanyId()));
                    }
                    if (bookQuery.getMinDop() != null && !bookQuery.getMinDop().isEmpty()) {
                        list.add(cb.greaterThanOrEqualTo(root.get("dop").as(String.class), bookQuery.getMinDop()));
                    }
                    if (bookQuery.getMaxDop() != null && !bookQuery.getMaxDop().isEmpty()) {
                        list.add(cb.lessThanOrEqualTo(root.get("dop").as(String.class), bookQuery.getMaxDop()));
                    }
                    if (bookQuery.getMinPrice() != null) {
                        list.add(cb.greaterThanOrEqualTo(root.get("price").as(Double.class), bookQuery.getMinPrice()));
                    }
                    if (bookQuery.getMaxPrice() != null) {
                        list.add(cb.lessThanOrEqualTo(root.get("price").as(Double.class), bookQuery.getMaxPrice()));
                    }
                    Predicate[] predicates = new Predicate[list.size()];
                    predicates = list.toArray(predicates);
                    criteriaQuery.where(cb.and(predicates));
                    criteriaQuery.orderBy(cb.desc(root.get("isbn").as(String.class)));
                    return criteriaQuery.getRestriction();
                }
            };
            result = this.bookDao.findAll(specification, pageable);// 执行分页查询
        } else {
            result = this.bookDao.findAll(pageable);// 执行分页查询
        }
        // 执行分页查询
//        Page<Book> result = this.bookDao.findAll(pageable);
        /**
         * 将分页查询结果转换为自定义Pager对象返回
         */
        Pager<Book> pager = new Pager<Book>();
        pager.setPageNo(pageNo);
        pager.setPageSize(pageSize);
        pager.setRowCount((int) result.getTotalElements());
        pager.setPageCount( result.getTotalPages());
        pager.setList(result.getContent());
        return pager;
    }

    /**
     * 查询全部出版社信息
     *
     * @return 查询结果
     */
    @Override
    public List<Company> findAllCompany() {
        return this.companyDao.findAll();
    }

   /**
     * 根据图书编号删除图书
     *
     * @param id 图书编号
     * @return 操作成功返回true, 操作失败返回false
     */
    @Override
    public boolean removeBook(String id) {
        boolean result = true;
        try {
            this.bookDao.deleteById(id);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 增加新图书
     *
     * @param book 封装的图书信息
     * @return 操作成功返回true, 操作失败返回false
     */
    @Override
    public boolean addBook(Book book) {
        boolean result = true;
        try {
            this.bookDao.save(book);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 跳转modify页面并且根据id做数据回显
     *
     * @param id
     * @return
     */
    @Override
    public Book findBookById(String id) {
        return this.bookDao.findById(id).orElse(null);
    }

    /**
     * 更改图书的请求
     *
     * @param obj 封装的图书信息
     * @return 结果
     */
    @Override
    public boolean modifyBook(Book obj) {
        boolean result = true;
        try {
            this.bookDao.save(obj);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询全部图书信息
     *
     * @param pageNo:页码
     * @param pageSize:每页记录数
     * @param bookQuery:查询条件参数
     * @return 查询结果
     */
    public Pager<Book> findAll(int pageNo, int pageSize, BookQuery bookQuery) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "isbn"));// 按isbn降序
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort); // jpa默认页码自0始
        Page<Book> result = null;
        if (bookQuery != null) {
            //编写Specification接口匿名实现对象，构建查询条件
            Specification<Book> specification = new Specification<Book>() {
                private static final long serialVersionUID = 1L;

                @Override
                public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                    ArrayList<Predicate> list = new ArrayList<>();
                    if (bookQuery.getIsbn() != null && !bookQuery.getIsbn().isEmpty()) {
                        list.add(cb.equal(root.get("isbn").as(String.class), bookQuery.getIsbn()));
                    }
                    if (bookQuery.getBookName() != null && !bookQuery.getBookName().isEmpty()) {
                        list.add(cb.equal(root.get("bookName").as(String.class), bookQuery.getBookName()));
                    }
                    if (bookQuery.getAuthor() != null && !bookQuery.getAuthor().isEmpty()) {
                        list.add(cb.equal(root.get("author").as(String.class), bookQuery.getAuthor()));
                    }
                    if (bookQuery.getCompanyId() != null && !bookQuery.getCompanyId().isEmpty()) {
                        list.add(cb.equal(root.get("company").get("companyId").as(String.class), bookQuery.getCompanyId()));
                    }
                    if (bookQuery.getMinDop() != null && !bookQuery.getMinDop().isEmpty()) {
                        list.add(cb.greaterThanOrEqualTo(root.get("dop").as(String.class), bookQuery.getMinDop()));
                    }
                    if (bookQuery.getMaxDop() != null && !bookQuery.getMaxDop().isEmpty()) {
                        list.add(cb.lessThanOrEqualTo(root.get("dop").as(String.class), bookQuery.getMaxDop()));
                    }
                    if (bookQuery.getMinPrice() != null) {
                        list.add(cb.greaterThanOrEqualTo(root.get("price").as(Double.class), bookQuery.getMinPrice()));
                    }
                    if (bookQuery.getMaxPrice() != null) {
                        list.add(cb.lessThanOrEqualTo(root.get("price").as(Double.class), bookQuery.getMaxPrice()));
                    }
                    Predicate[] predicates = new Predicate[list.size()];
                    predicates = list.toArray(predicates);
                    criteriaQuery.where(cb.and(predicates));
                    criteriaQuery.orderBy(cb.desc(root.get("isbn").as(String.class)));
                    return criteriaQuery.getRestriction();
                }
            };
            result = this.bookDao.findAll(specification, pageable);// 执行分页查询
        } else {
            result = this.bookDao.findAll(pageable);// 执行分页查询
        }

        /*
         * 将分页查询结果转换为自定义Pager对象返回
         */
        Pager<Book> pager = new Pager<Book>();
        pager.setPageNo(pageNo);
        pager.setPageSize(pageSize);
        pager.setRowCount((int) result.getTotalElements());
        pager.setPageCount(result.getTotalPages());
        pager.setList(result.getContent());
        return pager;
    }

}



