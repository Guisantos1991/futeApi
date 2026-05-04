package com.guidev.futeapi.service.impl;

import com.guidev.futeapi.client.FootballApiClient;
import com.guidev.futeapi.model.League;
import com.guidev.futeapi.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService {

    private final FootballApiClient footballApiClient;

    @Override
    public List<League> getLeagues() {

        List<League> leagues = new ArrayList<>();
        footballApiClient.getLeagues();

        return null;
    }
}
