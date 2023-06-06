package vn.funix.FX22605.java.asm01;

import java.util.Random;
import java.util.Scanner;

public class Asm01 {
    public static void main(String[] args) {
        System.out.println("+--------------------------------------------+");
        System.out.println("|      NGAN HANG SO | FX22605@v1.0.0         |");
        System.out.println("+--------------------------------------------+");
        System.out.println("| 1. Nhap CCCD                               |");
        System.out.println("| 0. Thoat                                   |");
        System.out.println("+--------------------------------------------+");

        Scanner sc = new Scanner(System.in);
        System.out.print("Chon chuc nang: ");
        int luaChon = sc.nextInt();
        do {
            if (luaChon == 1) {
                //kiem tra khong phai robot
                Random rd = new Random();
                int numCheck = rd.nextInt(900) + 100;
                System.out.println("Nhap ma xac thuc: " + numCheck);
                int numIn = sc.nextInt();
                sc.nextLine();
                if (numIn == numCheck) {
                    String cCCD = null;
                    System.out.print("Vui long nhap so CCCD: ");
                    cCCD = sc.nextLine();
                    do {
                        if (validate(cCCD)) {
                            int chucNang;
                            do {
                                System.out.println("    | 1. Kiem tra noi sinh");
                                System.out.println("    | 2. Kiem tra tuoi, gioi tinh");
                                System.out.println("    | 3. Kiem tra so ngau nhien");
                                System.out.println("    | 0. Thoat");
                                System.out.println("Chuc nang:");
                                chucNang = sc.nextInt();
                                if (chucNang == 1) {
                                    //1. Kiem tra noi sinh
                                    kiemTraNoiSinh(cCCD.substring(0,3));
                                } else if (chucNang == 2) {
                                    //2. Kiem tra tuoi, gioi tinh
                                    kiemTraGioiTinhNamSinh(cCCD.substring(3,6));
                                } else if (chucNang == 3) {
                                    //3. Kiem tra so ngau nhien
                                    kiemTraSoNgauNhien(cCCD.substring(6));
                                } else if(chucNang!=0 && chucNang!=1 && chucNang!=2 && chucNang!=3){
                                    System.out.println("Vui long nhap lai!");
                                }
                            } while (chucNang != 0);

                            luaChon = 0;
                            break;
                        } else {
                            System.out.println("CCCD khong hop le! Vui long nhap lai hoac nhap 'No' de thoat");
                            cCCD = sc.next();
                        }
                    } while (!cCCD.equals("No"));
                    break;
                } else {
                    System.out.println("Ma xac thuc khong dung, vui long thu lai:");
                }
            }
        } while (luaChon != 0);
    }

    public static boolean validate(String input) {
        // Kiểm tra độ dài chuỗi
        if (input.length() != 12) {
            return false;
        }

        // Kiểm tra các ký tự của chuỗi có phải là ký tự từ 0-9
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void kiemTraNoiSinh(String st) {
        String ten = "";

        switch (st) {
            case "001":
                ten = "Hà Nội";
                break;
            case "002":
                ten = "Hà Giang";
                break;
            case "004":
                ten = "Cao Bằng";
                break;
            case "006":
                ten = "Bắc Kạn";
                break;
            case "008":
                ten = "Tuyên Quang";
                break;
            case "010":
                ten = "Lào Cai";
                break;
            case "011":
                ten = "Điện Biên";
                break;
            case "012":
                ten = "Lai Châu";
                break;
            case "014":
                ten = "Sơn La";
                break;
            case "015":
                ten = "Yên Bái";
                break;
            case "017":
                ten = "Hòa Bình";
                break;
            case "019":
                ten = "Thái Nguyên";
                break;
            case "020":
                ten = "Lạng Sơn";
                break;
            case "022":
                ten = "Quảng Ninh";
                break;
            case "024":
                ten = "Bắc Giang";
                break;
            case "025":
                ten = "Phú Thọ";
                break;
            case "026":
                ten = "Vĩnh Phúc";
                break;
            case "027":
                ten = "Bắc Ninh";
                break;
            case "030":
                ten = "Hải Dương";
                break;
            case "031":
                ten = "Hải Phòng";
                break;
            case "033":
                ten = "Hưng Yên";
                break;
            case "034":
                ten = "Thái Bình";
                break;
            case "035":
                ten = "Hà Nam";
                break;
            case "036":
                ten = "Nam Định";
                break;
            case "037":
                ten = "Ninh Bình";
                break;
            case "038":
                ten = "Thanh Hóa";
                break;
            case "040":
                ten = "Nghệ An";
                break;
            case "042":
                ten = "Hà Tĩnh";
                break;
            case "044":
                ten = "Quảng Bình";
                break;
            case "045":
                ten = "Quảng Trị";
                break;
            case "046":
                ten = "Thừa Thiên Huế";
                break;
            case "048":
                ten = "Đà Nẵng";
                break;
            case "049":
                ten = "Quảng Nam";
                break;
            case "051":
                ten = "Quảng Ngãi";
                break;
            case "052":
                ten = "Bình Định";
                break;
            case "054":
                ten = "Phú Yên";
                break;
            case "056":
                ten = "Khánh Hòa";
                break;
            case "058":
                ten = "Ninh Thuận";
                break;
            case "060":
                ten = "Bình Thuận";
                break;
            case "062":
                ten = "Kon Tum";
                break;
            case "064":
                ten = "Gia Lai";
                break;
            case "066":
                ten = "Đắk Lắk";
                break;
            case "067":
                ten = "Đắk Nông";
                break;
            case "068":
                ten = "Lâm Đồng";
                break;
            case "070":
                ten = "Bình Phước";
                break;
            case "072":
                ten = "Tây Ninh";
                break;
            case "074":
                ten = "Bình Dương";
                break;
            case "075":
                ten = "Đồng Nai";
                break;
            case "077":
                ten = "Bà Rịa - Vùng Tàu";
                break;
            case "079":
                ten = "Hồ Chí Minh";
                break;
            case "080":
                ten = "Long An";
                break;
            case "082":
                ten = "Tiền Giang";
                break;
            case "083":
                ten = "Bến Tre";
                break;
            case "084":
                ten = "Trà Vinh";
                break;
            case "086":
                ten = "Vĩnh Long";
                break;
            case "087":
                ten = "Đồng Tháp";
                break;
            case "089":
                ten = "An Giang";
                break;
            case "091":
                ten = "Kiên Giang";
                break;
            case "092":
                ten = "Cần Thơ";
                break;
            case "093":
                ten = "Hậu Giang";
                break;
            case "094":
                ten = "Sóc Trăng";
                break;
            case "095":
                ten = "Bạc Liêu";
                break;
            case "096":
                ten = "Cà Mau";
                break;
        }
        System.out.println("Noi sinh: "+ ten);
    }

    public static void kiemTraGioiTinhNamSinh(String st) {
        String gioiTinh = "";
        String namSinh="";
        switch (st.charAt(0)) {
            case '0':
            case '2':
            case '4':
            case '6':
            case '8':
                gioiTinh = "Nam";
                break;
            case '1':
            case '3':
            case '5':
            case '7':
            case '9':
                gioiTinh = "Nu";
                break;
        }
        switch (st.charAt(0)) {
            case '0':
            case '1':
                namSinh = "19"+st.substring(1);
                break;
            case '2':
            case '3':
                namSinh = "20"+st.substring(1);
                break;
            case '4':
            case '5':
                namSinh = "21"+st.substring(1);
                break;
            case '6':
            case '7':
                namSinh = "22"+st.substring(1);
                break;
            case '8':
            case '9':
                namSinh = "23"+st.substring(1);
                break;
        }
        System.out.println("Gioi tinh: "+gioiTinh+" | "+namSinh);
    }

    public static void kiemTraSoNgauNhien(String st){
        System.out.println("So ngau nhien: "+ st);
    }
}
