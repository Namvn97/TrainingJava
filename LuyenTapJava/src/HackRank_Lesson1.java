public class HackRank_Lesson1 {
    static int sockMerchant(int n, int[] ar) {
        int result = 0;
        int size = ar.length;
        int[] saveNumber = new int[size];
        for (int i = 0; i < size; i++) {
            int kq1 = ar[i];
            int count = 1;
            boolean check = false;
            for (int value : saveNumber) {
                if (kq1 == value) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                for (int k = i + 1; k < size; k++) {
                    int kq2 = ar[k];
                    if (kq1 == kq2) {
                        count++;
                    }
                }
                saveNumber[i] = kq1;
                int sum = count / 2;
                result += sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ar = {4, 5, 5, 5, 6, 6, 4, 1, 4, 4, 3, 6, 6, 3, 6, 1, 4, 5, 5, 5};
        System.out.println(sockMerchant(20, ar));
    }

    // đề bài
    /*
    John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of
    integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
    For example, there are n = 20 socks with colors ar = {4, 5, 5, 5, 6, 6, 4, 1, 4, 4, 3, 6, 6, 3, 6, 1, 4, 5, 5, 5}.
    There is one pair of color 1,3,4,5,6 and one of color.There are three odd socks left, one of each color.
    The number of pairs is 2.
    Function Description Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.
    sockMerchant has the following parameter(s):
        n: the number of socks in the pile
        ar: the colors of each sock
     */

}
