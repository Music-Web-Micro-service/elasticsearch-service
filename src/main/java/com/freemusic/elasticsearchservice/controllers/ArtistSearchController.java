package com.freemusic.elasticsearchservice.controllers;

import com.freemusic.elasticsearchservice.documents.ArtistDocument;
import com.freemusic.elasticsearchservice.messages.SearchMessage;
import com.freemusic.elasticsearchservice.services.ArtistSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistSearchController {

    @Autowired
    private ArtistSearchService artistService;

    @PostMapping("/search")
    public List<ArtistDocument> search(@RequestBody SearchMessage searchMessage) {
        return artistService.search(searchMessage.getSearchWord(),searchMessage.getFromIndex(), searchMessage.getPageSize());
    }
}
