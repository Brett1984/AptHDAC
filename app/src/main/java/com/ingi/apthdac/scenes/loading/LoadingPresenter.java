package com.ingi.apthdac.scenes.loading;

import com.ingi.apthdac.common.managers.LoginManager;
import com.ingi.apthdac.common.models.LoginInformation;
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

    public LoginInformation getLoginInformation() {
        return loginManager.getLoginInformation();
    }

    public boolean requestLogin() {
        LoginInformation information = loginManager.getLoginInformation();
        return loginManager.loginSync(information.getId(), information.getPassword());
    }
}
