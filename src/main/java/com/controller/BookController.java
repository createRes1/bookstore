package com.controller;

import com.common.util.Constant;
import com.common.util.DateUtil;
import com.common.util.Pager;

import com.model.Book;
import com.model.BookQuery;

import com.model.Company;
import com.service.BookService;
import com.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@Controller
@RequestMapping("/book")
public class BookController extends GenericController {

    @Resource
    private BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Resource
    private CompanyService companyService;

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }


    /**
     * 处理查询请求
     *
     * @param bookQuery 封装查询条件参数
     * @return
     */
    @RequestMapping("/find")
    public ModelAndView find(BookQuery bookQuery) {

        this.session.setAttribute("bookQuery", bookQuery);// 将查询条件参数放入session
        Pager<Book> pager = this.bookService.findAllBook(1, Constant.PAGE_SIZE, bookQuery);// 执行条件查询
        this.request.setAttribute("pager", pager);// 将查询结果放入request
        this.request.setAttribute("companyList", this.bookService.findAllCompany());
        return new ModelAndView("list");
    }


    /**
     * 跳转到图书列表页
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     */
    @RequestMapping("/toList")
    protected String toList(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                            @RequestParam(value = "pageSize", defaultValue = "" + Constant.PAGE_SIZE) int pageSize) {
        BookQuery bookQuery = (BookQuery) this.session.getAttribute("bookQuery");
        Pager<Book> pager = this.bookService.findAllBook(pageNo, pageSize, bookQuery);
        System.out.println(pager.getList());
        this.request.setAttribute("pager", pager);// 将查询结果放入request
        this.request.setAttribute("companyList", this.bookService.findAllCompany());
        return "list";

    }

    /**
     * 处理新增图书请求
     *
     * @param book 封装图书信息
     */
    @RequestMapping("/add")
    public ModelAndView addBook(Book book) {

        book.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
        book.setBookId(DateUtil.DateToString(new Date(), "yyyyMMddHHmmss"));
        String message = "";
        if (this.bookService.addBook(book)) {// 调用service执行新增会员业务
            message = "操作成功！";
        } else {
            message = "操作失败！";
        }
        return new ModelAndView("result", "message", message);
    }

    /**
     * 跳转至add页面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "add";
    }

    /**
     * 获取所有出版社信息
     *
     * @return json
     */
    @RequestMapping("/getCompanyList")
    public @ResponseBody
    List<Company> getCompanyList() {
        return this.bookService.findAllCompany();
    }

    /**
     * 跳转至modify页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/toModify")
    public String toModify(String id) {
        Book currentBook = this.bookService.findBookById(id);
        this.request.setAttribute("currentBook", currentBook);
        List<Company> companyList = this.bookService.findAllCompany();
        this.request.setAttribute("companyList", companyList);
        return "modify";
    }

    /**
     * 处理更新图书请求
     *
     * @param obj 封装图书信息
     * @return
     */
    @RequestMapping("/modify")
    public ModelAndView modifyBook(Book obj) {

        String message = "";
        if (this.bookService.modifyBook(obj)) {// 调用service执行更新图书
            message = "操作成功";
        } else {
            message = "操作失败";
        }
        return new ModelAndView("result", "message", message);

    }

    /**
     * 处理删除图书请求
     *
     * @param id 会员编号
     */
    @RequestMapping("/remove")
    public ModelAndView removeBook(String id) {
        String message = "";
        if (this.bookService.removeBook(id)) {// 调用service执行删除会员业务
            message = "操作成功";
        } else {
            message = "操作失败";
        }
        return new ModelAndView("result", "message", message);
    }

}
