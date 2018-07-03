package com.ingi.apthdac.scenes.firstScene;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.ingi.apthdac.R;
import com.ingi.apthdac.common.BaseActivity;
import com.ingi.apthdac.databinding.ActivityFirstBinding;
import com.ingi.apthdac.scenes.signin.SignInActivity;
import com.ingi.apthdac.scenes.signup.SignUpActivity;

public class FirstActivity extends BaseActivity implements FirstView {
    FirstPresenter presenter;
    ActivityFirstBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new FirstPresenter();
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_first);

        presenter.attachView(this);
        binding.setActivity(this);
        binding.setPresenter(presenter);
        binding.setView(this);
    }

    @Override
    public void onClickSignUp(View view) {
        // Toast.makeText(this, "on click sign up", Toast.LENGTH_SHORT).show();
        startActivityForResult(new Intent(this, SignUpActivity.class), 1000);
    }

    @Override
    public void onClickSignIn(View view) {
        // Toast.makeText(this, "on click sign in", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SignInActivity.class));
    }
}
