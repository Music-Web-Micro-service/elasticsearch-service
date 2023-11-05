package com.freemusic.elasticsearchservice.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;


@Configuration
public class ElasticsearchConfig extends ElasticsearchConfiguration {

    @Value("${elasticsearch.rest.uris}")
    String connectionUrl;

    @Value("${elasticsearch.rest.username}")
    String username;

    @Value("${elasticsearch.rest.password}")
    String password;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(connectionUrl)
                .withBasicAuth(username, password)
                .build();
    }
}



