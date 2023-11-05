package com.freemusic.elasticsearchservice.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freemusic.elasticsearchservice.documents.AlbumDocument;
import com.freemusic.elasticsearchservice.documents.ArtistDocument;
import com.freemusic.elasticsearchservice.documents.TrackDocument;
import com.freemusic.elasticsearchservice.mappers.TrackMessageMapper;
import com.freemusic.elasticsearchservice.messages.TrackMessageToES;
import com.freemusic.elasticsearchservice.services.AlbumSearchService;
import com.freemusic.elasticsearchservice.services.ArtistSearchService;
import com.freemusic.elasticsearchservice.services.TrackDocumentService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitListenerController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AlbumSearchService albumSearchService;

    @Autowired
    private ArtistSearchService artistService;

    @Autowired
    private TrackDocumentService trackDocumentService;

//    @RabbitListener(queues = "ElasticSearchQueue")
//    public void receiveMusicInfo(Message message) {
//        try {
//            JsonNode jsonNode = objectMapper.readTree(message.getBody());
//
//            if (jsonNode.has("trackId")) {
//                // Assuming if it has trackId, it's a TrackMessageToES
//                TrackMessageToES trackInfo = objectMapper.treeToValue(jsonNode, TrackMessageToES.class);
//                TrackDocument trackDocument = TrackMessageMapper.mapToDocument(trackInfo);
//                trackDocumentService.saveTrackDocument(trackDocument);
//
//            } else if (jsonNode.has("albumId")) {
//                AlbumDocument albumDocument = objectMapper.treeToValue(jsonNode, AlbumDocument.class);
//                albumSearchService.saveAlbumDocument(albumDocument);
//            } else if (jsonNode.has("artistId")) {
//                ArtistDocument artistDocument = objectMapper.treeToValue(jsonNode, ArtistDocument.class);
//                artistService.saveArtistDocument(artistDocument);
//            } else {
//                // Unrecognized message format
//                System.out.println("Received an unrecognized message format: " + new String(message.getBody()));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @RabbitListener(queues = "ElasticSearchQueue")
    public void receiveMusicInfo(TrackMessageToES trackInfo) {
        try {
            TrackDocument trackDocument = TrackMessageMapper.mapToDocument(trackInfo);
            trackDocumentService.saveTrackDocument(trackDocument);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
