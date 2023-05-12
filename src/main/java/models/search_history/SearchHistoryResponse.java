package models.search_history;

import java.util.List;

public class SearchHistoryResponse {
    List<SearchResult> data;
    private int count;
    private int total;
    private int page;
    private int pageCount;

    public List<SearchResult> getData() {
        return data;
    }

    public void setData(List<SearchResult> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
