package com.freemusic.elasticsearchservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableRabbit
public class ElasticsearchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchServiceApplication.class, args);
    }

}
