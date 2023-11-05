package com.freemusic.elasticsearchservice.repositories;


import com.freemusic.elasticsearchservice.documents.ArtistDocument;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArtistSearchRepository extends ElasticsearchRepository<ArtistDocument, Integer> {
    @Query("{\"bool\": {\"should\": [{\"match_phrase_prefix\": {\"name\": \"?0\"}}, {\"fuzzy\": {\"name\": {\"value\": \"?0\", \"fuzziness\": 2}}}]}}")
    List<ArtistDocument> findByNameContaining(String name, Pageable pageable);
}
