package com.guidev.futeapi.controller;

import com.guidev.futeapi.dto.authdto.FootballAuthData;
import com.guidev.futeapi.model.AuthKey;
import com.guidev.futeapi.service.impl.AuthKeyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthKeyServiceImpl authKeyCreatorImpl;

    @PostMapping("/create")
    public FootballAuthData createAuthKey(@RequestBody AuthKey authKey) {
        return authKeyCreatorImpl.createAuthKey(authKey);
    }
}
