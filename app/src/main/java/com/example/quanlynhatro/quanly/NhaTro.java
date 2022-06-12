package com.example.quanlynhatro.quanly;

import java.util.ArrayList;

public class NhaTro {
    private String _id;
    private String idloaiphong;
    private String tenphong;
    private int tinhtrang;
    private String giaphong;
    private ArrayList<String> hinhanh;
    private String mota;
    private String __v;

    public NhaTro() {
    }

    public NhaTro(String _id, String idloaiphong, String tenphong, int tinhtrang, String giaphong, ArrayList<String> hinhanh, String mota, String __v) {
        this._id = _id;
        this.idloaiphong = idloaiphong;
        this.tenphong = tenphong;
        this.tinhtrang = tinhtrang;
        this.giaphong = giaphong;
        this.hinhanh = hinhanh;
        this.mota = mota;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdloaiphong() {
        return idloaiphong;
    }

    public void setIdloaiphong(String idloaiphong) {
        this.idloaiphong = idloaiphong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public int getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getGiaphong() {
        return giaphong;
    }

    public void setGiaphong(String giaphong) {
        this.giaphong = giaphong;
    }

    public ArrayList<String> getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(ArrayList<String> hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }
}
