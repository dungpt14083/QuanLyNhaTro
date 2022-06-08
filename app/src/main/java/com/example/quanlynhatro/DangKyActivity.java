package com.example.quanlynhatro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlynhatro.quanly.ApiInterface;
import com.example.quanlynhatro.quanly.Users;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DangKyActivity extends AppCompatActivity {
    TextInputEditText edtname,edtpass,edtrepass,edtemail;
    Button btnDangKy;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        anhxa();
        addEvent();



    }
    void addEvent(){
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtname.getText().toString().isEmpty() && edtpass.getText().toString().isEmpty() && edtrepass.getText().toString().isEmpty() && edtemail.getText().toString().isEmpty())
                {
                    Toast.makeText(DangKyActivity.this,"Please enter all values",Toast.LENGTH_SHORT).show();
                    return;


                }
                else {

                    if(validate()>0)
                    {
                        postData(edtname.getText().toString(),edtemail.getText().toString(),edtpass.getText().toString());
                        Toast.makeText(DangKyActivity.this,"Thanh Cong",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(DangKyActivity.this,"Vui Lòng Kiểm tra Lại Thông Tin Nhập",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
    public int validate(){
        int check=1;
        if(edtpass.equals(edtrepass))
        {
            Toast.makeText(this,"Mật Khẩu không trùng khớp",Toast.LENGTH_SHORT).show();

            check = -1;

        }
      else if(edtpass.length() <= 6)
        {
            Toast.makeText(this,"Mật khẩu phải hơn 6 kí tự",Toast.LENGTH_SHORT).show();

            check = -1;

        }
      return check;

    }
    private void postData(String username,String email,String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tiendungne.herokuapp.com/apiUser/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Users users = new Users(username,email,password);
        Call<List<Users>> call = apiInterface.postReg(users);
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                startActivity(new Intent(DangKyActivity.this,DangNhapActivity.class));

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

                Toast.makeText(DangKyActivity.this,"Đăng Ký thất bại",Toast.LENGTH_SHORT).show();
            }
        });
    }
    void anhxa()
    {
        edtname = findViewById(R.id.edtTenDK);
        edtpass = findViewById(R.id.edtPassDK);
        edtrepass = findViewById(R.id.edtRePassDK);
        edtemail = findViewById(R.id.edtemailDK);
        btnDangKy = findViewById(R.id.btnDK);
    }
}
