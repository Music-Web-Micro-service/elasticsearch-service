package com.freemusic.elasticsearchservice.services.Impl;

import com.freemusic.elasticsearchservice.documents.ArtistDocument;
import com.freemusic.elasticsearchservice.repositories.ArtistSearchRepository;
import com.freemusic.elasticsearchservice.services.ArtistSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistSearchServiceImpl implements ArtistSearchService {

    @Autowired
    private ArtistSearchRepository artistSearchRepository;

    @Override
    public ArtistDocument createArtistDocument(ArtistDocument artistDocument) {
        return artistSearchRepository.save(artistDocument);
    }

    @Override
    public Optional<ArtistDocument> getArtistDocument(int artistDocumentId) {
        return artistSearchRepository.findById(artistDocumentId);
    }
    @Override
    public ArtistDocument updateArtistDocument(ArtistDocument artistDocument) {
        return artistSearchRepository.save(artistDocument);
    }

    @Override
    public void deleteArtistDocument(int artistDocumentId) {
        artistSearchRepository.deleteById(artistDocumentId);
    }

    public List<ArtistDocument> search(String query, int offset, int limit) {
        PageRequest pageRequest = PageRequest.of(offset, limit);
        return artistSearchRepository.findByNameContaining(query, pageRequest);
    }
}
