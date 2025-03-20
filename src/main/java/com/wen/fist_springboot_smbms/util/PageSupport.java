package com.wen.fist_springboot_smbms.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Class name: PageSupport
 * Package: com.wen.fist_springboot_smbms.util
 * Description:
 *
 * @Create: 2025/3/20 18:32
 * @Author: jay
 * @Version: 1.0
 */
/*
 * PageSupport类用于提供分页支持功能。
 * 它封装了分页所需的属性和方法，如当前页码、总记录数、页面大小和总页数。
 * 这个类的主要作用是帮助应用程序进行数据分页展示。
 */
public class PageSupport {
    // 当前页码，由用户输入确定
    private int currentPageNo = 1;
    // 总记录数，来自数据库查询结果
    private int totalCount = 0;
    // 页面大小，即每页显示的记录数
    private int pageSize = 0;
    /**
     * -- SETTER --
     *  直接设置总页数
     *  通常不直接使用此方法设置总页数，而是通过设置总记录数和页面大小自动计算得出
     *
     */
    // 总页数，根据总记录数和页面大小计算得出
    @Setter
    private int totalPageCount =1;

    /**
     * 获取当前页码
     *
     * @return 当前页码
     */
    public int getCurrentPageNo() {
        return currentPageNo;
    }

    /**
     * 设置当前页码
     * 仅当输入的页码大于0时才设置
     *
     * @param currentPageNo 当前页码
     */
    public void setCurrentPageNo(int currentPageNo) {
        if(currentPageNo>0){
            this.currentPageNo = currentPageNo;
        }
    }

    /**
     * 获取总记录数
     *
     * @return 总记录数
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录数
     * 当总记录数发生变化时，总页数也需要重新计算
     *
     * @param totalCount 总记录数
     */
    public void setTotalCount(int totalCount) {
        if(totalCount>0){
            this.totalCount = totalCount;
            this.setTotalPageCountByRs();
        }
    }

    /**
     * 获取页面大小
     *
     * @return 页面大小
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置页面大小
     * 仅当页面大小大于0时才设置
     *
     * @param pageSize 页面大小
     */
    public void setPageSize(int pageSize) {
        if(pageSize>0){
            this.pageSize = pageSize;
        }
    }

    /**
     * 获取总页数
     *
     * @return 总页数
     */
    public int getTotalPageCount() {
        return totalPageCount;
    }

    /**
     * 根据总记录数和页面大小计算总页数
     * 如果总记录数除以页面大小有余数，则总页数为商加1；否则总页数为商
     * 如果总记录数或页面大小为0，则总页数为0
     */
    public void setTotalPageCountByRs(){
        if(this.totalCount % this.pageSize == 0){
            this.totalPageCount = this.totalCount / this.pageSize;
        }else if(this.totalCount % this.pageSize > 0){
            this.totalPageCount = this.totalCount / this.pageSize +1;
        }else{
            this.totalPageCount = 0;
        }
    }
}

