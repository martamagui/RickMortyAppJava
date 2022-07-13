package com.marta.rickmortyappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.marta.rickmortyappjava.R;
import com.marta.rickmortyappjava.api.model.ResultResponse;
import com.marta.rickmortyappjava.ui.MainViewModel;
import com.marta.rickmortyappjava.ui.common.CharacterAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CharacterAdapter adapter;
    MainViewModel viewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setList();
    }

    private void setRV(ArrayList<ResultResponse> results) {
        adapter = new CharacterAdapter(results);
        adapter.notifyDataSetChanged();
        recyclerView = (RecyclerView) findViewById(R.id.rv_characters);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    private void setList() {
        viewModel.getCharacters().observe(this, response -> {
            if (response != null) {
                setRV(response.getResults());
            }
        });
    }
}