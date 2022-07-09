package com.marta.rickmortyappjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.util.Log;

import com.marta.rickmortyappjava.R;
import com.marta.rickmortyappjava.api.model.Response;
import com.marta.rickmortyappjava.databinding.ActivityMainBinding;
import com.marta.rickmortyappjava.ui.common.CharacterAdapter;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    CharacterAdapter adapter;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setRV();
        viewModel = new MainViewModel();
        viewModel.getCharacters().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if(response != null){
                    Log.e("HIII", response.getResults().get(0).getName() +"");
                    adapter = new CharacterAdapter(response.getResults());
                }
            }
        });
    }

    private void setRV(){
        binding.rvCharacters.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCharacters.setAdapter(adapter);
    }
}