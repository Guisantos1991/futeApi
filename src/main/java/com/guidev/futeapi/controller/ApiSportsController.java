package com.guidev.futeapi.controller;

import com.guidev.futeapi.authorization.FootballAuth;
import com.guidev.futeapi.dto.apisportsdto.FootballApiResponse;
import com.guidev.futeapi.service.impl.ApiSportsImporterImpl;
import com.guidev.futeapi.service.impl.LeagueServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/external")
@RequiredArgsConstructor
@Slf4j
public class ApiSportsController {

    private final LeagueServiceImpl leagueService;
    private final ApiSportsImporterImpl apiSportsImporterImpl;
    private final FootballAuth footballAuth;

    @GetMapping("/leagues")
    public ResponseEntity<FootballApiResponse> getLeagues(@RequestHeader("authKey") String authKey) {
        log.info("Request received to get leagues from external API");

        if(!footballAuth.validateAuth(authKey)) {
            log.info("Auth Key {} not found, unauthorized", authKey);
            return ResponseEntity.status(401).build();
        }
        FootballApiResponse response = leagueService.getLeagues();
        log.info("Leagues fetched successfully from external API");
        return ok(response);
    }

    @PostMapping("/leaguesDb")
    public FootballApiResponse injectData() {
        log.info("Data has been injected from external API into DB");
        FootballApiResponse response = leagueService.getLeagues();
        apiSportsImporterImpl.importData(response);
        return response;
    }
}

