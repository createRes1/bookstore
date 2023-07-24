package com.common.util;

import java.util.List;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
public class Pager<T>{
    private Integer pageNo;// 当前页码
    private Integer pageSize;// 每页记录数
    private Integer rowCount;// 总记录数
    private Integer pageCount;// 总页数
    private List<T> list;// 分页数据集合
    public Pager() {
        super();
    }

    /**
     * @param pageNo   页码
     * @param pageSize 页大小
     */
    public Pager(Integer pageNo, Integer pageSize) {
        super();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * @param pageNo    页码
     * @param pageSize  页大小
     * @param rowCount  总记录数
     * @param pageCount 总页数
     * @param list      数据集合
     */
    public Pager(Integer pageNo, Integer pageSize, Integer rowCount, Integer pageCount, List<T> list) {
        super();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.rowCount = rowCount;
        this.pageCount = pageCount;
        this.list = list;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageCount() {
        this.pageCount = (int) Math.ceil((double) this.rowCount / this.pageSize);
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * 返回当前页起始位置行号
     *
     * @return
     */
    public int getStartRow() {
        return (this.pageNo - 1) * this.pageSize + 1;
    }

    /**
     * 返回当前页结束位置行号
     *
     * @return
     */
    public int getEndRow() {
        return this.getStartRow() + this.pageSize - 1;
    }

    /**
     * 判断当前页是否为第1页
     *
     * @return
     */
    public boolean isFirstPage() {
        return this.pageNo == 1 ? true : false;
    }

    /**
     * 判断当前页是否为最后1页
     *
     * @return
     */
    public boolean isLastPage() {
        return this.pageNo == this.getPageCount() || this.getPageCount() == 0 ? true : false;
    }

}
