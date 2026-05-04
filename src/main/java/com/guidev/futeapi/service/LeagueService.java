package com.guidev.futeapi.service;

import com.guidev.futeapi.model.League;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeagueService {
    public List<League> getLeagues();
}
