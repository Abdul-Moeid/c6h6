package com.example.foodapp.ViewHolder;

import android.text.Layout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;

public class CatagoryViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView price;
    public RelativeLayout layout;
    public CatagoryViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.foodname);
        price = (TextView) itemView.findViewById(R.id.price);
        layout = itemView.findViewById(R.id.layout);
    }
}
