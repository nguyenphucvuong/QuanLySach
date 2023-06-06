/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach.DAO;

import doansach.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author abcde
 */
public class SachDAO {
//    private ArrayList<Sach> dsSach;
//
//   
//
//    public ArrayList<Sach> getDsSach() {
//        return dsSach;
//    }
//
//    public void setDsSach(ArrayList<Sach> dsSach) {
//        this.dsSach = dsSach;
//    }
//    
//     public SachDAO(ArrayList<Sach> dsSach) {
//        this.dsSach = dsSach;
//    }
//    
//    public SachDAO() {
//        this.dsSach = layTatCaSach();
//    }

    //Hàm lấy tất cả sách ra
    public static ArrayList<Sach> layTatCaSach() {
        ArrayList<Sach> dsSach = new ArrayList<Sach>();
        String sqlInsert;
        Connection con;
        try {
            sqlInsert = "select * from sach";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlInsert);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach s = new Sach();
                s.setMaSach(rs.getString(1));
                s.setTenSach(rs.getString(2));
                s.setLoai(rs.getString(3));
                s.setTacGia(rs.getString(4));
                s.setGia(rs.getDouble(5));
                
                java.sql.Date ngayXB = rs.getDate(6);
                if (rs.getDate(6) != null) {
                    s.setNGayXB(new Date(ngayXB.getTime()));
                }
                
                dsSach.add(s);
            }

//            rs.close();
//            ps.close();
//            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsSach;
    }

    //Hàm lấy sách theo mã loại
    public static ArrayList<Sach> layTheoLoai(String maLoai) {
        ArrayList<Sach> dsSach = new ArrayList<Sach>();
        String sqlInsert;
        Connection con;
        try {
            sqlInsert = "select * from sach where loaiSach = ?";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlInsert);

            ps.setString(1, maLoai);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach s = new Sach();
                s.setMaSach(rs.getString(1));
                s.setTenSach(rs.getString(2));
                s.setLoai(rs.getString(3));
                s.setTacGia(rs.getString(4));
                s.setGia(rs.getDouble(5));
                java.sql.Date ngayXB = rs.getDate(6);
                if (rs.getDate(6) != null) {
                    s.setNGayXB(new Date(ngayXB.getTime()));
                }
                dsSach.add(s);
            }

//            rs.close();
//            ps.close();
//            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsSach;
    }

    //Hàm thêm sách
//    public static boolean them(String maSach, String tenSach, String loaiSach, String tacGia, String gia, Date ngayXB) {
    public static boolean them(Sach s) {
        int kq = -1;
        String sqlInsert;
        Connection con;

        try {
            sqlInsert = "insert into sach(maSach, tenSach, loaiSach, tacGia, gia, ngayXB) values (?,?,?,?,?,?)";
            con = DataBaseUtil.getConnection();
            //DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            PreparedStatement ps = con.prepareStatement(sqlInsert);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getLoai());
            ps.setString(4, s.getTacGia());
            ps.setDouble(5, s.getGia());
            ps.setDate(6, new java.sql.Date(s.getNgayXB().getTime()));

            kq = ps.executeUpdate();

//            ps.close();
//            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (kq != -1);

    }

    //Hàm sửa sach
//    public static boolean sua(String maSach, String tenSach, String loaiSach, String tacGia, Double gia, Date ngayXB) {
    public static boolean sua(Sach s) {
        int kq = -1;
        String sqlUpdate;
        Connection con;
        try {
            sqlUpdate = "Update sach Set tenSach = ?, loaiSach = ?, tacGia = ?, gia = ?, ngayXB = ? where maSach = ?";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlUpdate);

            ps.setString(1, s.getTenSach());
            ps.setString(2, s.getLoai());
            ps.setString(3, s.getTacGia());
            ps.setDouble(4, s.getGia());
            ps.setDate(5, new java.sql.Date(s.getNgayXB().getTime()));
            ps.setString(6, s.getMaSach());

            kq = ps.executeUpdate();

//            ps.close();
//            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (kq != -1);
    }

    //Hàm xóa sách
    public static boolean xoa(String maSach) {
        int kq = -1;
        String sqlDel;
        Connection con;
        try {
            sqlDel = "Delete From sach Where maSach = ?";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlDel);

            ps.setString(1, maSach);

            kq = ps.executeUpdate();

//            ps.close();
//            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (kq != -1);

    }

    //Hàm tìm sách theo tên
    public static ArrayList<Sach> timSachTheoTen(String tenSach) {
        ArrayList<Sach> dsSach = new ArrayList<Sach>();
        String sqlFind;
        Connection con;
        try {
            sqlFind = "Select * From sach where tenSach like CONCAT('%', ?, '%')";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlFind);

            ps.setString(1, tenSach);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach s = new Sach();
                s.setMaSach(rs.getString(1));
                s.setTenSach(rs.getString(2));
                s.setLoai(rs.getString(3));
                s.setTacGia(rs.getString(4));
                s.setGia(rs.getDouble(5));
                java.sql.Date ngayXB = rs.getDate(6);
                
                if (rs.getDate(6) != null) {
                    s.setNGayXB(new Date(ngayXB.getTime()));
                }
                dsSach.add(s);
            }
//            rs.close();
//            ps.close();
//            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsSach;
    }

    
    
    //Hàm sắp xếp
    //toString
//    @Override
//    public String toString() {
//        return "SachDAO{" + '}';
//    }
}
