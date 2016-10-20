package com.example.liangmutian.retrofitgsoninmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.liangmutian.retrofitgsoninmvp.network.Generator;
import com.example.liangmutian.retrofitgsoninmvp.network.TestApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.editText);
    }

    public void getBaidu(View v) {

        get("CN101020100", "059dbfea2d2a4bd995b7ee9934f4425f");


    }

    public void get(String id, String key) {
        TestApi api = Generator.createService(TestApi.class);
        Call<ResponseBody> call = api.get(id, key);
        //addActView.showLoading(ISPApplication.mApplication.getString(R.string.loading_add));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String msg = response.body().string();
                    mEditText.setText("OK:"+msg);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, Throwable throwable) {

            }
        });
    }
}
