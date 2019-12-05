import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int sumScore = 0;
    private static int score = 3;

    private static void baitap() {
        String input1 = "1&2&3|7&8";
        StringBuilder output = new StringBuilder();
        output.append(input1).append(" -> ");
        List<String> results = new ArrayList<>();
        input1 = input1.replace("&", "");
        int indexChar = input1.indexOf("|");
        int start1 = 0;
        while (start1 < indexChar) {
            int start2 = indexChar + 1;
            String chuoi = String.valueOf(input1.charAt(start1));
            while (start2 < input1.length()) {
                String kq = chuoi + input1.charAt(start2);
                output.append(kq).append(",");
                results.add(kq);
                start2++;
            }
            start1++;
        }
        System.out.println(output);


        String input2 = "17-02,03-38,37,27";
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < input2.length(); i++) {
            String check = String.valueOf(input2.charAt(i));
            if (!(check.equals(",") || check.equals("-"))) {
                number.append(check);
            } else {
                if (check.equals(",")) {
                    checkNumber(results, number);

                } else {
                    checkNumber(results, number);
                    score--;
                }
                number = new StringBuilder();
            }
            if (i == input2.length() - 1) {
                checkNumber(results, number);
            }
        }
        System.out.println("Số điểm: " + sumScore);
    }

    private static void checkNumber(List<String> results, StringBuilder numberCheck) {
        for (int j = 0; j < results.size(); j++) {
            String numberResult = results.get(j);
            if (numberResult.equals(numberCheck.toString())) {
                results.remove(numberResult);
                sumScore += score;
                break;
            }
        }
    }

    public static void main(String[] args) {
        baitap();
    }
}
