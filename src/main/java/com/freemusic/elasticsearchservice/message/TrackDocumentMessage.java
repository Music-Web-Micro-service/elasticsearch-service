package com.freemusic.elasticsearchservice.message;

import lombok.Data;

/**
 * @author Jackson Chen
 * @version 1.0
 * @date 2023/7/18
 */
@Data
public class TrackDocumentMessage extends PageMessage{
    String searchContent;
}
