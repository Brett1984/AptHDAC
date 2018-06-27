package com.ingi.apthdac.Loading;

import com.ingi.apthdac.Managers.LoginManager;
import com.ingi.apthdac.common.Presenter;

import lombok.Setter;

public class LoadingPresenter implements Presenter<LoadingView> {
    @Setter LoginManager loginManager;

    private LoadingView loadingView;

    @Override
    public void attachView(LoadingView loadingView) {
        this.loadingView = loadingView;
    }

    @Override
    public void detachView() {
        // todo : View 에서 destroy 작업이 필요하면 여기에서 호출할 것
        this.loadingView = null;
    }

    @Override
    public void destroy() {
        loginManager = null;
        if(this.loadingView != null)
            detachView();
    }

    public boolean requestLogin(String id, String pass) {
        return loginManager.loginSync(id, pass);
    }
}
