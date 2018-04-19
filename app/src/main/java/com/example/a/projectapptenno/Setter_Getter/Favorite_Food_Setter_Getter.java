package com.example.a.projectapptenno.Setter_Getter;

import java.io.Serializable;

/**
 * Created by ASUS on 3/26/2018.
 */

public class Favorite_Food_Setter_Getter implements Serializable {
    private String img_monan;
    private String txt_diemtam;
    private String txt_monan;
    private String txt_id;
    private String img_acount;
    private String dong1_acount;
    private String dong2_acount;
    private String dong3_acount;



    public String getImg_acount() {
        return img_acount;
    }

    public void setImg_acount(String img_acount) {
        this.img_acount = img_acount;
    }

    public String getDong1_acount() {
        return dong1_acount;
    }

    public void setDong1_acount(String dong1_acount) {
        this.dong1_acount = dong1_acount;
    }

    public String getDong2_acount() {
        return dong2_acount;
    }

    public void setDong2_acount(String dong2_acount) {
        this.dong2_acount = dong2_acount;
    }

    public String getDong3_acount() {
        return dong3_acount;
    }

    public void setDong3_acount(String dong3_acount) {
        this.dong3_acount = dong3_acount;
    }

    public Favorite_Food_Setter_Getter(int foodbanhmithit2, String string, String bánh_mì_thịt) {
    }

    public String getImg_monan() {
        return img_monan;
    }

    public void setImg_monan(String img_monan) {
        this.img_monan = img_monan;
    }

    public String getTxt_diemtam() {
        return txt_diemtam;
    }

    public void setTxt_diemtam(String txt_diemtam) {
        this.txt_diemtam = txt_diemtam;
    }

    public String getTxt_monan() {
        return txt_monan;
    }

    public void setTxt_monan(String txt_monan) {
        this.txt_monan = txt_monan;
    }

    public String getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(String txt_id) {
        this.txt_id = txt_id;
    }

    public Favorite_Food_Setter_Getter(String img_monan, String txt_diemtam, String txt_monan, String txt_id) {
        this.txt_id=txt_id;
        this.img_monan = img_monan;
        this.txt_diemtam = txt_diemtam;
        this.txt_monan = txt_monan;
    }

    public Favorite_Food_Setter_Getter(String dong1_acount, String dong2_acount, String dong3_acount) {
        this.dong1_acount = dong1_acount;
        this.dong2_acount = dong2_acount;
        this.dong3_acount = dong3_acount;
    }

    public Favorite_Food_Setter_Getter(String txt_diemtam, String txt_monan) {
        this.txt_diemtam = txt_diemtam;
        this.txt_monan = txt_monan;
    }
}
