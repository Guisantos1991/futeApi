package com.guidev.futeapi.client;

import com.guidev.futeapi.dto.FootballApiResponse;
import com.guidev.futeapi.model.League;
import com.guidev.futeapi.dto.LeagueItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class FootballApiClient {

    private static final String URL = "https://v3.football.api-sports.io";
    private static final String HEADER_NAME = "x-apisports-key";
    private final RestClient restClient;

    public FootballApiClient(@Value("${api.x-apisports-key}") String apiKey) {
        this.restClient = RestClient
                .builder()
                .baseUrl(URL)
                .defaultHeader(HEADER_NAME, apiKey)
                .build();
    }

    public List<League> getLeagues() {
        FootballApiResponse apiResponse = restClient.get()
                .uri("/leagues")
                .retrieve()
                .body(FootballApiResponse.class);

        return apiResponse.response().stream()
                .map(LeagueItem::league)
                .toList();
    }

}
