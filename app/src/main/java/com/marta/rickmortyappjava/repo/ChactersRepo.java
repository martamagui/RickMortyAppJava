package com.marta.rickmortyappjava.repo;

import androidx.lifecycle.MutableLiveData;

import com.marta.rickmortyappjava.api.NetworkObj;
import com.marta.rickmortyappjava.api.NetworkService;
import com.marta.rickmortyappjava.api.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ChactersRepo {

    public MutableLiveData<Response> requestCharcters() {
        final MutableLiveData<Response> mutableLiveData = new MutableLiveData<>();
        NetworkService service = new NetworkObj().getInstance().getService();
        service.getCharacters().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful() && response.body()!=null){
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                System.out.println("Error");
            }
        });
        return mutableLiveData;
    }

}
