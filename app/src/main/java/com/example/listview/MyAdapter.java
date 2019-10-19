package com.example.listview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private LayoutInflater mInflater;
    private List<student> mData = new ArrayList<>();

    public MyAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.mData.addAll(Listrepository.getInstance().getstudent());

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.view_holder, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // get
        List<student> items = Listrepository.getInstance().getstudent();

        // set attributes to the item
        holder.textViewname.setText(items.get(position).uname);


        holder.textViewid.setText(String.valueOf(items.get(position).uid));
    }

    @Override
    public int getItemCount() {
        return Listrepository.getInstance().getstudent().size();
    }

    public void update() {
        mData.clear();
        mData.addAll(Listrepository.getInstance().getstudent());
        notifyDataSetChanged();
    }
}
