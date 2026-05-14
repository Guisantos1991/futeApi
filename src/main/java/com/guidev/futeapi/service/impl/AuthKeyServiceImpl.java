package com.guidev.futeapi.service.impl;

import com.guidev.futeapi.dto.authdto.FootballAuthData;
import com.guidev.futeapi.model.AuthKey;
import com.guidev.futeapi.repository.FootballAuthRepository;
import com.guidev.futeapi.service.AuthKeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthKeyServiceImpl implements AuthKeyService {
    private final FootballAuthRepository authRepository;

    public FootballAuthData createAuthKey(AuthKey authKey) {
        AuthKey savedAuthKey = authRepository.save(authKey);
        return FootballAuthData.fromEntity(savedAuthKey);
    }

    @Override
    public AuthKey getAuthKey(Long id) {
        return authRepository.findById(id).orElseThrow(() -> new RuntimeException("AuthKey not found with id: " + id));
    }

    public FootballAuthData findAuthKey (String userName) {
        return authRepository.findByUserName(userName);
    }
}
