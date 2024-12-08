package QLHS.qlhs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        HocSinhList hslist = new HocSinhList();
        List<HocSinh> listHocSinh = new ArrayList<HocSinh>();
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Chuong trinh quan ly hoc sinh.");
            System.out.println("1. Them thong tin hoc sinh.");
            System.out.println("2. Hien thi danh sach hoc sinh.");
            System.out.println("3. Hien thi cac hoc sinh 20 tuoi.");
            System.out.println("4. Cho biet so luong cac hoc sinh co tuoi la 23 va que o DN.");
            System.out.println("5. Xoa hoc sinh theo ma.");
            System.out.println("0. Thoat.");
            System.out.print("Vui long chon so: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    String maHS;
                    do {
                        System.out.println("Nhap ma hoc sinh: ");
                        maHS = sc.nextLine();
                        if (hslist.isMaHSTonTai(maHS)) {
                            System.out.println("Ma hoc sinh da ton tai, vui long nhap lai.");
                        }
                    } while (hslist.isMaHSTonTai(maHS));

                    System.out.println("Nhap ho ten hoc sinh: ");
                    String hoTen = sc.nextLine();
                    System.out.println("Nhap nam sinh: ");
                    int namSinh = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhap que quan: ");
                    String queQuan = sc.nextLine();
                    System.out.println("Nhap lop: ");
                    String lop = sc.nextLine();
                    HocSinh hs = new HocSinh(maHS, hoTen, namSinh, queQuan, lop);
                    if (hslist.addHocSinh(hs)) {
                        System.out.println("Them thanh cong!!!");
                    } else {
                        System.out.println("Them that bai!!!");
                    }
                    break;
                }
                case 2: {
                    listHocSinh = hslist.getAllHocSinh();
                    for (HocSinh hs : listHocSinh) {
                        System.out.println(hs);
                    }
                    break;
                }
                case 3: {
                    listHocSinh = hslist.getAllHocSinh();
                    for (HocSinh hs : listHocSinh) {
                        if (hs.getNamSinh() == 2004) {
                            System.out.println(hs);
                        }
                    }
                    break;
                }
                case 4: {
                    listHocSinh = hslist.getAllHocSinh();
                    int count = 0;
                    List<HocSinh> filteredHocSinh = new ArrayList<>();
                    for (HocSinh hs : listHocSinh) {
                        if (hs.getNamSinh() == 2001 && hs.getQueQuan().equals("Da Nang")) {
                            count++;
                            filteredHocSinh.add(hs);
                        }
                    }
                    System.out.println("So luong hoc sinh co tuoi la 23 va que o DN la: " + count);
                    for (HocSinh hs : filteredHocSinh) {
                        System.out.println(hs);
                    }
                    break;
                }
                case 5: {
                    System.out.println("Nhap ma hoc sinh can xoa: ");
                    String maHS = sc.nextLine();
                    if (hslist.deleteHocSinh(maHS)) {
                        System.out.println("Xoa thanh cong!!!");
                    } else {
                        System.out.println("Xoa that bai!!!");
                    }
                    break;
                }
                case 0: {
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                }
            }
        } while (choice != 0);
    }
}