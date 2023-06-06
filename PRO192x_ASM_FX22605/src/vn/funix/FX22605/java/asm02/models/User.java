package vn.funix.FX22605.java.asm02.models;

public class User {
    private String customerId;
    private String name;

    public User() {
    }

    public User(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public User(String customerId){
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean checkId(String id){
        if(checkLenght(id) && checkAddress(id.substring(0,3)) && checkGender_Birthday(id.substring(3,6))){
            return true;
        }
        return false;
    }
    public static boolean checkLenght(String input) {
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
    public static boolean checkAddress(String st) {

        switch (st) {
            case "001":
            case "002":
            case "004":
            case "006":
            case "008":
            case "010":
            case "011":
            case "012":
            case "014":
            case "015":
            case "017":
            case "019":
            case "020":
            case "022":
            case "024":
            case "025":
            case "026":
            case "027":
            case "030":
            case "031":
            case "033":
            case "034":
            case "035":
            case "036":
            case "037":
            case "038":
            case "040":
            case "042":
            case "044":
            case "045":
            case "046":
            case "048":
            case "049":
            case "051":
            case "052":
            case "054":
            case "056":
            case "058":
            case "060":
            case "062":
            case "064":
            case "066":
            case "067":
            case "068":
            case "070":
            case "072":
            case "074":
            case "075":
            case "077":
            case "079":
            case "080":
            case "082":
            case "083":
            case "084":
            case "086":
            case "087":
            case "089":
            case "091":
            case "092":
            case "093":
            case "094":
            case "095":
            case "096":
                return true;
            default:
                return false;
        }
    }

    public static boolean checkGender_Birthday(String st) {
        switch (st.charAt(0)) {
            case '0':
            case '2':
            case '4':
            case '6':
            case '8':
            case '1':
            case '3':
            case '5':
            case '7':
            case '9':
                return true;
            default:
                return false;
        }
    }
}
