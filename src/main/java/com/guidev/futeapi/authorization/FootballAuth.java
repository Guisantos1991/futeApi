package com.guidev.futeapi.authorization;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FootballAuth {


    public boolean validateAuth(String authKey) {

            return true;
    }
}
