package com.ingi.apthdac.scenes.signup;

import android.os.Bundle;

import com.ingi.apthdac.R;
import com.ingi.apthdac.common.BaseActivity;
import com.ingi.apthdac.common.models.SignUpForm;

public class SignUpActivity extends BaseActivity implements SignUpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    @Override
    public void bindSignupForm(SignUpForm signUpForm) {

    }
}
