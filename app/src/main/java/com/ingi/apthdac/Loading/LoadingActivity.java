package com.ingi.apthdac.Loading;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ingi.apthdac.R;
import com.ingi.apthdac.databinding.ActivityLoadingBinding;

import lombok.Getter;
import lombok.Setter;

public class LoadingActivity extends AppCompatActivity implements LoadingView {
    ActivityLoadingBinding binding;
    LoadingPresenter loadingPresenter;

    @Getter @Setter
    private String id = "ID";

    @Getter @Setter
    private String password = "PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingPresenter = new LoadingPresenter();

        binding =  DataBindingUtil.setContentView(this, R.layout.activity_loading);
        binding.setActivity(this);
        binding.setPresenter(loadingPresenter);
        binding.setView(this);

//        loadingPresenter.setLoginManager(Managers.getInstance().getLoginManager());
//        if(loadingPresenter.requestLogin("", "")) {
//            Toast.makeText(this, "Login succeed", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show();
//        }
    }

    public void onLoginClick(View view) {
        Toast.makeText(this, "Login button clicked!! id = " + id + ", pass = " + password, Toast.LENGTH_LONG).show();
    }
}
