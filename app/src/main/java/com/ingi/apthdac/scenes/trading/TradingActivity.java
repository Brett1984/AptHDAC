package com.ingi.apthdac.scenes.trading;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.ingi.apthdac.R;
import com.ingi.apthdac.common.BaseActivity;
import com.ingi.apthdac.databinding.ActivityTradingBinding;

public class TradingActivity extends BaseActivity implements TradingView {
    TradingPresenter presenter;
    ActivityTradingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_trading);

        presenter = new TradingPresenter();
        presenter.attachView(this);
        binding.setActivity(this);
        binding.setPresenter(presenter);
        binding.setView(this);
    }

    @Override
    public void toggleButtons(View view) {
        if(view.getId() == R.id.byFavoriteRating) {
            view.setSelected(true);
            ((View)findViewById(R.id.byScore)).setSelected(false);
        } else if(view.getId() == R.id.byScore) {
            view.setSelected(true);
            ((View)findViewById(R.id.byFavoriteRating)).setSelected(false);
        }
    }

}
