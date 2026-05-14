package com.guidev.futeapi.repository;

import com.guidev.futeapi.dto.apisportsdto.LeagueItem;
import com.guidev.futeapi.model.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiSportsRepository extends JpaRepository<League, Long> {
    
}
