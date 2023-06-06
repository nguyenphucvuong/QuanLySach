/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach.Controller;

import doansach.View.ChangePassView;
import doansach.Login;
import doansach.DAO.LoginDAO;
import doansach.Model.LoginModel;
import doansach.View.LoginView;
import doansach.View.MenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author abcde
 */
public class ChangePassController {

    private LoginModel model;
    private ChangePassView view;

    public ChangePassController(LoginModel model, ChangePassView view) {
        this.model = model;
        this.view = view;

        init();
        view.setVisible(true);
        view.setTitle("Đổi mật khẩu");
        view.setLocationRelativeTo(null);
    }

    public void init() {
        //nút trờ lại
        view.getBtn_back().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                MenuView mV = new MenuView();
                MenuController sC = new MenuController(mV);
            }
        });

        //nút đăng ký
        view.getBtn_submit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = view.getTxt_username().getText();
                String oldpass = new String (view.getTxt_oldpass().getPassword());
                String pass = new String(view.getTxt_pass().getPassword());
                String pass1 = new String(view.getTxt_pass1().getPassword());
                
                ArrayList<Login> kq = LoginDAO.layTatCaTk();
                boolean temp = true;
                for (Login login : kq) {
                    if (view.getTxt_username().getText().equals(login.getUsername()) && new String (view.getTxt_oldpass().getPassword()).equals(login.getPassword())) {
                        temp = false;
                    }
                }

                if (temp) {
                    JOptionPane.showMessageDialog(view, "Username không tồn tại hoặc sai mật khẩu");
                } else {
                    if ((user.isEmpty() || pass.isEmpty() || pass1.isEmpty()) && pass.equals(pass1)) {
                        JOptionPane.showMessageDialog(view, "Nhập đầy đủ dữ liệu để đổi mật khẩu");
                    } else {

                        Login l = new Login();
                        l.setUsername(user);
                        l.setPassword(pass);
                        
                        if (model.sua(l)) {

                            JOptionPane.showMessageDialog(view, "Đổi thành công!!!");
                            view.setVisible(false);
                            LoginModel lM = new LoginModel();
                            LoginView lV = new LoginView();
                            LoginController lC = new LoginController(lM, lV);

                        } else {
                            JOptionPane.showMessageDialog(view, "Đổi không thành công!!!");
                        }

                    }
                }
            }
        });

    }

}
