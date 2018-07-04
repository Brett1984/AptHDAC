package com.ingi.apthdac.scenes.trading;

import com.ingi.apthdac.common.Presenter;

public class TradingPresenter implements Presenter<TradingView> {
    TradingView tradingView;

    @Override
    public void attachView(TradingView tradingView) {
        this.tradingView = tradingView;
    }

    @Override
    public void detachView() {
        this.tradingView = null;
    }

    @Override
    public void destroy() {
        if(this.tradingView != null)
            detachView();
    }
}
