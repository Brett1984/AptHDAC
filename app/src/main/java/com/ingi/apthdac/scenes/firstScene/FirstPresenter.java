package com.ingi.apthdac.scenes.firstScene;

import com.ingi.apthdac.common.Presenter;

public class FirstPresenter implements Presenter<FirstView> {
    FirstView firstView;

    @Override
    public void attachView(FirstView firstView) {
        this.firstView = firstView;
    }

    @Override
    public void detachView() {
        this.firstView = null;
    }

    @Override
    public void destroy() {
        if(this.firstView != null)
            detachView();
    }

}
