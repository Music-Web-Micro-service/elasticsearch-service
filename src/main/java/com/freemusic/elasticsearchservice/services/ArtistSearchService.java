package com.freemusic.elasticsearchservice.services;

import com.freemusic.elasticsearchservice.documents.ArtistDocument;

import java.util.List;
import java.util.Optional;

public interface ArtistSearchService {
    public ArtistDocument createArtistDocument(ArtistDocument artistDocument) ;

    public Optional<ArtistDocument> getArtistDocument(int artistDocumentId);

    public ArtistDocument updateArtistDocument(ArtistDocument artistDocument);

    public void deleteArtistDocument(int artistDocumentId);

    public List<ArtistDocument> search(String query, int offset, int limit);
}
