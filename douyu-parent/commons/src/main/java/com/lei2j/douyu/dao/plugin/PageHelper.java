package com.lei2j.douyu.dao.plugin;

/**
 * @author lei2j
 * Created by lei2j on 2018/5/12.
 */
public class PageHelper {

    private static ThreadLocal<Page> tThreadLocal = new ThreadLocal<>();

    private PageHelper(){
    }

    public static void startPage(){
        startPage(0, 20);
    }

    public static void startPage(Integer offset,Integer limit){
        Page page = new Page(offset, limit);
        tThreadLocal.set(page);
    }

    public static Page getValue(){
        Page page = tThreadLocal.get();
        return page;
    }

    public static Page removeValue(){
        Page value = getValue();
        tThreadLocal.remove();
        return value;
    }

    public static class Page{
        private Integer pageNum = 1;
        private Integer limit;
        private Integer offset;

        public Page(Integer offset, Integer limit) {
            this.offset = offset;
            this.limit = limit;
        }

        public Integer getPageNum() {
            return pageNum;
        }

        public void setPageNum(Integer pageNum) {
            this.pageNum = pageNum==null||pageNum<0?1:pageNum;
            this.offset = (pageNum-1)*limit;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            if(limit>100)return;
            this.limit = limit;
        }

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            if(offset==null)return;
            pageNum = offset/limit+1;
            this.offset = offset;
        }
    }
}
