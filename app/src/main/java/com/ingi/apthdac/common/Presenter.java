package com.ingi.apthdac.common;

/**
 * Presenter 의 전신
 * @param <T>
 */
public interface Presenter<T extends View> {
    /**
     * Presenter 와 View 의 연결
     * @param t presenter 와 연결될 View
     */
    void attachView(T t);

    /**
     * 사용이 끝난 View 와 연결 해제
     */
    void detachView();

    void destroy();
}
