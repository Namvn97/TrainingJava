public class HackRank_Lesson3 {
    static int jumpingOnClouds(int[] c) {
        int die = 1;
        int result = 0;
        int size = c.length;
        int index = 0;
        for (int i = index; i < size; i++) {
            int count = index + 2;
            if (count < size && c[count] != die) {
                index = count;
            } else {
                index = count - 1;
            }
            result++;
            if (index >= size - 1) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] c = {0, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(c));
    }
}
    // đề bài
    /*

     */
