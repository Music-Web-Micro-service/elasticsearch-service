package com.freemusic.elasticsearchservice.mappers;

import com.freemusic.elasticsearchservice.documents.TrackDocument;
import com.freemusic.elasticsearchservice.messages.TrackMessageToES;

public class TrackMessageMapper {
    public static TrackDocument mapToDocument(TrackMessageToES message) {
        TrackDocument document = new TrackDocument();
        document.setTrackId(message.getTrackId());
        document.setTrackName(message.getTrackName());
        document.setArtistName(message.getArtistName());
        document.setDuration(message.getDuration());
        return document;
    }
}
