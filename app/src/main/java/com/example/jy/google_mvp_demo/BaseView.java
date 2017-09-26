package com.example.jy.google_mvp_demo;

/**
 * ProjectName:Google-MVP-Demo
 * Date:2017/9/26 0:07
 * Created by JY
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
