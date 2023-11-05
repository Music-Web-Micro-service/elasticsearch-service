package com.freemusic.elasticsearchservice.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "artists")
public class ArtistDocument {
    @Id
    private int artistId;

    private int imageId;

    @Field(type = FieldType.Text)
    private String name;
}
