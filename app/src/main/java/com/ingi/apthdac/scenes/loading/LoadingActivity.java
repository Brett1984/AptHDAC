package com.ingi.apthdac.scenes.loading;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ingi.apthdac.CoreApplication;
import com.ingi.apthdac.SharedPreferencesManager;
import com.ingi.apthdac.common.BaseActivity;
import com.ingi.apthdac.common.managers.Managers;
import com.ingi.apthdac.R;
import com.ingi.apthdac.common.models.LoginInformation;
import com.ingi.apthdac.databinding.ActivityLoadingBinding;

public class LoadingActivity extends BaseActivity implements LoadingView {
    ActivityLoadingBinding binding;
    LoadingPresenter loadingPresenter;
    LoginInformation information;
    CoreApplication coreApplication;
    SharedPreferencesManager sharedPreferencesManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        information = Managers.getInstance().getLoginManager().getLoginInformation();
        coreApplication = (CoreApplication)getApplicationContext();
        sharedPreferencesManager = coreApplication.getSharedPreferencesManager();

        loadingPresenter = new LoadingPresenter();
        loadingPresenter.setLoginManager(Managers.getInstance().getLoginManager());
        LoginInformation information = Managers.getInstance().getLoginManager().getLoginInformation();
        information.setId(sharedPreferencesManager.getString("ID", ""));
        information.setPassword(sharedPreferencesManager.getString("PASSWORD", ""));

        binding =  DataBindingUtil.setContentView(this, R.layout.activity_loading);
        binding.setActivity(this);
        binding.setPresenter(loadingPresenter);
        binding.setView(this);
        binding.setLoginInformation(loadingPresenter.getLoginInformation());
    }

    public void onLoginClick(View view) {
        if(loadingPresenter.requestLogin()) {
            sharedPreferencesManager.setString("ID", information.getId());
            sharedPreferencesManager.setString("PASSWORD", information.getPassword());
            Toast.makeText(this, "Login Succeed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSigninClick(View view) {

    }
}
