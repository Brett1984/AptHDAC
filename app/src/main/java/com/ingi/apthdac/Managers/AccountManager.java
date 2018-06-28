package com.ingi.apthdac.Managers;

import lombok.Data;

public @Data class AccountManager {
    protected AccountManager(){
    }

    String id;
    String displayName;
    String currentCoin;
    String emailAddress;
}
