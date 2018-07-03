package com.ingi.apthdac.scenes.signin;

import com.ingi.apthdac.common.Presenter;

public class SignInPresenter implements Presenter<SignInView> {
    SignInView signInView;

    @Override
    public void attachView(SignInView signInView) {
        this.signInView = signInView;
    }

    @Override
    public void detachView() {
        this.signInView = null;
    }

    @Override
    public void destroy() {
        if(this.signInView != null)
            detachView();
    }
}
