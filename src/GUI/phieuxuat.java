/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Controler.SearchPhieuXuat;
import BUS.PhieuXuatBUS;
import DTO.NhanVienDTO;
import DTO.PhieuXuatDTO;
import GUI.add.addphieuxuat;
import GUI.details.detailsphieuxuat;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NeON
 */
public final class phieuxuat extends javax.swing.JPanel {

    private NhanVienDTO nhanVienDTO;
    private int maQuyen;
    ArrayList<PhieuXuatDTO> list = new ArrayList<PhieuXuatDTO>();
    JpanelLoader jp = new JpanelLoader();
    PhieuXuatBUS pxBUS = new PhieuXuatBUS();

    int current = 0;

    public phieuxuat(NhanVienDTO nhanVienDTO, int maQuyen) {
        initComponents();
        this.nhanVienDTO = nhanVienDTO;
        this.maQuyen = maQuyen;
        cbxAllDisplay();
        cbNhanvienDisplay();
        cbKhachhangDisplay();
//        SearchDate();
        list = pxBUS.phieuXuatDAO.selectAll();
        displaytoTable(list);
        tblphieuxuat.setDefaultEditor(Object.class, null);
    }

    public void cbxAllDisplay() {
        cbxAll.addItem("Tất cả");
        int count = tblphieuxuat.getColumnCount();
        for (int i = 1; i < count; i++) {
            cbxAll.addItem("" + tblphieuxuat.getColumnName(i));
        }

    }

    public void cbNhanvienDisplay() {
        cbnhanvien.addItem("Tất cả");
        ArrayList<String> listnv = pxBUS.phieuXuatDAO.selectAllNhanvien();
        int count = listnv.size();
        for (int i = 0; i < count; i++) {
            cbnhanvien.addItem("" + listnv.get(i));
        }
    }

    public void cbKhachhangDisplay() {
        cbkhachhang.addItem("Tất cả");
        ArrayList<String> listkh = pxBUS.phieuXuatDAO.selectAllKhachhang();
        int count = listkh.size();
        for (int i = 0; i < count; i++) {
            cbkhachhang.addItem("" + listkh.get(i));
        }
    }

    public void displaytoTable(ArrayList<PhieuXuatDTO> list) {
        try {
            DefaultTableModel dt = (DefaultTableModel) tblphieuxuat.getModel();
            dt.setRowCount(0);
            int index = 1;
            for (PhieuXuatDTO i : list) {
                dt.addRow(new Object[]{
                    index, i.getMaphieuxuat(), i.getTenkhachhang(), i.getTennvnhap(), i.getThoigian(), i.getTongtien()
                });
                index++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SearchDate() {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date from = formatter.parse("" + DateFrom.getDate());
            java.util.Date to = formatter.parse("" + DateTo.getDate());
            if (from == null && to == null) {
                result = pxBUS.phieuXuatDAO.selectAll();
            } else {
                result = SearchPhieuXuat.getInstance().searchDate(from, to);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        displaytoTable(result);
    }

    public PhieuXuatDTO getPhieuXuatSelect() {
        int i_row = tblphieuxuat.getSelectedRow();
        PhieuXuatDTO px = pxBUS.phieuXuatDAO.selectAll().get(i_row);
        return px;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        cbxAll = new javax.swing.JComboBox<>();
        jToolBar4 = new javax.swing.JToolBar();
        btnThem = new javax.swing.JButton();
        btnchitiet = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbkhachhang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbnhanvien = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtfromMoney = new javax.swing.JTextField();
        txttoMoney = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        DateFrom = new com.toedter.calendar.JDateChooser();
        DateTo = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblphieuxuat = new javax.swing.JTable();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setPreferredSize(new java.awt.Dimension(1110, 90));

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        jButton24.setText("Làm mới");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        txttimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimkiemKeyReleased(evt);
            }
        });

        cbxAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAllActionPerformed(evt);
            }
        });

        jToolBar4.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar4.setBorder(null);
        jToolBar4.setRollover(true);

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jToolBar4.add(btnThem);

        btnchitiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnchitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detail.png"))); // NOI18N
        btnchitiet.setText("XEM CHI TIẾT");
        btnchitiet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnchitiet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnchitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchitietActionPerformed(evt);
            }
        });
        jToolBar4.add(btnchitiet);
        jToolBar4.add(jSeparator4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton24)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Khách hàng");

        cbkhachhang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbkhachhangItemStateChanged(evt);
            }
        });

        jLabel2.setText("Nhân viên xuất");

        cbnhanvien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbnhanvienItemStateChanged(evt);
            }
        });

        jLabel3.setText("Từ ngày");

        jLabel4.setText("Đến ngày");

        jLabel5.setText("Từ số tiền (VND)");

        txtfromMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfromMoneyKeyReleased(evt);
            }
        });

        txttoMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttoMoneyKeyReleased(evt);
            }
        });

        jLabel6.setText("Đến số tiền (VND)");

        DateFrom.setDateFormatString("yyyy-MM-dd");

        DateTo.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(DateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(DateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtfromMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txttoMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbnhanvien)
                            .addComponent(txtfromMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(txttoMoney)
                            .addComponent(DateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DateTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tblphieuxuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã phiếu xuất", "Khách hàng", "Nhân viên nhập", "Thời gian", "Tổng tiền"
            }
        ));
        tblphieuxuat.setRowHeight(50);
        jScrollPane2.setViewportView(tblphieuxuat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAllActionPerformed

    private void txttimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimkiemKeyReleased
        // TODO add your handling code here:
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        String text = txttimkiem.getText();
        String choose = (String) cbxAll.getSelectedItem();
        switch (choose) {
            case "Tất cả":
                result = SearchPhieuXuat.getInstance().searchTatCa(text);
                break;
            case "Mã phiếu xuất":
                result = SearchPhieuXuat.getInstance().searchMaphieuxuat(text);
                break;
            case "Khách hàng":
                result = SearchPhieuXuat.getInstance().searchTenkhachhang(text);
                break;
            case "Nhân viên nhập":
                result = SearchPhieuXuat.getInstance().searchTennvnhap(text);
                break;
            case "Thời gian":
                result = SearchPhieuXuat.getInstance().searchThoigian(text);
                break;
            case "Tổng tiền":
                result = SearchPhieuXuat.getInstance().searchTongtien(text);
        }
        displaytoTable(result);
    }//GEN-LAST:event_txttimkiemKeyReleased

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        addphieuxuat apn = new addphieuxuat(nhanVienDTO);
        if (maQuyen == 1) {
            jp.jPanelLoader(admin.panel_load, apn);
        } else {
            jp.jPanelLoader(nvxuathang.panel_load, apn);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbkhachhangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbkhachhangItemStateChanged
        // TODO add your handling code here:
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        String choose = (String) cbkhachhang.getSelectedItem();
        if (choose.equals("Tất cả")) {
            result = pxBUS.phieuXuatDAO.selectAll();
        } else {
            result = SearchPhieuXuat.getInstance().searchTenkhachhang(choose);
        }
        displaytoTable(result);
    }//GEN-LAST:event_cbkhachhangItemStateChanged

    private void cbnhanvienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbnhanvienItemStateChanged
        // TODO add your handling code here:
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        String choose = (String) cbnhanvien.getSelectedItem();
        if (choose.equals("Tất cả")) {
            result = pxBUS.phieuXuatDAO.selectAll();
        } else {
            result = SearchPhieuXuat.getInstance().searchTennvnhap(choose);
        }
        displaytoTable(result);
    }//GEN-LAST:event_cbnhanvienItemStateChanged

    private void txtfromMoneyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfromMoneyKeyReleased
        // TODO add your handling code here:
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        long from = Long.parseLong(txtfromMoney.getText());
        long to = Long.parseLong(txttoMoney.getText());
        if (txtfromMoney.getText().isEmpty() || txttoMoney.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống 1 trong 2 ô nhập số tiền !");
        } else if (txtfromMoney.getText().isEmpty() && txttoMoney.getText().isEmpty()) {
            result = pxBUS.phieuXuatDAO.selectAll();
        } else {
            result = SearchPhieuXuat.getInstance().searchTien(from, to);
        }
        displaytoTable(result);
    }//GEN-LAST:event_txtfromMoneyKeyReleased

    private void txttoMoneyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttoMoneyKeyReleased
        // TODO add your handling code here:
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        long from = Long.parseLong(txtfromMoney.getText());
        long to = Long.parseLong(txttoMoney.getText());
        if (txtfromMoney.getText().isEmpty() || txttoMoney.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống 1 trong 2 ô nhập số tiền !");
        } else if (txtfromMoney.getText().isEmpty() && txttoMoney.getText().isEmpty()) {
            result = pxBUS.phieuXuatDAO.selectAll();
        } else {
            result = SearchPhieuXuat.getInstance().searchTien(from, to);
        }
        displaytoTable(result);
    }//GEN-LAST:event_txttoMoneyKeyReleased

    private void btnchitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchitietActionPerformed
        // TODO add your handling code here:
        if (tblphieuxuat.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu xuất để xem");
        } else {
            detailsphieuxuat a = new detailsphieuxuat(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnchitietActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        cbxAll.setSelectedIndex(0);
        txttimkiem.setText("");
        cbkhachhang.setSelectedIndex(0);
        cbnhanvien.setSelectedIndex(0);
        txtfromMoney.setText("");
        txttoMoney.setText("");
    }//GEN-LAST:event_jButton24ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateFrom;
    private com.toedter.calendar.JDateChooser DateTo;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnchitiet;
    private javax.swing.JComboBox<String> cbkhachhang;
    private javax.swing.JComboBox<String> cbnhanvien;
    private javax.swing.JComboBox<String> cbxAll;
    private javax.swing.JButton jButton24;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JTable tblphieuxuat;
    private javax.swing.JTextField txtfromMoney;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttoMoney;
    // End of variables declaration//GEN-END:variables
}
