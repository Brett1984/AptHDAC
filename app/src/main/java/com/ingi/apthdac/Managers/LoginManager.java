package com.ingi.apthdac.Managers;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * 로그인 관리자
 */
public class LoginManager {

    /**
     * 로그인 처리 결과를 리턴하기 위한 콜백 정의
     */
    public interface LoginCallback {
        boolean result(boolean result);
    };

    ExecutorService loginWorker = Executors.newSingleThreadExecutor();

    protected LoginManager() {
    }

    /**
     * 로그인 처리를 비동기로 실행 함
     * @param id
     * @param pass
     * @param callback 로그인 결과를 받을 콜백 함수. 서브 스레드로 콜 되므로 메인 스레드에서 동작되지 않도록 주의
     */
    public void loginAsync (final String id, final String pass, final LoginCallback callback) {
        loginWorker.execute(()->callback.result(requestLogin(id, pass)));
    }

    /**
     * 로그인 처리를 동기로 실행 함
     * @param id
     * @param pass
     * @return
     */
    public boolean loginSync  (final String id, final String pass) {
        return true;
    }

    /**
     * 실제 로그인이 처리되는 함수
     * @param id
     * @param pass
     * @return
     */
    private boolean requestLogin(final String id, final String pass) {
        try {
            // TODO  로그인을 요청하는 실제 코드로 변경 해야 함
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }
}
