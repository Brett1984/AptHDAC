package com.ingi.apthdac.scenes.signin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.ingi.apthdac.R;
import com.ingi.apthdac.common.BaseActivity;
import com.ingi.apthdac.databinding.ActivitySignInBinding;
import com.ingi.apthdac.scenes.main.MainActivity;

public class SignInActivity extends BaseActivity implements SignInView{
    SignInPresenter presenter;
    ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new SignInPresenter();
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        presenter.attachView(this);
        binding.setActivity(this);
        binding.setPresenter(presenter);
        binding.setView(this);
    }

    @Override
    public void onClickSignIn(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}
