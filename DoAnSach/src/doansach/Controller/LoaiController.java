/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doansach.Controller;

import doansach.Loai;
import doansach.DAO.LoaiDAO;
import doansach.Model.LoaiModel;
import doansach.View.LoaiView;
import doansach.Model.LoginModel;
import doansach.View.LoginView;
import doansach.Model.SachModel;
import doansach.View.SachView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class LoaiController {

    private LoaiModel model;
    private LoaiView view;

    public LoaiController(LoaiModel model, LoaiView view) {
        this.model = model;
        this.view = view;

        tableListener();
        showDataTable();
        //JOptionPane.showMessageDialog(view, " ");
        init();
        view.setTitle("Loại");
        view.getBtn_xoa().setEnabled(false);
        view.getBtn_sua().setEnabled(false);
        view.setVisible(true);
        view.setLocationRelativeTo(null);

    }

    public void showDataTable() {
        DefaultTableModel tb = (DefaultTableModel) view.getTbl_loai().getModel();
        ArrayList<Loai> kq = model.layTatCaLoai();
        tb.setColumnCount(0);
        tb.setRowCount(0);
        tb.addColumn("Mã loại");
        tb.addColumn("Tên loại");

        for (Loai loai : kq) {

            tb.addRow(new Object[]{loai.getMaLoai(), loai.getTenLoai()});
        }

    }

    public void showDataTableSort(ArrayList<Loai> kq) {
        DefaultTableModel tb = (DefaultTableModel) view.getTbl_loai().getModel();
        //ArrayList<Loai> kq = model.layTatCaLoai();
        tb.setColumnCount(0);
        tb.setRowCount(0);
        tb.addColumn("Mã loại");
        tb.addColumn("Tên loại");

        for (Loai loai : kq) {

            tb.addRow(new Object[]{loai.getMaLoai(), loai.getTenLoai()});
        }
    }

    public void showDataTableFind(String tenLoai) {
        DefaultTableModel tb = (DefaultTableModel) view.getTbl_loai().getModel();
        ArrayList<Loai> kq = model.timLoaiTheoTen(tenLoai);
        tb.setColumnCount(0);
        tb.setRowCount(0);
        tb.addColumn("Mã loại");
        tb.addColumn("Tên loại");

        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        for (Loai loai : kq) {

            tb.addRow(new Object[]{loai.getMaLoai(), loai.getTenLoai()});
        }

    }

    public MouseAdapter tableListener() {
        return new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DefaultTableModel tb = (DefaultTableModel) view.getTbl_loai().getModel();
                int index = view.getTbl_loai().getSelectedRow();
                //lay gia tri cua tung cot moi dong
                String maLoai = view.getTbl_loai().getValueAt(index, 0).toString();
                String tenLoai = view.getTbl_loai().getValueAt(index, 1).toString();

                //xuat gia tri ra bang txt
                view.getTxt_maloai().setText(maLoai);
                view.getTxt_tenloai().setText(tenLoai);
                //chuyển txtMasach qua chỉ đọc
                view.getTxt_maloai().setEnabled(false);
                //tat them
                view.getBtn_them().setEnabled(false);
                //bat xóa sửa mới
                view.getBtn_xoa().setEnabled(true);
                view.getBtn_sua().setEnabled(true);
                //view.getBtn_moi().setEnabled(true);

            }
        };

    }

    public void init() {
        view.getTbl_loai().addMouseListener(tableListener());
        //nút thêm
        view.getBtn_them().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ma = view.getTxt_maloai().getText();
                String ten = view.getTxt_tenloai().getText();
                ArrayList<Loai> kq = LoaiDAO.layTatCaLoai();
                boolean temp = false;
                for (Loai loai : kq) {
                    if (view.getTxt_maloai().getText().equals(loai.getMaLoai())) {
                        temp = true;
                    }
                }

                if (temp) {
                    JOptionPane.showMessageDialog(view, "Mã loại đã tồn tại");
                } else {
                    if (ma.isEmpty() || ten.isEmpty()) {
                        JOptionPane.showMessageDialog(view, "Nhập đầy đủ dữ liệu để thêm loại");
                    } else {

                        Loai l = new Loai();
                        l.setMaLoai(ma);
                        l.setTenLoai(ten);

                        if (model.them(l)) {

                            view.getTxt_maloai().setText("");
                            view.getTxt_tenloai().setText("");

                            JOptionPane.showMessageDialog(view, "Thêm thành công!!!");
                            view.getBtn_xoa().setEnabled(false);
                            view.getBtn_sua().setEnabled(false);
                            showDataTable();
                        } else {
                            JOptionPane.showMessageDialog(view, "Thêm không thành công!!!");
                        }

                    }
                }

            }
        });

        //nút xóa
        view.getBtn_xoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String test = view.getTxt_tim().getText();
                String ma = view.getTxt_maloai().getText();
                if (!ma.isEmpty()) {//if (!test.isEmpty()) {
                    boolean a = model.xoa(ma);
                    if (a) {
                        JOptionPane.showMessageDialog(view, "Xóa thành công");
                        showDataTable();
                    } else {
                        JOptionPane.showMessageDialog(view, "Xóa không thành công");
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Nhập mã sách vào ô để xóa sách");
                }
            }
        });

        //nút sửa
        view.getBtn_sua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ma = view.getTxt_maloai().getText();
                String ten = view.getTxt_tenloai().getText();
                if (ma.isEmpty() || ten.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Nhập đầy đủ dữ liệu để sửa loại");
                } else {
                    Loai l = new Loai();
                    l.setMaLoai(ma);
                    l.setTenLoai(ten);
                    if (model.sua(l)) {
                        view.getTxt_maloai().setText("");
                        view.getTxt_tenloai().setText("");
                        JOptionPane.showMessageDialog(view, "Sửa thành công!!!");
                        view.getBtn_xoa().setEnabled(false);
                        view.getBtn_sua().setEnabled(false);
                        showDataTable();
                    } else {
                        JOptionPane.showMessageDialog(view, "Sửa không thành công!!!");
                    }
                }
            }
        });

        //nút tìm
        view.getBtn_tim().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String test = view.getTxt_tim().getText();
                if (test.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Nhập mã sách vào ô để tìm loại");
                } else {
                    ArrayList<Loai> ds = model.timLoaiTheoTen(test);
                    if (ds.isEmpty()) {
                        JOptionPane.showMessageDialog(view, "Không tìm thấy loại giống tên " + test);
                    } else {
                        showDataTableFind(view.getTxt_tim().getText());
                    }
                }
            }
        });

        //nút mới
        view.getBtn_moi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.getTxt_maloai().setText("");
                view.getTxt_tenloai().setText("");

                view.getTxt_maloai().setEnabled(true);
                //tat them
                view.getBtn_them().setEnabled(true);
                //bat xóa sửa mới
                view.getBtn_xoa().setEnabled(false);
                view.getBtn_sua().setEnabled(false);
                showDataTable();
            }
        });

        //nút loại
        view.getBtn_sach().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                SachModel sM = new SachModel();
                SachView sV = new SachView();
                SachController sC = new SachController(sM, sV);
                //a.setVisible(true);

                view.setVisible(false);
            }
        });

        //combo box sắp xếp
        view.getCbo_sapxep().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getCbo_sapxep().getSelectedIndex() == 0) {
                    showDataTable();
                } else if (view.getCbo_sapxep().getSelectedIndex() == 1) {
                    showDataTableSort(model.sapXepTheoTen());
                }
            }
        });

        view.getBtn_logout().addActionListener(new ActionListener() {
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
