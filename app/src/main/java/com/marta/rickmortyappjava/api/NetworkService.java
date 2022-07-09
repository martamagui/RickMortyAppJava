package com.marta.rickmortyappjava.api;

import com.marta.rickmortyappjava.api.model.Response;
import com.marta.rickmortyappjava.api.model.ResultResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("character")
    Call<Response> getCharacters();
}
