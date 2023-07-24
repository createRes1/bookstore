package com.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */



@Table(name = "book")
@Entity
public class Book implements Serializable {

    @Id
    private String bookId;//UUID
    private  String isbn; //书号
    private  String bookName; //书名
    private  String author; //图书作者
    private  String dop; //出版日期
    private  Double price; //价格
    private  String content; //内容摘要
    @ManyToOne
    @JoinColumn(name = "company_id")
    private  Company company; //出版社属性
    private int  deleted; //逻辑删除
    private String createTime;//创建时间
    private String updateTime;//更新时间


    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", dop='" + dop + '\'' +
                ", price=" + price +
                ", content='" + content + '\'' +
                ", company=" + company +
                ", deleted=" + deleted +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDop() {
        return dop;
    }

    public void setDop(String dop) {
        this.dop = dop;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Book() {
    }

    public Book(String bookId, String isbn, String bookName, String author, String dop, Double price, String content, Company company, int deleted, String createTime, String updateTime) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.dop = dop;
        this.price = price;
        this.content = content;
        this.company = company;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
