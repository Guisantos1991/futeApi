package com.guidev.futeapi.service;

import com.guidev.futeapi.dto.authdto.FootballAuthData;
import com.guidev.futeapi.model.AuthKey;
import org.springframework.stereotype.Service;

@Service
public interface AuthKeyService {
    FootballAuthData createAuthKey(AuthKey authKey);
    AuthKey getAuthKey(Long id);
}
