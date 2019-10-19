package com.example.listview;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView textViewname,textViewid;

    public MyViewHolder(View itemView) {
        super(itemView);
        textViewname= itemView.findViewById(R.id.txtname);
        textViewid=itemView.findViewById(R.id.txtid);
    }

}
