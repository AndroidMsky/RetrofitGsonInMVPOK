package com.example.liangmutian.retrofitgsoninmvp.presenter;

import com.example.liangmutian.retrofitgsoninmvp.bean.ReBean;
import com.example.liangmutian.retrofitgsoninmvp.network.Generator;
import com.example.liangmutian.retrofitgsoninmvp.network.TestApi;
import com.example.liangmutian.retrofitgsoninmvp.view.MainView;
import com.networkbench.com.google.gson.Gson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wuduogen838 on 16/10/21.
 */

public class MainPresenter {

    private MainView mMainView;

    public MainPresenter(MainView mMainView) {
        this.mMainView = mMainView;
    }

    public void get(String id, String key) {
        TestApi api = Generator.createService(TestApi.class);
        Call<ResponseBody> call = api.get(id, key);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String msg = response.body().string();
                    String s = "{" +
                            "mts:'1585078'," +
                            "province:'江苏'," +
                            "catName:'中国移动'," +
                            "telString:'15850781443'," +
                            "tareaVid:'30511'," +
                            "tispVid:'3236139'," +
                            "tcarrier:'江苏移动'" +
                            "}";
//由于接口请求的json数据不规范,暂时用本地Gson来解析数据 如果json规范用msg 代替s即可
                    Gson gson = new Gson();
                    ReBean reBean = gson.fromJson(s, ReBean.class);
                    mMainView.success(reBean);

                } catch (Exception e) {
                    e.printStackTrace();
                    mMainView.fail("fail");
                }
            }

            @Override
            public void onFailure(Call call, Throwable throwable) {
                mMainView.fail("fail");
            }
        });
    }

}
