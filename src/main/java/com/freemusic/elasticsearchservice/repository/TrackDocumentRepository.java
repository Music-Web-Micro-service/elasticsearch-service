package com.freemusic.elasticsearchservice.repository;

import com.freemusic.elasticsearchservice.document.TrackDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jackson Chen
 * @version 1.0
 * @date 2023/7/18
 */
// @Repository
public interface TrackDocumentRepository extends ElasticsearchRepository<TrackDocument, String> {
    @Query("{\"bool\": {\"should\": [{\"match\": {\"trackName\": \"?0\"}}, {\"match\": {\"artistName\": \"?0\"}}]}}")
    List<TrackDocument> searchTracksByKeyword(String keyword);

}
