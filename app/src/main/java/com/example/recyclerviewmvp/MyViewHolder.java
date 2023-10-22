package com.example.recyclerviewmvp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, emailView, delete, update;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.name);
        emailView = itemView.findViewById(R.id.email);
        delete = itemView.findViewById(R.id.delete);
        update = itemView.findViewById(R.id.update);
    }
}
