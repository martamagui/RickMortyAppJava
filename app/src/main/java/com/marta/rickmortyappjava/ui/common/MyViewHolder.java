package com.marta.rickmortyappjava.ui.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marta.rickmortyappjava.R;

class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;

    public MyViewHolder(@NonNull View v) {
        super(v);
        this.tvName = (TextView) v.findViewById(R.id.tv_name);
        tvName.setText("asedawe");
    }

    static MyViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view);
    }
    public void bind(String text) {
        tvName.setText(text);
    }
}