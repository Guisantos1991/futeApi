package com.guidev.futeapi.service;

import com.guidev.futeapi.dto.apisportsdto.FootballApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface ApiSportsImporter {
    public void importData(FootballApiResponse footballApiResponse);
}
