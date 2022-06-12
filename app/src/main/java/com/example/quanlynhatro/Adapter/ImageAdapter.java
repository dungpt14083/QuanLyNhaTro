package com.example.quanlynhatro.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quanlynhatro.R;
import com.example.quanlynhatro.quanly.NhaTro;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {
    Context context;
    ArrayList<String> list;

    public ImageAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ImageAdapter.ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image,parent,false);

        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageHolder holder, int position) {
        for (int i = 0 ; i< list.size();i++){
            Glide.with(context).load("http://192.168.0.105:8080"+list.get(i)).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ImageHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagePhong);
        }
    }
}


