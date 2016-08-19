package com.buddysearch.presentation.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.buddysearch.presentation.mvp.presenter.BasePresenter;
import com.buddysearch.presentation.mvp.view.View;

public abstract class BaseActivity<VIEW extends View, PRESENTER extends BasePresenter<VIEW>> extends AppCompatActivity {

    protected PRESENTER presenter;

    protected VIEW view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = initView();
        presenter.attachView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    protected abstract VIEW initView();

    protected abstract PRESENTER initPresenter();
}