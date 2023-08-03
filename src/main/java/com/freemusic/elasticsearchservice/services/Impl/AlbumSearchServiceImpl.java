package com.freemusic.elasticsearchservice.services.Impl;

import com.freemusic.elasticsearchservice.documents.AlbumDocument;
import com.freemusic.elasticsearchservice.repositories.AlbumSearchRepository;
import com.freemusic.elasticsearchservice.services.AlbumSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumSearchServiceImpl implements AlbumSearchService {
    @Autowired
    private AlbumSearchRepository albumSearchRepository;

    @Override
    public AlbumDocument createAlbumDocument(AlbumDocument albumDocument) {
        return albumSearchRepository.save(albumDocument);
    }

    @Override
    public Optional<AlbumDocument> getAlbumDocument(int albumDocumentId) {
        return albumSearchRepository.findById(albumDocumentId);
    }
    @Override
    public AlbumDocument updateAlbumDocument(AlbumDocument albumDocument) {
        return albumSearchRepository.save(albumDocument);
    }

    @Override
    public void deleteAlbumDocument(int albumDocumentId) {
        albumSearchRepository.deleteById(albumDocumentId);
    }

    @Override
    public List<AlbumDocument> searchAlbumsByTitle(String title, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return albumSearchRepository.findByTitle(title, pageable);
    }

    @Override
    public List<AlbumDocument> searchAlbumsByArtistName(String artistName, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return albumSearchRepository.findByArtistName(artistName, pageable);
    }
}
