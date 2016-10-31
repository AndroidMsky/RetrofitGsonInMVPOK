package com.example.liangmutian.retrofitgsoninmvp.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by lmt on 16/10/18.
 */

public class Generator {
    public static final String API_BASE_URL = "https://api.heweather.com";

    public static int DEFAULT_TIMEOUT = 10;


    public static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build();
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
          //  .addConverterFactory(new StringConverterFactory())
            .client(client)
            .build();

    public static void ChangeURl(String url) {


        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(new StringConverterFactory())
                .client(client)
                .build();
    }


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }


}
