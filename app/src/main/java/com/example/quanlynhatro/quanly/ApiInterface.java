package com.example.quanlynhatro.quanly;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("reg")
    Call<List<Users>> postReg(@Body Users users);
    @POST("login")
    Call<Users> postLogin(@Body Users users);
    @GET("getall")
    Call<List<NhaTro>> getNhatros();


}
