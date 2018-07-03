package com.ingi.apthdac.scenes.signup;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ingi.apthdac.R;
import com.ingi.apthdac.common.BaseActivity;
import com.ingi.apthdac.common.models.SignUpForm;
import com.ingi.apthdac.databinding.ActivitySignUpBinding;

public class SignUpActivity extends BaseActivity implements SignUpView {
    ActivitySignUpBinding binding;
    SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new SignUpPresenter();
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        presenter.attachView(this);
        binding.setActivity(this);
        binding.setPresenter(presenter);
        binding.setView(this);
    }

    @Override
    public void onClickSignup(View view) {
        presenter.signup(()-> {
            finish();
            Toast.makeText(this, "Sing Up Succeed", Toast.LENGTH_LONG).show();
        }, ()->Toast.makeText(this, "Sing Up Failed", Toast.LENGTH_LONG).show());
    }

    @Override
    public void bindSignupForm(SignUpForm signUpForm) {
        binding.setSignupForm(signUpForm);
    }
}
