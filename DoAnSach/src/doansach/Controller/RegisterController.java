/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach.Controller;

import doansach.Login;
import doansach.DAO.LoginDAO;
import doansach.Model.LoginModel;
import doansach.View.LoginView;
import doansach.View.RegisterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author abcde
 */
public class RegisterController {

    private LoginModel model;
    private RegisterView view;

    public RegisterController(LoginModel model, RegisterView view) {
        this.model = model;
        this.view = view;

        view.setTitle("Đăng ký");
        init();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }

    public void init() {
        //nút trờ lại
        view.getBtn_back().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                LoginModel lM = new LoginModel();
                LoginView lV = new LoginView();
                LoginController lC = new LoginController(lM, lV);
            }
        });

        //nút đăng ký
        view.getBtn_submit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = view.getTxt_username().getText();
                String pass = new String(view.getTxt_pass().getPassword());
                String ten = view.getTxt_name().getText();
                String mail = view.getTxt_mail().getText();
                ArrayList<Login> kq = LoginDAO.layTatCaTk();
                boolean temp = false;
                for (Login login : kq) {
                    if (view.getTxt_username().getText().equals(login.getUsername())) {
                        temp = true;
                    }
                }

                if (temp) {
                    JOptionPane.showMessageDialog(view, "Username đã tồn tại");
                } else {
                    if (user.isEmpty() || pass.isEmpty() || ten.isEmpty() || mail.isEmpty()) {
                        JOptionPane.showMessageDialog(view, "Nhập đầy đủ dữ liệu để đăng ký");
                    } else {

                        Login l = new Login();
                        l.setUsername(user);
                        l.setPassword(pass);
                        l.setTen(ten);
                        l.setMail(mail);
                        if (model.them(l)) {

                            JOptionPane.showMessageDialog(view, "Đăng ký thành công!!!");
                            view.setVisible(false);
                            LoginModel lM = new LoginModel();
                            LoginView lV = new LoginView();
                            LoginController lC = new LoginController(lM, lV);

                        } else {
                            JOptionPane.showMessageDialog(view, "Đăng ký không thành công!!!");
                        }

                    }
                }
            }
        });

    }

}
