/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doansach.View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class SachView extends javax.swing.JFrame {

    /**
     * Creates new form SachView
     */
    public SachView() {
        initComponents();
    }

    public JComboBox<String> getCbo_loai() {
        return cbo_loai;
    }

    public void setCbo_loai(JComboBox<String> cbo_loai) {
        this.cbo_loai = cbo_loai;
    }

    public JButton getBtn_loai() {
        return btn_loai;
    }

    public void setBtn_loai(JButton btn_loai) {
        this.btn_loai = btn_loai;
    }

    public JButton getBtn_moi() {
        return btn_moi;
    }

    public void setBtn_moi(JButton btn_moi) {
        this.btn_moi = btn_moi;
    }

    public JButton getBtn_sua() {
        return btn_sua;
    }

    public void setBtn_sua(JButton btn_sua) {
        this.btn_sua = btn_sua;
    }

    public JButton getBtn_them() {
        return btn_them;
    }

    public void setBtn_them(JButton btn_them) {
        this.btn_them = btn_them;
    }

    public JButton getBtn_tim() {
        return btn_tim;
    }

    public void setBtn_tim(JButton btn_tim) {
        this.btn_tim = btn_tim;
    }

    public JButton getBtn_xoa() {
        return btn_xoa;
    }

    public void setBtn_xoa(JButton btn_xoa) {
        this.btn_xoa = btn_xoa;
    }

    public JComboBox getCbo_sapxep() {
        return cbo_sapxep;
    }

    public void setCbo_sapxep(JComboBox cbo_sapxep) {
        this.cbo_sapxep = cbo_sapxep;
    }

    public JTable getTbl_sach() {
        return tbl_sach;
    }

    public void setTbl_sach(JTable tbl_sach) {
        this.tbl_sach = tbl_sach;
    }

    public JTextField getTxt_gia() {
        return txt_gia;
    }

    public void setTxt_gia(JTextField txt_gia) {
        this.txt_gia = txt_gia;
    }

//    public JTextField getTxt_loai() {
//        return txt_loai;
//    }
//
//    public void setTxt_loai(JTextField txt_loai) {
//        this.txt_loai = txt_loai;
//    }

    public JTextField getTxt_masach() {
        return txt_masach;
    }

    public void setTxt_masach(JTextField txt_masach) {
        this.txt_masach = txt_masach;
    }

    public JTextField getTxt_ngayxb() {
        return txt_ngayxb;
    }

    public void setTxt_ngayxb(JTextField txt_ngayxb) {
        this.txt_ngayxb = txt_ngayxb;
    }

    public JTextField getTxt_tacgia() {
        return txt_tacgia;
    }

    public void setTxt_tacgia(JTextField txt_tacgia) {
        this.txt_tacgia = txt_tacgia;
    }

    public JTextField getTxt_tensach() {
        return txt_tensach;
    }

    public void setTxt_tensach(JTextField txt_tensach) {
        this.txt_tensach = txt_tensach;
    }

    public JTextField getTxt_tim() {
        return txt_tim;
    }

    public void setTxt_tim(JTextField txt_tim) {
        this.txt_tim = txt_tim;
    }

    public JButton getBtn_logout() {
        return btn_logout;
    }

    public void setBtn_logout(JButton btn_logout) {
        this.btn_logout = btn_logout;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_masach = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_tim = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        btn_loai = new javax.swing.JButton();
        cbo_sapxep = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sach = new javax.swing.JTable();
        txt_tim = new javax.swing.JTextField();
        txt_tensach = new javax.swing.JTextField();
        txt_gia = new javax.swing.JTextField();
        txt_tacgia = new javax.swing.JTextField();
        txt_ngayxb = new javax.swing.JTextField();
        cbo_loai = new javax.swing.JComboBox<>();
        btn_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Sách");

        txt_masach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_masachActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã Sách");

        jLabel3.setText("Tên Sách");

        jLabel4.setText("Loại ");

        jLabel5.setText("Tác giả");

        jLabel6.setText("Giá");

        jLabel7.setText("Ngày XB");

        btn_tim.setText("Tìm");
        btn_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");

        btn_sua.setText("Sửa");

        btn_them.setText("Thêm");

        btn_moi.setText("Mới");

        btn_loai.setText("Trang loại");
        btn_loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loaiActionPerformed(evt);
            }
        });

        cbo_sapxep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chọn sắp xếp", "Sắp xếp theo tên", "Sắp xếp theo loại rồi theo giá" }));

        tbl_sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sach);

        txt_tim.setText("Nhập dữ liệu tìm kiếm");

        txt_tensach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tensachActionPerformed(evt);
            }
        });

        txt_gia.setName(""); // NOI18N
        txt_gia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaActionPerformed(evt);
            }
        });

        txt_tacgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tacgiaActionPerformed(evt);
            }
        });

        txt_ngayxb.setText("yyyy-MM-dd");
        txt_ngayxb.setName(""); // NOI18N
        txt_ngayxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngayxbActionPerformed(evt);
            }
        });

        cbo_loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn loại" }));

        btn_logout.setText("Đăng xuất");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(122, 122, 122))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(29, 29, 29))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(50, 50, 50)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbo_loai, 0, 128, Short.MAX_VALUE)
                                    .addComponent(txt_tensach)
                                    .addComponent(txt_masach))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tacgia, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_gia, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_ngayxb, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_moi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbo_sapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_loai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_sua)
                                .addComponent(btn_them))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_moi)
                                .addComponent(btn_xoa))
                            .addGap(50, 50, 50))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_masach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txt_tensach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbo_loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(btn_logout))
                            .addGap(10, 10, 10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tacgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ngayxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_sapxep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tim)
                    .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_loai))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_timActionPerformed

    private void txt_masachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_masachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_masachActionPerformed

    private void txt_tensachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tensachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tensachActionPerformed

    private void txt_giaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaActionPerformed

    private void txt_tacgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tacgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tacgiaActionPerformed

    private void txt_ngayxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngayxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngayxbActionPerformed

    private void btn_loaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_loaiActionPerformed

    private void tbl_sachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sachMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_sachMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SachView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_loai;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_tim;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbo_loai;
    private javax.swing.JComboBox cbo_sapxep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_sach;
    private javax.swing.JTextField txt_gia;
    private javax.swing.JTextField txt_masach;
    private javax.swing.JTextField txt_ngayxb;
    private javax.swing.JTextField txt_tacgia;
    private javax.swing.JTextField txt_tensach;
    private javax.swing.JTextField txt_tim;
    // End of variables declaration//GEN-END:variables
}
