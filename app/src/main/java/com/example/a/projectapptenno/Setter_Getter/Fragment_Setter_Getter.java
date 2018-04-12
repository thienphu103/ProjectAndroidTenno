package com.example.a.projectapptenno.Setter_Getter;

import java.io.Serializable;

/**
 * Created by ASUS on 3/26/2018.
 */

public class Fragment_Setter_Getter implements Serializable {
    private int img_monan;
    private String txt_diemtam;
    private String txt_monan;
    private String txt_id;

    public Fragment_Setter_Getter() {
    }

    public int getImg_monan() {
        return img_monan;
    }

    public void setImg_monan(int img_monan) {
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

    public Fragment_Setter_Getter(int img_monan, String txt_id, String txt_diemtam, String txt_monan) {
        this.txt_id = txt_id;
        this.img_monan = img_monan;
        this.txt_diemtam = txt_diemtam;
        this.txt_monan = txt_monan;
    }
}
