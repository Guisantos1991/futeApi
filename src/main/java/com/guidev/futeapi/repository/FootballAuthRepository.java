package com.guidev.futeapi.repository;

import com.guidev.futeapi.dto.authdto.FootballAuthData;
import com.guidev.futeapi.model.AuthKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FootballAuthRepository extends JpaRepository<AuthKey, Long> {
    FootballAuthData findByUserName (String userName);
}
