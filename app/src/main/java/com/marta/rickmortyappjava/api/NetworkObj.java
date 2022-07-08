package com.marta.rickmortyappjava.api;

import retrofit2.Retrofit;

public class NetworkObj {
    private NetworkObj myNetWorkObj = null;
    public static final String BASE_URL = "https://rickandmortyapi.com/api/";
    private NetworkService service;

    public NetworkObj getInstance() {
        if (myNetWorkObj == null) {
            myNetWorkObj = new NetworkObj();
        }
        return myNetWorkObj;
    }

    private NetworkObj() {
        buildRetrofit();
    }

    private void buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
        this.service = retrofit.create(NetworkService.class);
    }

    public NetworkService getService() {
        return this.service;
    }
}
