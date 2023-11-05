package com.freemusic.elasticsearchservice.controllers;

import com.freemusic.elasticsearchservice.documents.AlbumDocument;
import com.freemusic.elasticsearchservice.messages.SearchMessage;
import com.freemusic.elasticsearchservice.services.AlbumSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumSearchController {
    @Autowired
    private AlbumSearchService albumSearchService;

    @PostMapping("/search")
    public List<AlbumDocument> search(@RequestBody SearchMessage searchMessage) {
        return albumSearchService.searchAlbumsByTitle(
                searchMessage.getSearchWord(),
                searchMessage.getFromIndex(),
                searchMessage.getPageSize()
        );
    }
}
