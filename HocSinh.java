package QLHS.qlhs;

public class HocSinh {
    private String maHS;
    private String hoTen;
    private int namSinh;
    private String queQuan;
    private String lop;

    public HocSinh(String maHS, String hoTen, int namSinh, String queQuan, String lop) {
        this.maHS = maHS;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.lop = lop;
    }

    public String getMa() {
        return maHS;
    }

    public void setMa(String maHS) {
        this.maHS = maHS;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "HocSinh: " +
                maHS + " |\t " +
                hoTen + " |\t " +
                namSinh + " |\t " +
                queQuan + " |\t " +
                lop;
    }
}
