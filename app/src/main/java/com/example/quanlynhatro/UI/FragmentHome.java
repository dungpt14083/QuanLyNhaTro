package com.example.quanlynhatro.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlynhatro.Adapter.NhaTroAdapter;
import com.example.quanlynhatro.R;
import com.example.quanlynhatro.quanly.ApiInterface;
import com.example.quanlynhatro.quanly.NhaTro;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentHome extends Fragment {
    RecyclerView recyclerView;
    List<NhaTro> nhaTroList;
    NhaTroAdapter nhaTroAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragmenthome, container, false);

        recyclerView = view.findViewById(R.id.rcv_danhsach);
        nhaTroList = new ArrayList<>();
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        nhaTroAdapter = new NhaTroAdapter(getContext(),nhaTroList);
        recyclerView.setAdapter(nhaTroAdapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tiendungne.herokuapp.com/apiPhong/")
//                .baseUrl("http://192.168.1.5:8080/apiPhong/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<NhaTro>> call = apiInterface.getNhatros();
        call.enqueue(new Callback<List<NhaTro>>() {
            @Override
            public void onResponse(Call<List<NhaTro>> call, Response<List<NhaTro>> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    nhaTroList.addAll(response.body());
                    Toast.makeText(getContext(),"Update Data Succesfull",Toast.LENGTH_SHORT).show();
                    Log.e("TagList", "onResponse: "+nhaTroList.size() );

                    nhaTroAdapter = new NhaTroAdapter(getContext(),nhaTroList);
                    recyclerView.setAdapter(nhaTroAdapter);
                    nhaTroAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<NhaTro>> call, Throwable t) {
                Toast.makeText(getContext(),"lõi "+t,Toast.LENGTH_SHORT).show();
                Log.e("LoiGETDATA", "onFailure: "+t );

            }
        });

        return view;
    }
}
