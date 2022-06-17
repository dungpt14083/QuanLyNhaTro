package com.example.quanlynhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlynhatro.quanly.ApiInterface;
import com.example.quanlynhatro.quanly.Users;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DangNhapActivity extends AppCompatActivity {
    TextView tvDangKy;
    TextInputEditText edtemail,edtpass;
    Button btnLogin;
    String token = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        tvDangKy = findViewById(R.id.tvDangKy);
        edtemail = findViewById(R.id.edtTenDN);
        edtpass = findViewById(R.id.edtPassDN);
        btnLogin = findViewById(R.id.btnDN);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtemail.getText().toString().isEmpty()&&edtpass.getText().toString().isEmpty())
                {
                    Toast.makeText(DangNhapActivity.this,"Vui Lòng Nhập Đầy Đủ Thông Tin",Toast.LENGTH_SHORT).show();

                }
                else {
                    postLogin(edtemail.getText().toString(),edtpass.getText().toString());

                }

            }
        });
        tvDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this,DangKyActivity.class);
                startActivity(intent);
            }
        });

    }

    void postLogin(String email,String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tiendungne.herokuapp.com/apiUser/user/")
//                .baseUrl("http://192.168.1.5:8080/apiUser/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Users users = new Users(email,password);
        Call<Users> call = apiInterface.postLogin(users);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                try {
                    Users usersapi = response.body();
                    token = usersapi.getToken();
                    if(token != null)
                    {
                        startActivity(new Intent(DangNhapActivity.this,MainActivity.class));

                    }
                    else {
                        Toast.makeText(DangNhapActivity.this, "Login failed , Please check email or password", Toast.LENGTH_SHORT).show();

                    }

                }catch (Exception e)
                {
                    Toast.makeText(DangNhapActivity.this,"login Failed!Please check email or password",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
    }
}