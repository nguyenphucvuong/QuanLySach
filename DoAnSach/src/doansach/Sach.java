/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doansach;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Sach {

    private String maSach;
    private String tenSach;
    private String loai;
    private String tacGia;
    private double gia;
    private Date ngayXB;
    //

//    private static java.util.Date utilPackageDate = new java.util.Date();
//    private static java.sql.Date sqlPackageDate = new java.sql.Date(utilPackageDate.getTime());
//    public Sach(String maSach, String tenSach, String loai, String tacGia, String gia, String ngayXB) throws ParseException {
//        try {
//            this.maSach = maSach;
//            this.tenSach = tenSach;
//            this.loai = loai;
//            this.tacGia = tacGia;
//            this.gia = Double.parseDouble(gia);
//            this.ngayXB = new SimpleDateFormat("yyyy-MM-dd").parse(ngayXB);
//        } catch (ParseException ex) {
//            Logger.getLogger(SachModel.class.getName()).log(Level.SEVERE, null, "Nhap sai du lieu"+ex);
//        }
//    }
    public Sach(String maSach, String tenSach, String loai, String tacGia, String gia, Date ngayXB) throws ParseException {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loai = loai;
        this.tacGia = tacGia;
        this.gia = Double.parseDouble(gia);
        this.ngayXB = ngayXB;
    }

    public Sach(String maSach, String tenSach, String loai, String tacGia, String gia, String ngayXB) throws ParseException {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loai = loai;
        this.tacGia = tacGia;
        this.gia = Double.parseDouble(gia);
        this.ngayXB = new SimpleDateFormat("yyyy-MM-dd").parse(ngayXB);
    }

    public Sach() {

    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Date getNgayXB() {
        return ngayXB;
    }

    public void setNGayXB(Date ngayXB) {
        this.ngayXB = ngayXB;
    }

    @Override
    public String toString() {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        return "Sach{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", loai=" + loai + ", tacGia=" + tacGia + ", gia=" + gia + ", ngayXB=" + df.format(ngayXB) + '}';
    }

}
