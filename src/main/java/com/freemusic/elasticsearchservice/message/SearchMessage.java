package com.freemusic.elasticsearchservice.message;

import lombok.Data;

@Data
public class SearchMessage extends PageMessage {
    String searchWord;
}
