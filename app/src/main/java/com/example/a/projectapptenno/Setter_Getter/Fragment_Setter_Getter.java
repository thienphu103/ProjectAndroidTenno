package com.example.a.projectapptenno.Setter_Getter;

import java.io.Serializable;

/**
 * Created by ASUS on 3/26/2018.
 */

public class Fragment_Setter_Getter implements Serializable {
    private String img_monan;
    private String txt_diemtam;
    private String txt_monan;
    private String txt_id;

    public Fragment_Setter_Getter() {
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

    public Fragment_Setter_Getter(String img_monan, String txt_id, String txt_diemtam, String txt_monan) {
        this.txt_id = txt_id;
        this.img_monan = img_monan;
        this.txt_diemtam = txt_diemtam;
        this.txt_monan = txt_monan;
    }
}
