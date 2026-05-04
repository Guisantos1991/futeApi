package com.guidev.futeapi.controller;

import com.guidev.futeapi.client.FootballApiClient;
import com.guidev.futeapi.model.League;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/external")
@RequiredArgsConstructor
@Slf4j
public class ExternalController {


    private final FootballApiClient footballApiClient;

    @GetMapping("/leagues")
    public List<League> getLeagues() {
        log.info("Fetching leagues from external API");
        return footballApiClient.getLeagues();
    }
}

