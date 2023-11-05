package com.freemusic.elasticsearchservice.controllers;

import com.freemusic.elasticsearchservice.documents.TrackDocument;
import com.freemusic.elasticsearchservice.messages.SearchMessage;
import com.freemusic.elasticsearchservice.services.TrackDocumentService;
import jakarta.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackDocumentController {

    private TrackDocumentService trackDocumentService;

    @Autowired
    public void TrackDocumentController(TrackDocumentService trackDocumentService) {
        this.trackDocumentService = trackDocumentService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<TrackDocument>> searchTrack(
            @RequestBody
            SearchMessage request) {
        if (request.getSearchWord() == null) {
            return ResponseEntity.noContent().build();
        }
        String content = request.getSearchWord();
        List<TrackDocument> tracks = trackDocumentService.searchTracks(content);
        return ResponseEntity.status(HttpStatus.OK).body(tracks);

    }

    //TODO after deploy need to delete
    @GetMapping("/search/all")
    public ResponseEntity<List<TrackDocument>> getAllTracks() {
        List<TrackDocument> tracks = trackDocumentService.getAllTrackDocument();
        return ResponseEntity.status(HttpStatus.OK).body(tracks);

    }

    @PostMapping
    public ResponseEntity<TrackDocument> saveTrackDocument(@RequestBody TrackDocument trackDocument) {
        TrackDocument savedTrackDocument = trackDocumentService.saveTrackDocument(trackDocument);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrackDocument);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackDocument> getTrackDocumentById(@PathVariable("id") String id) {
        TrackDocument trackDocument = trackDocumentService.getTrackDocumentById(id);
        if (trackDocument == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trackDocument);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrackDocument(@PathVariable("id") String id) {
        TrackDocument trackDocument = trackDocumentService.getTrackDocumentById(id);
        if (trackDocument == null) {
            return ResponseEntity.notFound().build();
        }
        trackDocumentService.deleteTrackDocument(id);
        return ResponseEntity.noContent().build();
    }
}
