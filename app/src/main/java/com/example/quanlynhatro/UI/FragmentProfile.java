package com.example.quanlynhatro.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quanlynhatro.R;
import com.example.quanlynhatro.quanly.ProFile;

import java.util.ArrayList;

public class FragmentProfile extends Fragment {
    TextView tvname,tvsdt,tvemail;
   ArrayList<ProFile> proFiles;
    ProFile proFile;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragmentprofile, container, false);

        tvname = view.findViewById(R.id.tv_profile_name);
        tvemail = view.findViewById(R.id.tv_profile_email);
        tvsdt = view.findViewById(R.id.tv_profile_sdt);

        fakedata();
        String ten = "Hoang VAn Nam";
        String sdt ="0914707813";
        String email="nameS@gmail.com";
        tvname.setText(ten);
        tvemail.setText(sdt);
        tvsdt.setText(email);




        return view;

    }
    void fakedata()
    {



            proFiles= new ArrayList<>();
            String ten = "Hoang VAn Nam";
            String sdt ="0914707813";
            String email="nameS@gmail.com";
            proFile =new ProFile (ten,sdt,email);



    }
}
