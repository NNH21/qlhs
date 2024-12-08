package QLHS.qlhs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HocSinhList {
    // Hien thi thong tin tat ca hoc sinh
    public List<HocSinh> getAllHocSinh() {
        List<HocSinh> listHocSinh = new ArrayList<HocSinh>();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = dbConnect.connectToDatabase();
            if (conn != null) {
                stm = conn.createStatement();
                String sql = "SELECT * FROM qlhs";
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    String maHS = rs.getString(1);
                    String hoTen = rs.getString(2);
                    int namSinh = rs.getInt(3);
                    String queQuan = rs.getString(4);
                    String lop = rs.getString(5);
                    listHocSinh.add(new HocSinh(maHS, hoTen, namSinh, queQuan, lop));
                }
            }
        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }
        return listHocSinh;
    }

    // Them hoc sinh
    public boolean addHocSinh(HocSinh hs) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int row = 0;
        try {
            conn = dbConnect.connectToDatabase();
            if (conn != null) {
                String sql = "INSERT INTO qlhs VALUES (?, ?, ?, ?, ?)";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, hs.getMa());
                pstm.setString(2, hs.getHoTen());
                pstm.setInt(3, hs.getNamSinh());
                pstm.setString(4, hs.getQueQuan());
                pstm.setString(5, hs.getLop());
                row = pstm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }
        return row > 0;
    }

    public boolean isMaHSTonTai(String maHS) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = dbConnect.connectToDatabase();
            if (conn != null) {
                String sql = "SELECT * FROM qlhs WHERE maHS = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, maHS);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }
        return false;
    }
    // Xoa hoc sinh
    public boolean deleteHocSinh(String maHS) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int row = 0;
        try {
            conn = dbConnect.connectToDatabase();
            if (conn != null) {
                String sql = "DELETE FROM qlhs WHERE maHS = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, maHS);
                row = pstm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }
        return row > 0;
    }




}
