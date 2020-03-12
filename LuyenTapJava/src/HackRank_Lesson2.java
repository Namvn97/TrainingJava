public class HackRank_Lesson2 {

    private static int countingValleys(int i, String s) {
        char UP = 'U';
        int result = 0;
        int size = s.length();
        int check = 0;
        boolean flag = false;
        for (int a = 0; a < size; a++) {
            char kq1 = s.charAt(a);
            if ((kq1 == UP)) {
                check++;
            } else {
                check--;
            }

            if(check < 0 && !flag){
                result++;
                flag = true;
            }

            if(check == 0){
                flag = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "DDUUDDUDUUUD";
        System.out.println(countingValleys(12, s));
    }
}

    // đề bài
    /*
    Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography.
    During his last hike he took exactly n steps. For every step he took, he noted if it was an uphill, U , or a downhill, D step.
    Gary's hikes start and end at sea level and each step up or down represents a 1 unit change in altitude.
    We define the following terms:A mountain is a sequence of consecutive steps above sea level,
    starting with a step up from sea level and ending with a step down to sea level.
    A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending
    with a step up to sea level.
    Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.
    For example, if Gary's path is s = DDUUDDUDUUUD , he first enters a valley 2 units deep. Then he climbs out an up
    onto a mountain 2 units high.
    Finally, he returns to sea level and ends his hike.Function Description
    Complete the countingValleys function in the editor below. It must return an integer that denotes the
    number of valleys Gary traversed.

    countingValleys has the following parameter(s):
        n: the number of steps Gary takes
        s: a string describing his path
     */
