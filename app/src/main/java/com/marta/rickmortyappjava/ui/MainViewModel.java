package com.marta.rickmortyappjava.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.marta.rickmortyappjava.api.model.Response;
import com.marta.rickmortyappjava.api.model.ResultResponse;
import com.marta.rickmortyappjava.repo.ChactersRepo;

import java.util.List;

public class MainViewModel extends ViewModel {
    private ChactersRepo chactersRepo;
    private MutableLiveData<Response> charactersLiveData;

    public MainViewModel(ChactersRepo chactersRepo) {
        this.chactersRepo = chactersRepo;
    }

    public LiveData<Response> getCharacters() {
        if (charactersLiveData == null) {
            charactersLiveData = chactersRepo.requestCharcters();
        }
        return charactersLiveData;
    }
}
