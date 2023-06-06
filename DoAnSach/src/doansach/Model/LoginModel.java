/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach.Model;

import doansach.DAO.LoginDAO;
import doansach.DAO.LoaiDAO;
import doansach.Loai;
import doansach.Login;
import java.util.ArrayList;

/**
 *
 * @author abcde
 */
public class LoginModel {
    private ArrayList<Loai> loginModel = LoaiDAO.layTatCaLoai();

    public ArrayList<Loai> getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(ArrayList<Loai> loginModel) {
        this.loginModel = loginModel;
    }

    
    
    //Hàm lấy tất cả tk
    public ArrayList<Login> layTatCaTk() {
        return LoginDAO.layTatCaTk();
    }
    
    //Hàm thêm tk
    public static boolean them(Login l){
        return LoginDAO.them(l);
    }

    //Hàm sửa tk
    public static boolean sua(Login l){
        return LoginDAO.sua(l);
    }
    
}
