/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach.Model;

import doansach.DAO.LoaiDAO;
import doansach.Loai;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author abcde
 */
public class LoaiModel {
    private ArrayList<Loai> loaiModel = LoaiDAO.layTatCaLoai();

    public ArrayList<Loai> getLoaiModel() {
        return loaiModel;
    }

    public void setLoaiModel(ArrayList<Loai> loaiModel) {
        this.loaiModel = loaiModel;
    }
    
    //Hàm lấy tất cả loại
    public ArrayList<Loai> layTatCaLoai() {
        return LoaiDAO.layTatCaLoai();
    }
    
    //Hàm thêm loại
    public static boolean them(Loai l){
        return LoaiDAO.them(l);
    }

    //Hàm sửa loại
    public static boolean sua(Loai l){
        return LoaiDAO.sua(l);
    }
    
    //Hàm xóa loại
    public static boolean xoa(String maLoai){
        ArrayList<Loai> ds = LoaiDAO.layTatCaLoai();
        for (Loai loai : ds) {
            if (loai.getMaLoai().equalsIgnoreCase(maLoai)) {
                return LoaiDAO.xoa(maLoai);
            }
        }
        return false;
    }
    
    //Hàm tìm sách theo tên
    public ArrayList<Loai> timLoaiTheoTen(String tenLoai){
        return LoaiDAO.timLoaiTheoTen(tenLoai);
    }
    
    //Hàm sắp xếp the tên loại
    public ArrayList<Loai> sapXepTheoTen(){
        //ArrayList<Loai> dsL = loaiModel;
        Collections.sort(loaiModel,new Comparator<Loai>(){
            @Override
            public int compare(Loai l1, Loai l2) {
                return l1.getTenLoai().compareToIgnoreCase(l2.getTenLoai());
            }
            
        });
        return loaiModel;
    }
    
    //Hàm print
    public void print(){
        for (Loai loai : loaiModel) {
            System.out.println(loai.toString());
        }
 
    }
}
