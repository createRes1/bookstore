package com.model;

import lombok.Data;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@Data
public class BookQuery {

    private String isbn;// 书号
    private String bookName;// 书名
    private String author;// 作者
    private String companyId;// 出版社
    private String minDop;// 最小出版日期
    private String maxDop;// 最大出版日期
    private Double minPrice;// 最小价格
    private Double maxPrice;// 最大价格
}
