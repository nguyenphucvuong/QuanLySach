package doansach;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import doansach.Model.LoginModel;
import doansach.View.LoginView;
import doansach.Controller.LoginController;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author abcde
 */
public class Main {

    public static void main(String[] args) throws ParseException {
//        SachModel sM = new SachModel();
//        SachView sV = new SachView();
//        SachController sC = new SachController(sM, sV);
        
        LoginModel lM = new LoginModel();
        LoginView lV = new LoginView();
        LoginController lC = new LoginController(lM,lV); 


    }
}
