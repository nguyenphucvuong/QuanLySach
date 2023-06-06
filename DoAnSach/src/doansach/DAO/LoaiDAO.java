/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach.DAO;


import doansach.Loai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author abcde
 */
public class LoaiDAO {
    
    //Hàm lấy tất cả loại ra
    public static ArrayList<Loai> layTatCaLoai() {
        ArrayList<Loai> dsLoai = new ArrayList<Loai>();
        String sqlInsert;
        Connection con;
        try {
            sqlInsert = "select * from loai";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlInsert);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Loai l = new Loai(rs.getString(1), rs.getString(2));
                dsLoai.add(l);
            }

//            rs.close();
//            ps.close();
//            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsLoai;
    }
    
//      //Hàm lấy sách theo mã loại
//    public static ArrayList<Loai> layTheoLoai(String maLoai) {
//        ArrayList<Loai> dsLoai = new ArrayList<Loai>();
//        String sqlInsert;
//        Connection con;
//        try {
//            sqlInsert = "select * from Loai where maLoai = ?";
//            con = DataBaseUtil.getConnection();
//            PreparedStatement ps = con.prepareStatement(sqlInsert);
//
//            ps.setString(1, maLoai);
//
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Loai l = new Loai(rs.getString(1), rs.getString(2));
//                dsLoai.add(l);
//            }
//
//            rs.close();
//            ps.close();
//            con.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dsLoai;
//    }
    
    //Hàm thêm sách
    public static boolean them(Loai l) {
        int kq = -1;
        String sqlInsert;
        Connection con;

        try {
            sqlInsert = "insert into Loai(maLoai, tenLoai) values (?,?)";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlInsert);
            ps.setString(1,l.getMaLoai());
            ps.setString(2,l.getTenLoai());
            
            
            
            kq = ps.executeUpdate();
//            
//            ps.close();
//            con.close();
//            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (kq != -1);

    }

    
    //Hàm sửa Loai
    public static boolean sua(Loai l){
        int kq = -1;
        String sqlUpdate;
        Connection con;
        try {
            sqlUpdate = "Update Loai Set tenLoai = ? where maLoai = ?";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlUpdate);
            
            ps.setString(1,l.getTenLoai());
            ps.setString(2,l.getMaLoai());
            
            
            kq = ps.executeUpdate();
            
//            ps.close();
//            con.close();
//            
        } catch (Exception e) {
            e.printStackTrace();
        }     
        return (kq != -1);    
    }
    
    //Hàm xóa sách
    public static boolean xoa(String maLoai){
        int kq = -1;
        String sqlDel;
        Connection con;
        try {
            sqlDel = "Delete From Loai Where maLoai = ?";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlDel);
            
            ps.setString(1, maLoai);
            
            kq = ps.executeUpdate();
            
//            ps.close();
//            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return (kq != -1);
        
    }
    
    //Hàm tìm sách theo tên
    public static ArrayList<Loai> timLoaiTheoTen(String tenLoai){
        ArrayList<Loai> dsLoai = new ArrayList<Loai>();
        String sqlFind;
        Connection con;
        try {
            sqlFind = "Select * From Loai where tenLoai like CONCAT('%', ?, '%')";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlFind);
            
            ps.setString(1, tenLoai);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Loai l = new Loai(rs.getString(1),rs.getString(2));
                dsLoai.add(l);
            }
//            rs.close();
//            ps.close();
//            con.close();
//                      
        } catch (Exception e) {
            e.printStackTrace();
        }   
        
        return dsLoai;
    }

    
    //Hàm sắp xếp
}
