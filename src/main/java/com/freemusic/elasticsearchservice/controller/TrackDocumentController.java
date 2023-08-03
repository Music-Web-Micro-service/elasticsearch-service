package com.freemusic.elasticsearchservice.controller;

import com.freemusic.elasticsearchservice.document.TrackDocument;
import com.freemusic.elasticsearchservice.message.TrackDocumentMessage;
import com.freemusic.elasticsearchservice.service.TrackDocumentService;
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
            TrackDocumentMessage request) {
        if (request.getSearchContent() == null) {
            return ResponseEntity.noContent().build();
        }
        String content = request.getSearchContent();
        List<TrackDocument> tracks = trackDocumentService.searchTracks(content);
        return ResponseEntity.status(HttpStatus.OK).body(tracks);

    }

    //TODO 上线时候需要删掉
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
