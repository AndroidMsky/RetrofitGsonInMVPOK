package com.example.liangmutian.retrofitgsoninmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.liangmutian.retrofitgsoninmvp.bean.ReBean;
import com.example.liangmutian.retrofitgsoninmvp.presenter.MainPresenter;
import com.example.liangmutian.retrofitgsoninmvp.view.MainView;


public class MainActivity extends AppCompatActivity implements MainView {

    EditText mEditText;
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化presenter
        mMainPresenter = new MainPresenter(this);
        mEditText = (EditText) findViewById(R.id.editText);

    }

    public void getBaidu(View v) {

        mMainPresenter.get("CN101020100", "059dbfea2d2a4bd995b7ee9934f4425f");


    }


    @Override
    public void success(ReBean reBean) {
        mEditText.setText(reBean.mts);
    }

    @Override
    public void fail(String s) {
        mEditText.setText(s);

    }
}
