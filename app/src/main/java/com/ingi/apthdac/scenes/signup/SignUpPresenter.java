package com.ingi.apthdac.scenes.signup;

import com.ingi.apthdac.common.Presenter;
import com.ingi.apthdac.common.SimpleFunction;
import com.ingi.apthdac.common.managers.Managers;
import com.ingi.apthdac.common.models.SignUpForm;

import lombok.Getter;

public class SignUpPresenter implements Presenter<SignUpView> {
    SignUpView signUpView;
    @Getter SignUpForm signUpForm;

    @Override
    public void attachView(SignUpView signUpView) {
        this.signUpView = signUpView;
        this.signUpForm = new SignUpForm();

        signUpView.bindSignupForm(signUpForm);
    }

    @Override
    public void detachView() {
        this.signUpView = null;
    }

    @Override
    public void destroy() {
        if(this.signUpView != null)
            detachView();
    }

    public void signup(SimpleFunction onSuccess, SimpleFunction onFail) {
        if(Managers.getInstance().getSignUpManager().requestSignUp(signUpForm))
            onSuccess.run();
        else
            onFail.run();
    }
}
