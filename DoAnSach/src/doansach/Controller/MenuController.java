/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach.Controller;

import doansach.View.ChangePassView;
import doansach.Model.LoaiModel;
import doansach.View.LoaiView;
import doansach.Model.LoginModel;
import doansach.View.LoginView;
import doansach.View.MenuView;
import doansach.Model.SachModel;
import doansach.View.SachView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author abcde
 */
public class MenuController {
//    private SachModel sModel;
//    private SachView sView;
//    private LoaiModel lModel;
//    private LoaiView lView;
//    private LoginModel loModel;
//    private LoginView loView;

    private MenuView view;

    public MenuController(MenuView view) {
        this.view = view;

        init();
        view.setVisible(true);
        view.setTitle("Menu");
        view.setLocationRelativeTo(null);
    }

    public MouseAdapter mouseChangePassListener() {
        return new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginModel lM = new LoginModel();
                ChangePassView cPass = new ChangePassView();
                ChangePassController cC = new ChangePassController(lM, cPass);
                //a.setVisible(true);

                view.setVisible(false);

            }
        };
    }

    public MouseAdapter mouseSachListener() {
        return new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SachModel sM = new SachModel();
                SachView sV = new SachView();
                SachController sC = new SachController(sM, sV);
                
                view.setVisible(false);

            }
        };
    }

    public MouseAdapter mouseLoaiListener() {
        return new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoaiModel lM = new LoaiModel();
                LoaiView lV = new LoaiView();
                LoaiController lC = new LoaiController(lM, lV);
                view.setVisible(false);

            }
        };
    }

    public void init() {
        view.getLbl_sach().addMouseListener(mouseSachListener());
        view.getLbl_loai().addMouseListener(mouseLoaiListener());
        view.getLbl_changepass().addMouseListener(mouseChangePassListener());
        
        view.getBtn_logout().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginModel lM = new LoginModel();
                LoginView lV = new LoginView();
                LoginController lC = new LoginController(lM, lV);
                //a.setVisible(true);

                view.setVisible(false);
            }
        });
    }

}
