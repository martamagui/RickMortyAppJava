package com.marta.rickmortyappjava.ui.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.DiffUtil;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.marta.rickmortyappjava.R;
import com.marta.rickmortyappjava.api.model.ResultResponse;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    ArrayList<ResultResponse> characterList;

    public CharacterAdapter(ArrayList<ResultResponse> characterList) {
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public CharacterAdapter.CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, null, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.CharacterViewHolder holder, int position) {
        holder.setCharacter(characterList.get(position));
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView gender;
        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            gender = (TextView) itemView.findViewById(R.id.tv_gender_value);
        }

        public void setCharacter(ResultResponse resultResponse) {
            name.setText(resultResponse.getName());
            gender.setText(resultResponse.getGender());
        }
    }
}


