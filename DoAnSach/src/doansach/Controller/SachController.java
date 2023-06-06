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
import doansach.Sach;
import doansach.DAO.SachDAO;
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
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class SachController {

    private SachModel model;
    private SachView view;

    public SachController(SachModel model, SachView view) {
        this.model = model;
        this.view = view;

        tableListener();
        showDataTable();
        //JOptionPane.showMessageDialog(view, "         ");
        init();
        showTenLoai();
        view.setTitle("Sách");
        view.getBtn_xoa().setEnabled(false);
        view.getBtn_sua().setEnabled(false);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }

    public void showDataTable() {
        DefaultTableModel tb = (DefaultTableModel) view.getTbl_sach().getModel();
        ArrayList<Sach> kq = model.layTatCaSach();
        tb.setColumnCount(0);
        tb.setRowCount(0);
        tb.addColumn("Mã sách");
        tb.addColumn("Tên sách");
        tb.addColumn("Loại sách");
        tb.addColumn("Tác giả");
        tb.addColumn("Giá");
        tb.addColumn("Ngày xuất bản");

        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        for (Sach sach : kq) {

            tb.addRow(new Object[]{sach.getMaSach(), sach.getTenSach(), sach.getLoai(), sach.getTacGia(), sach.getGia(), df.format(sach.getNgayXB())});
        }
        //showTenLoai();
    }

    public void showDataTableSort(ArrayList<Sach> kq) {
        DefaultTableModel tb = (DefaultTableModel) view.getTbl_sach().getModel();
        //ArrayList<Sach> kq = model.layTatCaSach();
        tb.setColumnCount(0);
        tb.setRowCount(0);
        tb.addColumn("Mã sách");
        tb.addColumn("Tên sách");
        tb.addColumn("Loại sách");
        tb.addColumn("Tác giả");
        tb.addColumn("Giá");
        tb.addColumn("Ngày xuất bản");

        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        for (Sach sach : kq) {

            tb.addRow(new Object[]{sach.getMaSach(), sach.getTenSach(), sach.getLoai(), sach.getTacGia(), sach.getGia(), df.format(sach.getNgayXB())});
        }
        //showTenLoai();
    }

    public void showTenLoai() {
        ArrayList<Loai> a = LoaiDAO.layTatCaLoai();
        for (Loai loai : a) {
            view.getCbo_loai().addItem(loai.getTenLoai());
        }
    }

//    public String maLoaiString() {
//        ArrayList<Loai> a = LoaiDAO.layTatCaLoai();
//        int index = view.getTbl_sach().getSelectedRow();
//        for (Loai loai : a) {
//            if (loai.getMaLoai().equalsIgnoreCase(view.getTbl_sach().getValueAt(index, 2).toString())) {
//                return loai.getMaLoai();
//            }
//        }
//        return null;
//    }

    public String maLoai() {

        ArrayList<Loai> a = LoaiDAO.layTatCaLoai();
        //int index = view.getTbl_sach().getSelectedRow();
        for (Loai loai : a) {
            if (loai.getTenLoai().equalsIgnoreCase(view.getCbo_loai().getSelectedItem().toString())) {
                return loai.getMaLoai();
            }
        }
        return null;
    }

    public String tenLoai() {

        ArrayList<Loai> a = LoaiDAO.layTatCaLoai();
        //int index = view.getTbl_sach().getSelectedRow();
        for (Loai loai : a) {
            if (loai.getTenLoai().equalsIgnoreCase(view.getCbo_loai().getSelectedItem().toString())) {
                return loai.getTenLoai();
            }
        }
        return null;
    }

    public String tenLoaiString() {
        ArrayList<Loai> a = LoaiDAO.layTatCaLoai();
        int index = view.getTbl_sach().getSelectedRow();
        for (Loai loai : a) {
            if (loai.getMaLoai().equalsIgnoreCase(view.getTbl_sach().getValueAt(index, 2).toString())) {
                return loai.getTenLoai();
            }
        }
        return null;
    }

    public void showDataTableFind(String tenSach) {
        DefaultTableModel tb = (DefaultTableModel) view.getTbl_sach().getModel();
        ArrayList<Sach> kq = model.timSachTheoTen(tenSach);
        tb.setColumnCount(0);
        tb.setRowCount(0);
        tb.addColumn("Mã sách");
        tb.addColumn("Tên sách");
        tb.addColumn("Loại sách");
        tb.addColumn("Tác giả");
        tb.addColumn("Giá");
        tb.addColumn("Ngày xuất bản");

        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        for (Sach sach : kq) {
            tb.addRow(new Object[]{sach.getMaSach(), sach.getTenSach(), sach.getLoai(), sach.getTacGia(), sach.getGia(), df.format(sach.getNgayXB())});
        }

    }

    public MouseAdapter tableListener() {
        return new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DefaultTableModel tb = (DefaultTableModel) view.getTbl_sach().getModel();
                int index = view.getTbl_sach().getSelectedRow();
                //lay gia tri cua tung cot moi dong
                String maSach = view.getTbl_sach().getValueAt(index, 0).toString();
                String tenSach = view.getTbl_sach().getValueAt(index, 1).toString();
                String loai = view.getTbl_sach().getValueAt(index, 2).toString();
                String tacGia = view.getTbl_sach().getValueAt(index, 3).toString();
                String gia = view.getTbl_sach().getValueAt(index, 4).toString();
                String ngayXB = view.getTbl_sach().getValueAt(index, 5).toString();

                //xuat gia tri ra bang txt
                view.getTxt_masach().setText(maSach);
                view.getTxt_tensach().setText(tenSach);
                view.getCbo_loai().setSelectedItem(tenLoaiString());
                view.getTxt_tacgia().setText(tacGia);
                view.getTxt_gia().setText(gia);
                view.getTxt_ngayxb().setText(ngayXB);
                //chuyển txtMasach qua chỉ đọc
                view.getTxt_masach().setEnabled(false);
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
        view.getTbl_sach().addMouseListener(tableListener());
        //nút thêm
        view.getBtn_them().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ma = view.getTxt_masach().getText();
                String ten = view.getTxt_tensach().getText();
                String loai = maLoai();
                String tacgia = view.getTxt_tacgia().getText();
                String sGia = view.getTxt_gia().getText();
                String ngayxb = view.getTxt_ngayxb().getText();
                ArrayList<Sach> kq = SachDAO.layTatCaSach();
                boolean temp = false;
                for (Sach sach : kq) {
                    if (view.getTxt_masach().getText().equals(sach.getMaSach())) {
                        temp = true;
                    }
                }

                if (temp) {
                    JOptionPane.showMessageDialog(view, "Mã sách đã tồn tại");
                } else {
                    if (ma.isEmpty() || ten.isEmpty() || loai.isEmpty() || tacgia.isEmpty() || sGia.isEmpty() || ngayxb.isEmpty()) {
                        JOptionPane.showMessageDialog(view, "Nhập đầy đủ dữ liệu để thêm sách");
                    } else {
                        try {
//                        String maSach = view.getTxt_masach().getText();
//                        String tenSach = view.getTxt_tensach().getText();
//                        String loaiSach = maLoai();
//                        String tacGia = view.getTxt_tacgia().getText();
                            double gia = Double.parseDouble(sGia);
                            Date ngayXB = new SimpleDateFormat("yyyy-MM-dd").parse(ngayxb);

                            //Sach s = new Sach(maSach,tenSach,loaiSach,tacGia,view.getTxt_gia().getText(),view.getTxt_ngayxb().getText());
                            Sach s = new Sach();
                            s.setMaSach(ma);
                            s.setTenSach(ten);
                            s.setLoai(loai);
                            s.setTacGia(tacgia);
                            s.setGia(gia);
                            s.setNGayXB(ngayXB);
                            if (view.getCbo_loai().getSelectedIndex() == 0) {
                                JOptionPane.showMessageDialog(view, "Chọn lại loại");
                            } else {
                                if (model.them(s)) {

                                    view.getTxt_masach().setText("");
                                    view.getTxt_tensach().setText("");
                                    view.getCbo_loai().setSelectedIndex(0);
                                    view.getTxt_tacgia().setText("");
                                    view.getTxt_gia().setText("");
                                    view.getTxt_ngayxb().setText("");
                                    JOptionPane.showMessageDialog(view, "Thêm thành công!!!");
                                    view.getBtn_xoa().setEnabled(false);
                                    view.getBtn_sua().setEnabled(false);
                                    showDataTable();
                                } else {
                                    JOptionPane.showMessageDialog(view, "Thêm không thành công!!!");
                                }
                            }

                        } catch (ParseException ex) {
                            //JOptionPane.showMessageDialog(view, ex + "Loi du lieu");
                            Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex + "Loi nhap du lieu");
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
                String ma = view.getTxt_masach().getText();
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
                String ma = view.getTxt_masach().getText();
                String ten = view.getTxt_tensach().getText();
                String loai = maLoai();
                String tacgia = view.getTxt_tacgia().getText();
                String sGia = view.getTxt_gia().getText();
                String ngayxb = view.getTxt_ngayxb().getText();
                if (ma.isEmpty() || ten.isEmpty() || loai.isEmpty() || tacgia.isEmpty() || sGia.isEmpty() || ngayxb.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Nhập đầy đủ dữ liệu để sửa sách");
                } else {
                    try {
//                        String maSach = view.getTxt_masach().getText();
//                        String tenSach = view.getTxt_tensach().getText();
//                        String loaiSach = maLoai();
//                        String tacGia = view.getTxt_tacgia().getText();
                        double gia = Double.parseDouble(sGia);
                        Date ngayXB = new SimpleDateFormat("yyyy-MM-dd").parse(ngayxb);

                        //Sach s = new Sach(maSach,tenSach,loaiSach,tacGia,view.getTxt_gia().getText(),view.getTxt_ngayxb().getText());
                        Sach s = new Sach();
                        s.setMaSach(ma);
                        s.setTenSach(ten);
                        s.setLoai(loai);
                        s.setTacGia(tacgia);
                        s.setGia(gia);
                        s.setNGayXB(ngayXB);
                        if (view.getCbo_loai().getSelectedIndex() == 0) {
                            JOptionPane.showMessageDialog(view, "Chọn lại loại");
                        } else {
                            if (model.sua(s)) {

                                view.getTxt_masach().setText("");
                                view.getTxt_tensach().setText("");
                                view.getCbo_loai().setSelectedIndex(0);
                                view.getTxt_tacgia().setText("");
                                view.getTxt_gia().setText("");
                                view.getTxt_ngayxb().setText("");
                                JOptionPane.showMessageDialog(view, "Sửa thành công!!!");
                                view.getBtn_xoa().setEnabled(false);
                                view.getBtn_sua().setEnabled(false);
                                showDataTable();
                            } else {
                                JOptionPane.showMessageDialog(view, "Sửa không thành công!!!");
                            }
                        }
                    } catch (ParseException ex) {
                        //JOptionPane.showMessageDialog(view, ex + "Loi du lieu");
                        Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex + "Loi nhap du lieu");
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
                    JOptionPane.showMessageDialog(view, "Nhập mã sách vào ô để tìm sách");
                } else {
                    ArrayList<Sach> ds = model.timSachTheoTen(test);
                    if (ds.isEmpty()) {
                        JOptionPane.showMessageDialog(view, "Không tìm thấy sách giống tên " + test);
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
                view.getTxt_masach().setText("");
                view.getTxt_tensach().setText("");
                view.getCbo_loai().setSelectedIndex(0);
                view.getTxt_tacgia().setText("");
                view.getTxt_gia().setText("");
                view.getTxt_ngayxb().setText("yyyy-MM-dd");
                view.getCbo_sapxep().setSelectedIndex(0);

                view.getTxt_masach().setEnabled(true);
                //tat them
                view.getBtn_them().setEnabled(true);
                //bat xóa sửa mới
                view.getBtn_xoa().setEnabled(false);
                view.getBtn_sua().setEnabled(false);
                showDataTable();
            }
        });

        //nút loại
        view.getBtn_loai().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                LoaiModel lM = new LoaiModel();
                LoaiView lV = new LoaiView();
                LoaiController lC = new LoaiController(lM, lV);
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
                } else if (view.getCbo_sapxep().getSelectedIndex() == 2) {
                    showDataTableSort(model.sapXepTheoLoaiRoiTheoGia());
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
