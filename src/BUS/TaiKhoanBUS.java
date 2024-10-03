package BUS;

import DAO.NhomQuyenDAO;
import DAO.TaiKhoanDAO;
import DTO.NhomQuyenDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

public class TaiKhoanBUS {

    private ArrayList<TaiKhoanDTO> listTaiKhoan;
    public final TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private ArrayList<NhomQuyenDTO> listNhomQuyen;
    private NhomQuyenDAO nhomQuyenDAO = NhomQuyenDAO.getInstance();

    public TaiKhoanBUS() {
        this.listTaiKhoan = TaiKhoanDAO.getInstance().selectAll();
        this.listNhomQuyen = NhomQuyenDAO.getInstance().selectAll();
    }

    public NhomQuyenDTO getNhomQuyenDTO(int manhom) {
        return nhomQuyenDAO.selectById(manhom + "");
    }

    public ArrayList<TaiKhoanDTO> getTaiKhoanAll() {
        return listTaiKhoan;
    }

    public TaiKhoanDTO getTaiKhoan(int index) {
        return listTaiKhoan.get(index);
    }

    public int getTaiKhoanByMaNV(int manv) {
        int i = 0;
        int vitri = -1;
        while (i < this.listTaiKhoan.size() && vitri == -1) {
            if (listTaiKhoan.get(i).getManv() == manv) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }
    
    public int getMaNVbyUsername(String username) {
        int i = 0;
        for (TaiKhoanDTO tk : this.listTaiKhoan) {
            if (tk.getTendangnhap().equals(username)) {
                return i = tk.getManv();
            }
        }
        return i;
    }
    
    public Boolean checkExistAccount(String username) {
        for (TaiKhoanDTO tk : this.listTaiKhoan) {
            if (tk.getTendangnhap().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    public Boolean add(TaiKhoanDTO tk) {
        boolean check = tkDAO.insert(tk) != 0;
        if (check) {
            this.listTaiKhoan.add(tk);
        }
        return check;
    }

    public Boolean delete(TaiKhoanDTO tk) {
        boolean check = tkDAO.delete(tk.getManv()) != 0;
        if (check) {
            this.listTaiKhoan.remove(tk);
        }
        return check;
    }

    public Boolean update(TaiKhoanDTO tk) {
        boolean check = tkDAO.update(tk) != 0;
        if (check) {
            this.listTaiKhoan.set(getTaiKhoanByMaNV(tk.getManv()), tk);
        }
        return check;
    }

    public ArrayList<TaiKhoanDTO> search(String txt, String type) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (Integer.toString(i.getManv()).contains(txt) || i.getTendangnhap().contains(txt)) {
                        result.add(i);
                    }
                }
            }
            case "Mã nhân viên" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (Integer.toString(i.getManv()).contains(txt)) {
                        result.add(i);
                    }
                }
            }
            case "Username" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (i.getTendangnhap().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
            }
        }
        return result;
    }

}
