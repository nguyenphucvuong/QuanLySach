/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach.Model;

import doansach.DAO.SachDAO;
import doansach.Sach;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author abcde
 */
public class SachModel {

    private ArrayList<Sach> listSachModel = SachDAO.layTatCaSach();

    public SachModel() {
    }

    public ArrayList<Sach> getListSachModel() {
        return listSachModel;
    }

    public void setListSachModel(ArrayList<Sach> listSachModel) {
        this.listSachModel = listSachModel;
    }

    //Hàm lấy tất cả sách
    public ArrayList<Sach> layTatCaSach() {
        return SachDAO.layTatCaSach();
    }

    //Hàm lấy sách theo loại
//    public ArrayList<Sach> layTheoLoai(String maLoai) {
//        ArrayList<Sach> kq = new ArrayList<Sach>();
//
//        for (Sach sach : sachModel) {
//            if (sach.getLoai().equals(maLoai)) {
//                kq.add(sach);
//            }
//        }
//
//        return kq;
//    }
    public ArrayList<Sach> layTheoLoai(String maLoai) {
        ArrayList<Sach> layTheoLoai = SachDAO.layTheoLoai(maLoai);
        return layTheoLoai;
    }

    //Hàm thêm sách
//   S public boolean them(String maSach, String tenSach, String loaiSach, String tacGia, String gia, String ngayXB) throws ParseException {
//        Sach s = new Sach(maSach, tenSach, loaiSach, tacGia, gia, ngayXB);
//        
//        return sachModel.add(s);
//    }
//    public boolean them(String maSach, String tenSach, String loaiSach, String tacGia, String gia, Date ngayXB) throws ParseException {
//        boolean kq = SachDAO.them(maSach, tenSach, loaiSach, tacGia, gia, ngayXB);
//        sachModel = SachDAO.layTatCaSach();
//        return kq;
//    }
    public static boolean them(Sach s) {
        return SachDAO.them(s);
    }

    //Hàm sửa sách
//    public boolean sua(String maSach, String tenSach, String loaiSach, String tacGia, String gia, String ngayXB) throws ParseException{
//        for (Sach sach : sachModel) {
//            if (sach.getMaSach().equals(maSach)) {
//                sach = new Sach(sach.getMaSach(), tenSach, loaiSach, tacGia, gia,ngayXB);
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean sua(String maSach, String tenSach, String loaiSach, String tacGia, Double gia, Date ngayXB) throws ParseException {
//        
//        boolean kq = SachDAO.sua(maSach, tenSach, loaiSach, tacGia, gia, ngayXB);
//        
//        return kq;
//    }
    public static boolean sua(Sach s){
        return SachDAO.sua(s);
    }

    //Hàm xóa sách;
//    public boolean xoa(String maSach){
//        for (Sach sach : sachModel) {
//            if (sach.getMaSach().equals(maSach)) {
//                sachModel.remove(sach);
//                return true;
//            }
//        }
//        return false;
//    }
    public static boolean xoa(String maSach) {
        ArrayList<Sach> ds = SachDAO.layTatCaSach();
        for (Sach sach : ds) {
            if (sach.getMaSach().equalsIgnoreCase(maSach)) {
                return SachDAO.xoa(maSach);
            }
        }
        return false;
    }

    //Hàm tìm sách theo tên
//    public ArrayList<Sach> timSachTheoTen(String tenSach) {
//        ArrayList<Sach> kq = new ArrayLList<Sach>();
//        for (Sach sach : sachModel) {
//            if (sach.getTenSach().equalsIgnoreCase(tenSach)) {
//                kq.add(sach);
//            }
//        }
//        return kq;
//    }
    public ArrayList<Sach> timSachTheoTen(String tenSach) {
        return SachDAO.timSachTheoTen(tenSach);
    }

    //Hàm sắp xếp theo tên
    public ArrayList<Sach> sapXepTheoTen() {
        //ArrayList<Sach> ds = sachModel;
        listSachModel = SachDAO.layTatCaSach();
        Collections.sort(listSachModel, new Comparator<Sach>() {
            @Override
            public int compare(Sach s1, Sach s2) {
                return s1.getTenSach().compareTo(s2.getTenSach());
            }
        });
        return listSachModel;
    }
    
    //Hàm sắp xếp theo giá rồi theo ngày
    public ArrayList<Sach> sapXepTheoLoaiRoiTheoGia() {
        //ArrayList<Sach> ds = sachModel;
        listSachModel = SachDAO.layTatCaSach();
        Collections.sort(listSachModel, new Comparator<Sach>() {
            @Override
            public int compare(Sach s1, Sach s2) {
                if (s1.getLoai().equals(s2.getLoai())) {
                    
                    return (int) (s1.getGia() - s2.getGia());  
                }
                return s1.getLoai().compareTo(s2.getLoai()); 
            }
        });
        
        return listSachModel;
    }

    //print
    public void print() {
        for (Sach sach : listSachModel) {

            System.out.println(sach.toString());
        }
    }

}
