package com.marta.rickmortyappjava.ui.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.marta.rickmortyappjava.R;
import com.marta.rickmortyappjava.api.model.ResultResponse;
import com.marta.rickmortyappjava.databinding.CardItemBinding;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private ArrayList<ResultResponse> charactersList;

    public CharacterAdapter(ArrayList<ResultResponse> charactersList) {
        this.charactersList = charactersList;
    }

    @NonNull
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardItemBinding binding = CardItemBinding.inflate(inflater, parent, false);
        return new ViewHolder((binding));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.ViewHolder holder, int position) {
        ResultResponse character = charactersList.get(position);
        holder.binding.tvName.setText(character.getName());
    }

    @Override
    public int getItemCount() {
        return charactersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardItemBinding binding;

        public ViewHolder(@NonNull CardItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
