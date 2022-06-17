package com.example.quanlynhatro.quanly;

public class ProFile {
    String HoTen;
    String SDT;
    String Email;

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public ProFile(String hoTen, String SDT, String email) {
        HoTen = hoTen;
        this.SDT = SDT;
        Email = email;
    }

    public ProFile() {
    }
}
