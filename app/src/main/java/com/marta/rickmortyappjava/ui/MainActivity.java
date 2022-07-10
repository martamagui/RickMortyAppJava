package com.marta.rickmortyappjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.util.Log;

import com.marta.rickmortyappjava.R;
import com.marta.rickmortyappjava.api.model.Response;
import com.marta.rickmortyappjava.api.model.ResultResponse;
import com.marta.rickmortyappjava.databinding.ActivityMainBinding;
import com.marta.rickmortyappjava.ui.common.CharacterAdapter;

import java.util.ArrayList;
import java.util.List;

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
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setList();
    }

    private void setRV() {
        List<ResultResponse> list = new ArrayList<>();
        list.add(new ResultResponse(1, "pepe"));
        list.add(new ResultResponse(3, "pepeqq"));
        list.add(new ResultResponse(2, "pepqe"));
        adapter = new CharacterAdapter(new CharacterAdapter.DIFF_CALLBACK());
        adapter.submitList(list);
        binding.rvCharacters.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
        binding.rvCharacters.setAdapter(adapter);
    }

    private void setList() {
        viewModel.getCharacters().observe(this, response -> {
            if (response != null) {
                Log.e("HIII", response.getResults().get(0).getName() + "");
                adapter.submitList(response.getResults());
                adapter.notifyDataSetChanged();
            }
        });
    }
}