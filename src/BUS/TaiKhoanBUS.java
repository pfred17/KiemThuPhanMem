package BUS;

import DAO.NhomQuyenDAO;
import DAO.TaiKhoanDAO;
import DTO.NhomQuyenDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

public class TaiKhoanBUS {

    private final ArrayList<TaiKhoanDTO> listTaiKhoan;
    public final TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private final ArrayList<NhomQuyenDTO> listNhomQuyen;
    private final NhomQuyenDAO nhomQuyenDAO = NhomQuyenDAO.getInstance();

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

    public int getMaNVbyUsername(String username) {
        int i = 0;
        for (TaiKhoanDTO tk : this.listTaiKhoan) {
            if (tk.getUsername().equals(username)) {
                return i = tk.getAccountId();
            }
        }
        return i;
    }

    public Boolean isUsernameExists(String username) {
        for (TaiKhoanDTO tk : this.listTaiKhoan) {
            if (tk.getUsername().equals(username)) {
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
        boolean check = tkDAO.delete(tk.getAccountId()) != 0;
        if (check) {
            this.listTaiKhoan.remove(tk);
        }
        return check;
    }

    public int findAccountByAccountId(int accountId) {
        for (int i = 0; i < this.listTaiKhoan.size(); i++) {
            if (listTaiKhoan.get(i).getAccountId() == accountId) {
                return i;
            }
        }
        return -1;
    }

    public Boolean update(TaiKhoanDTO tk) {
        boolean check = tkDAO.update(tk) != 0;
        if (check) {
            this.listTaiKhoan.set(findAccountByAccountId(tk.getAccountId()), tk);
        }
        return check;
    }

    public ArrayList<TaiKhoanDTO> search(String txt, String type) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (Integer.toString(i.getAccountId()).contains(txt) || i.getUsername().contains(txt)) {
                        result.add(i);
                    }
                }
            }
            case "Mã nhân viên" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (Integer.toString(i.getAccountId()).contains(txt)) {
                        result.add(i);
                    }
                }
            }
            case "Username" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (i.getUsername().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
            }
        }
        return result;
    }

}
