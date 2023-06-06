/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach.DAO;

import doansach.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author abcde
 */
public class LoginDAO {
    
    //Hàm lấy tất cả tk ra
    public static ArrayList<Login> layTatCaTk() {
        ArrayList<Login> dsLoai = new ArrayList<Login>();
        String sqlInsert;
        Connection con;
        try {
            sqlInsert = "select * from login";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlInsert);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Login l = new Login(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4));
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
    

    //Hàm thêm tk
    public static boolean them(Login l) {
        int kq = -1;
        String sqlInsert;
        Connection con;

        try {
            sqlInsert = "insert into login(username, password, ten, mail) values (?,?,?,?)";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlInsert);
            ps.setString(1,l.getUsername());
            ps.setString(2,l.getPassword());
            ps.setString(3,l.getTen());
            ps.setString(4,l.getMail());
            
            
            kq = ps.executeUpdate();
//            
//            ps.close();
//            con.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (kq != -1);

    }

    
    //Hàm sửa tk
    public static boolean sua(Login l){
        int kq = -1;
        String sqlUpdate;
        Connection con;
        try {
            sqlUpdate = "Update login Set password = ? where username = ?";
            con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlUpdate);
            
            ps.setString(1,l.getPassword());
            ps.setString(2,l.getUsername());
            
            
            kq = ps.executeUpdate();
            
//            ps.close();
//            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }     
        return (kq != -1);    
    }
    
}
