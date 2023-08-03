package com.freemusic.elasticsearchservice.message;

/**
 * @author Jackson Chen
 * @version 1.0
 * @date 2023/7/18
 */
public class PageMessage {
    int pageNum;

    int pageSize;

    public int getFromIndex(){
        if(this.pageNum < 1){
            return 0;
        }
        if(this.pageSize < 1){
            return 10;
        }
        return (this.pageNum-1) * this.pageSize;
    }
}
