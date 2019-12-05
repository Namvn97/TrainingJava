import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int tongDiem = 0;
    private static int countDiem = 3;

    private static void baitap() {
        String inputBai1 = "1&2&3|7&8";
        StringBuilder dauvao = new StringBuilder();
        dauvao.append(inputBai1).append(" -> ");
        List<String> listKetQua = new ArrayList<>();
        inputBai1 = inputBai1.replace("&", "");
        int indexChar = inputBai1.indexOf("|");
        int start1 = 0;
        while (start1 < indexChar) {
            int start2 = indexChar + 1;
            String chuoi = String.valueOf(inputBai1.charAt(start1));
            while (start2 < inputBai1.length()) {
                String kq = chuoi + inputBai1.charAt(start2);
                dauvao.append(kq).append(",");
                listKetQua.add(kq);
                start2++;
            }
            start1++;
        }
        System.out.println(dauvao);


        String inputBai2 = "17-02,03-38,37,27";
        StringBuilder chuoi = new StringBuilder();
        for (int i = 0; i < inputBai2.length(); i++) {
            String check = String.valueOf(inputBai2.charAt(i));
            if (!(check.equals(",") || check.equals("-"))) {
                chuoi.append(check);
            } else {
                if (check.equals(",")) {
                    checkNumber(listKetQua, chuoi);

                } else {
                    checkNumber(listKetQua, chuoi);
                    countDiem--;
                }
                chuoi = new StringBuilder();
            }
            if (i == inputBai2.length() - 1) {
                checkNumber(listKetQua, chuoi);
            }
        }
        System.out.println("Số điểm: " + tongDiem);
    }

    private static void checkNumber(List<String> listKetQua, StringBuilder chuoi) {
        for (int j = 0; j < listKetQua.size(); j++) {
            String checkDiem = listKetQua.get(j);
            if (checkDiem.equals(chuoi.toString())) {
                listKetQua.remove(checkDiem);
                tongDiem += countDiem;
                break;
            }
        }
    }

    public static void main(String[] args) {
        baitap();
    }
}
