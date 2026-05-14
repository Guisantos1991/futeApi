package com.guidev.futeapi.client;

import com.guidev.futeapi.dto.apisportsdto.FootballApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ApiSports {

    private static final String URL = "https://v3.football.api-sports.io";
    private static final String HEADER_NAME = "x-apisports-key";
    private final RestClient restClient;

    public ApiSports(@Value("${api.x-apisports-key}") String apiKey) {
        this.restClient = RestClient
                .builder()
                .baseUrl(URL)
                .defaultHeader(HEADER_NAME, apiKey)
                .build();
    }

    public FootballApiResponse getLeagues() {
        return restClient.get()
                .uri("/leagues")
                .retrieve()
                .body(FootballApiResponse.class);
    }
}
