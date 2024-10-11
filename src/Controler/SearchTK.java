package Controler;

import DAO.TaiKhoanDAO;
import java.util.ArrayList;
import DTO.TaiKhoanDTO;

/**
 *
 * @author babib
 */
public class SearchTK {

    public static SearchTK getInstance() {
        return new SearchTK();
    }

    public ArrayList<TaiKhoanDTO> searchTatCaAcc(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        for (var tk : armt) {
            String role = "";
            switch (tk.getManhomquyen()) {
                case 1:
                    role = "admin";
                    break;
                case 2:
                    role = "Nhân viên nhập hàng";
                    break;
                case 3:
                    role = "Nhân viên xuất hàng";
                    break;
            }
            
            String status = (tk.getTrangthai() == 1) ? "Hoạt động" : "Ngưng hoạt động";

            if (tk.getTendangnhap().toLowerCase().contains(text.toLowerCase()) || role.toLowerCase().contains(text.toLowerCase())
                    || String.valueOf(status).toLowerCase().contains(text.toLowerCase())) {
                result.add(tk);
            }
        }
        return result;
    }
//    public ArrayList<TaiKhoanDTO> searchTatCaAcc(String text) {
//        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
//        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
//        for (var tk : armt) {
//            String role = String.valueOf(tk.getManhomquyen());
//            if (tk.getTendangnhap().toLowerCase().contains(text.toLowerCase())
//                    || role.toLowerCase().contains(text.toLowerCase())
//                    || String.valueOf(tk.getTrangthai()).toLowerCase().contains(text.toLowerCase())) {
//                result.add(tk);
//            }
//        }
//        return result;
//    }

    public ArrayList<TaiKhoanDTO> searchUserName(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        for (var tk : armt) {
            if (tk.getTendangnhap().toLowerCase().contains(text.toLowerCase())) {
                result.add(tk);
            }
        }
        return result;
    }
}
