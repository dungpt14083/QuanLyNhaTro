package com.example.quanlynhatro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlynhatro.Adapter.ImageAdapter;

import java.util.ArrayList;

public class DetailTro extends AppCompatActivity {
    TextView tvTenPhong,tvTinhTrang,tvGiaPhong,tvmoTa;
    RecyclerView listAnh;
    ImageAdapter imageAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_chitiet);
        tvTenPhong = findViewById(R.id.tv_chitiet_tenphong);
        tvTinhTrang = findViewById(R.id.tv_chitiet_tinhtrang);
        tvGiaPhong = findViewById(R.id.tv_chitiet_giatien);
        tvmoTa = findViewById(R.id.tv_chitiet_mota);
        listAnh = findViewById(R.id.listAnh);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            tvTenPhong.setText("Tên Phòng: "+bundle.getString("tenphong"));
            int tt = bundle.getInt("tinhtrang");
            if(tt==1)
            {
                tvTinhTrang.setText("Còn Phòng");
            }
            else if (tt==2){
                tvTinhTrang.setText("Hết Phòng");
            }

            tvGiaPhong.setText("Giá Phòng: "+bundle.getString("giaphong"));

            tvmoTa.setText("Mô Tả: "+bundle.getString("mota"));
            ArrayList<String> image = bundle.getStringArrayList("hinhanh");
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            listAnh.setLayoutManager(layoutManager);
            imageAdapter = new ImageAdapter(this,image);
            listAnh.setAdapter(imageAdapter);
        }

    }
}
//  "tenphong": "P101",
//          "tinhtrang": 2,
//          "giaphong": 11111111111,
//          "hinhanh": [
//          "/uploads/ P101/1654332299614hinhanh0.png",
//          "/uploads/ P101/1654332299614hinhanh1.png"
//          ],
//          "mota": "wifi",
//  bundle.putString("tenphong",nhaTros.getTenphong());
//          bundle.putInt("tinhtrang",nhaTros.getTinhtrang());
//          bundle.putString("giaphong",nhaTros.getGiaphong());
//          bundle.putString("mota",nhaTros.getMota());
//          bundle.putString("hinhanh",nhaTros.getHinhanh());