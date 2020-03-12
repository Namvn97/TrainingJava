public class HackRank_Lesson4 {

    static long repeatedString(String s, long n) {
        long result = 0;
        int countCharA = 0;

        int sizeString = s.length();
        long soLanInString = n / sizeString;
        long soChuStringThua = n % sizeString;

        for (int j = 0; j < sizeString; j++) {
            if (s.charAt(j) == 'a') {
                countCharA++;
            }
        }
        result += soLanInString * countCharA;
        for (int i = 0; i < soChuStringThua; i++) {
            if (s.charAt(i) == 'a') {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(repeatedString(s, 882787));
    }
}
