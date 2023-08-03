package com.freemusic.elasticsearchservice.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Jackson Chen
 * @version 1.0
 * @date 2023/7/18
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document(indexName = "playlists")
public class TrackDocument {
    @Id
    private String id;
    @Field(type = FieldType.Keyword, index = false)
    private Integer trackId;
    @Field(type = FieldType.Text)
    private String trackName;
    @Field(type = FieldType.Text)
    private String artistName;
    @Field(type = FieldType.Double, index = false)
    private Double duration;
}
