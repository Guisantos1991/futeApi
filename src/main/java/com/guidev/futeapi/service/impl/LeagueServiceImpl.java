package com.guidev.futeapi.service.impl;

import com.guidev.futeapi.client.ApiSports;
import com.guidev.futeapi.dto.apisportsdto.FootballApiResponse;
import com.guidev.futeapi.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService {

    private final ApiSports apiSports;

    @Override
    public FootballApiResponse getLeagues() {
        return apiSports.getLeagues();
    }
}
