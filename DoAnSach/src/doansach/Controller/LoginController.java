/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach.Controller;

import doansach.View.ForgotPassView;
import doansach.Login;
import doansach.Model.LoginModel;
import doansach.View.LoginView;
import doansach.View.MenuView;
import doansach.View.RegisterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abcde
 */
public class LoginController {

    private LoginModel model;
    private LoginView view;

    public LoginController(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;

        init();
        setTKMK();
        view.setTitle("Login");
        //view.getLbl_fgpass().setVisible(false);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }

    public void setTKMK() {
        ArrayList<Login> a = model.layTatCaTk();
       
        for (Login login : a) {
            view.getTxt_username().setText(login.getUsername());
            view.getTxt_pass().setText(login.getPassword());
            break;
        }

    }

    public MouseAdapter mouseForgotPassListener() {
        return new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginModel lM = new LoginModel();
                ForgotPassView fPass = new ForgotPassView();
                ForgotPassController rC = new ForgotPassController(lM, fPass);
                //a.setVisible(true);

                view.setVisible(false);

            }
        };
    }

//    public MouseAdapter mouseChangePassListener() {
//        return new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                LoginModel lM = new LoginModel();
//                ForgotPassView fPass = new ForgotPassView();
//                ForgotPassController rC = new ForgotPassController(lM, fPass);
//                //a.setVisible(true);
//
//                view.setVisible(false);
//
//            }
//        };
//    }
    public void init() {
        view.getLbl_fgpass().addMouseListener(mouseForgotPassListener());
//        view.getLbl_changepass().addMouseListener(mouseChangePassListener());

        //nút đăng nhập
        view.getBtn_dangnhap().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = view.getTxt_username().getText();
//                char[] passChar = view.getTxt_pass().getPassword();
//                String pass = passChar.toString();
                ArrayList<Login> a = model.layTatCaTk();
                boolean test = false;
                for (Login login : a) {
                    if (login.getUsername().equals(user) && login.getPassword().equals(new String(view.getTxt_pass().getPassword()))) {
                        test = true;
                    }
                }
                if (test) {
//                    SachModel sM = new SachModel();
//                    SachView sV = new SachView();
//                    SachController sC = new SachController(sM, sV);

                    MenuView mV = new MenuView();
                    MenuController sC = new MenuController(mV);

                    view.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(view, "Sai tài khoản hoặc mật khẩu");
                }
            }
        });

        view.getBtn_dangky().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginModel lM = new LoginModel();
                RegisterView rV = new RegisterView();
                RegisterController rC = new RegisterController(lM, rV);
                //a.setVisible(true);

                view.setVisible(false);
            }

        });
        
        
    }
}
