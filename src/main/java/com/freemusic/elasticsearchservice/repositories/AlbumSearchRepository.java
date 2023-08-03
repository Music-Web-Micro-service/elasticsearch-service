package com.freemusic.elasticsearchservice.repositories;

import com.freemusic.elasticsearchservice.documents.AlbumDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlbumSearchRepository extends ElasticsearchRepository<AlbumDocument, Integer> {

    @Query("{\"match\": {\"title\": {\"query\": \"?0\", \"operator\": \"and\", \"fuzziness\": \"AUTO\"}}}")
    List<AlbumDocument> findByTitle(String title, Pageable pageable);

    @Query("{\"match\": {\"artistName\": {\"query\": \"?0\", \"operator\": \"and\", \"fuzziness\": \"AUTO\"}}}")
    List<AlbumDocument> findByArtistName(String artistName, Pageable pageable);
}
