package com.freemusic.elasticsearchservice.service;

import com.freemusic.elasticsearchservice.document.TrackDocument;

import java.util.List;

public interface TrackDocumentService {

    // Create or Update
    TrackDocument saveTrackDocument(TrackDocument trackDocument);

    // Read
    TrackDocument getTrackDocumentById(String id);
    List<TrackDocument> searchTracks(String keyword);

    // Delete
    void deleteTrackDocument(String id);
    List<TrackDocument> getAllTrackDocument();
}
