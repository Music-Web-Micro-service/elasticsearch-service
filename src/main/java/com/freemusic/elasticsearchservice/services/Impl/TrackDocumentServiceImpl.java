package com.freemusic.elasticsearchservice.services.impl;

import com.freemusic.elasticsearchservice.document.TrackDocument;
import com.freemusic.elasticsearchservice.repository.TrackDocumentRepository;
import com.freemusic.elasticsearchservice.service.TrackDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrackDocumentServiceImpl implements TrackDocumentService {

    private final TrackDocumentRepository trackDocumentRepository;

    @Autowired
    public TrackDocumentServiceImpl(TrackDocumentRepository trackDocumentRepository) {
        this.trackDocumentRepository = trackDocumentRepository;
    }

    @Override
    public TrackDocument saveTrackDocument(TrackDocument trackDocument) {
        return trackDocumentRepository.save(trackDocument);
    }

    @Override
    public TrackDocument getTrackDocumentById(String id) {
        Optional<TrackDocument> optionalTrackDocument = trackDocumentRepository.findById(id);
        return optionalTrackDocument.orElse(null);
    }

    @Override
    public List<TrackDocument> searchTracks(String keyword) {
        return trackDocumentRepository.searchTracksByKeyword(keyword);
    }

    @Override
    public void deleteTrackDocument(String id) {
        trackDocumentRepository.deleteById(id);
    }
    @Override
    public List<TrackDocument> getAllTrackDocument() {
        Iterable<TrackDocument> allTracksIterable = trackDocumentRepository.findAll();
        List<TrackDocument> allTracks = new ArrayList<>();
        allTracksIterable.forEach(allTracks::add);
        return allTracks;
    }
}
