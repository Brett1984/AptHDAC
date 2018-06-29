package com.ingi.apthdac.common.managers;

import lombok.Getter;

/**
 * 관리자 클래스들을 관리하기위한 클래스
 */
public class Managers {
    private static final Managers self = new Managers();
    public static Managers getInstance() {
        return self;
    }

    @Getter LoginManager loginManager;
    @Getter AccountManager accountManager;
    @Getter SignUpManager signUpManager;

    private Managers() {
        loginManager = new LoginManager();
        accountManager = new AccountManager();
        signUpManager = new SignUpManager();
    }
}
