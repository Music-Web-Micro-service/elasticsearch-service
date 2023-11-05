package com.freemusic.elasticsearchservice.services;

import com.freemusic.elasticsearchservice.documents.AlbumDocument;

import java.util.List;
import java.util.Optional;

public interface AlbumSearchService {


    public AlbumDocument saveAlbumDocument(AlbumDocument albumDocument);

    public Optional<AlbumDocument> getAlbumDocument(int albumDocumentId);

    public AlbumDocument updateAlbumDocument(AlbumDocument albumDocument);

    public void deleteAlbumDocument(int albumDocumentId);

    public List<AlbumDocument> searchAlbumsByTitle(String title, int pageNum, int pageSize);

    public List<AlbumDocument> searchAlbumsByArtistName(String artistName, int pageNum, int pageSize);
}
