package com.guidev.futeapi.repository;

import com.guidev.futeapi.model.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FutebolApiRepository extends JpaRepository<League, Long> {
    
}
