package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DAO.PhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class PhieuNhapBUS {

    public final PhieuNhapDAO phieunhapDAO = new PhieuNhapDAO();
    public final ChiTietPhieuNhapDAO ctPhieuNhapDAO = new ChiTietPhieuNhapDAO();
    NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    NhanVienBUS nvBUS = new NhanVienBUS();

    ArrayList<PhieuNhapDTO> listPhieuNhap;
    ArrayList<ChiTietPhieuNhapDTO> listCtpn;

    public PhieuNhapBUS() {
    }

    public ArrayList<PhieuNhapDTO> getAll() {
        this.listPhieuNhap = phieunhapDAO.selectAll();
        return this.listPhieuNhap;
    }

    public ArrayList<PhieuNhapDTO> getAllList() {
        return this.listPhieuNhap;
    }
    
    public ArrayList<PhieuNhapDTO> getAllCtpn() {
        return this.phieunhapDAO.selectAllCtpn();
    }
    
    public Boolean add(PhieuNhapDTO pn) {
        boolean check = phieunhapDAO.insert(pn) != 0;
        if (check) {
            this.listPhieuNhap.add(pn);
        }
        return check;
    }
    
    public Boolean addCtpn(ChiTietPhieuNhapDTO ctpn) {
        boolean check = ctPhieuNhapDAO.insert(ctpn) != 0;
        if (check) {
            this.listCtpn.add(ctpn);
        }
        return check;
    }
    
    public Boolean update(PhieuNhapDTO pn) {
        boolean check = phieunhapDAO.update(pn) != 0;
        if (check) {
            phieunhapDAO.update(pn);
        }
        return check;
    }
    
    public boolean delete(PhieuNhapDTO phieuNhap, int index) {
        boolean check = phieunhapDAO.delete(phieuNhap) != 0;
        if (check) {
            phieunhapDAO.delete(phieuNhap);
        }
        return check;
    }
}
