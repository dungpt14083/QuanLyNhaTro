package com.example.quanlynhatro.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quanlynhatro.DetailTro;
import com.example.quanlynhatro.R;
import com.example.quanlynhatro.quanly.NhaTro;

import java.util.List;

public class NhaTroAdapter extends RecyclerView.Adapter<NhaTroAdapter.ViewHolder> {
   Context context;
   List<NhaTro> nhaTroList;

    public NhaTroAdapter(Context context, List<NhaTro> nhaTroList) {
        this.context = context;
        this.nhaTroList = nhaTroList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_danhsach,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NhaTro nhaTros = nhaTroList.get(position);
        if(nhaTros == null)
        {
            return;
        }
//        Glide.with(holder.imgTro.getContext()).load(nhaTros.getHinhanh()).into(holder.imgTro);
        holder.tvtest.setText(nhaTros.getTenphong());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTro.class);
                Bundle bundle = new Bundle();
                bundle.putString("tenphong",nhaTros.getTenphong());
                bundle.putInt("tinhtrang",nhaTros.getTinhtrang());
                bundle.putString("giaphong",nhaTros.getGiaphong());
                bundle.putString("mota",nhaTros.getMota());
//                bundle.putString("hinhanh",nhaTros.getHinhanh());
                intent.putExtras(bundle);
                context.startActivity(intent);
                //thanhcong

            }
        });

    }

    @Override
    public int getItemCount() {
        return nhaTroList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTro;
        CardView cardView;
        TextView tvtest;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imgTro = itemView.findViewById(R.id.img_danhsach);
            cardView = itemView.findViewById(R.id.cardviewds);
            tvtest = itemView.findViewById(R.id.tvChiTiet);
        }
    }
}
