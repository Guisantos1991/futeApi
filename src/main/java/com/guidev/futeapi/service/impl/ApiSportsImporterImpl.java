package com.guidev.futeapi.service.impl;

import com.guidev.futeapi.dto.apisportsdto.FootballApiResponse;
import com.guidev.futeapi.dto.apisportsdto.LeagueItem;
import com.guidev.futeapi.model.League;
import com.guidev.futeapi.repository.ApiSportsRepository;
import com.guidev.futeapi.service.ApiSportsImporter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiSportsImporterImpl implements ApiSportsImporter {
    private final ApiSportsRepository apiSportsRepository;

    public void importData(FootballApiResponse footballApiResponse) {
        List<League> leagues = footballApiResponse.response().stream()
                .map(LeagueItem::league)
                .toList();
        apiSportsRepository.saveAll(leagues);
    }

}
