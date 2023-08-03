package com.freemusic.elasticsearchservice.messages;

import lombok.Data;

@Data
public class SearchMessage {
    String searchWord;

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
