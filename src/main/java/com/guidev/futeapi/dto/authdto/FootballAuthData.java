package com.guidev.futeapi.dto.authdto;

import com.guidev.futeapi.model.AuthKey;

public record FootballAuthData (Long id, String userName) {
    public static FootballAuthData fromEntity(AuthKey authKey) {
        return new FootballAuthData(authKey.getId(), authKey.getUserName());
    }
}
