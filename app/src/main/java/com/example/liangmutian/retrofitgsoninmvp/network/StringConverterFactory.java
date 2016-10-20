package com.example.liangmutian.retrofitgsoninmvp.network;

import android.util.Log;


import com.networkbench.com.google.gson.Gson;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by lmt on 16/10/18.
 */

public class StringConverterFactory extends  Converter.Factory{
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new ObjRequestBodyConverter();
    }

    static class ObjRequestBodyConverter implements Converter<Object, RequestBody> {
        @Override
        public RequestBody convert(Object obj) throws IOException {
            String json= new Gson().toJson(obj);
            Log.i("*******************", json);
            return RequestBody.create(MediaType.parse("application/json"),json);
        }
    }
}
