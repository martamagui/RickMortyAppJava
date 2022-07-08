package com.marta.rickmortyappjava.api;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkObj {
    private NetworkObj myNetWorkObj = null;
    public static final String BASE_URL = "https://rickandmortyapi.com/api/";
    private NetworkService service;
    private OkHttpClient client;

    private NetworkObj() {
        buildClient();
        buildRetrofit();
    }

    public NetworkObj getInstance() {
        if (myNetWorkObj == null) {
            myNetWorkObj = new NetworkObj();
        }
        return myNetWorkObj;
    }

    private void buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.service = retrofit.create(NetworkService.class);
    }

    private HttpLoggingInterceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    private void buildClient() {
        client = new OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .build();
    }

    public NetworkService getService() {
        return this.service;
    }
}
