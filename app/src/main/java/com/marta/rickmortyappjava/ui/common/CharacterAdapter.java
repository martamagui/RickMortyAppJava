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

public class CharacterAdapter extends ListAdapter<ResultResponse, MyViewHolder> {

    public CharacterAdapter(@NonNull DiffUtil.ItemCallback<ResultResponse> DIFF_CALLBACK) {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        ResultResponse character = getItem(position);
        holder.bind(character.getName());
    }

    public static class DIFF_CALLBACK extends DiffUtil.ItemCallback<ResultResponse> {
        @Override
        public boolean areItemsTheSame(@NonNull ResultResponse oldItem, @NonNull ResultResponse newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ResultResponse oldItem, @NonNull ResultResponse newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    };
}


