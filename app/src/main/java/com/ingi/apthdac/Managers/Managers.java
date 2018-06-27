package com.ingi.apthdac.Managers;

import lombok.Getter;

/**
 * 관리자 클래스들을 관리하기위한 클래스
 */
public class Managers {
    private static final Managers ourInstance = new Managers();
    public static Managers getInstance() {
        return ourInstance;
    }

    @Getter
    LoginManager loginManager;

    private Managers() {
        loginManager = new LoginManager();
    }
}
