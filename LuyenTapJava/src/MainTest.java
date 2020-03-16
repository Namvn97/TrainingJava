import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            a.add(i);
        }

        List<Integer> b = new ArrayList<>();
        for (int i = 4; i < 7; i++) {
            b.add(i);
        }
        String key1 = "pos1";
        String key2 = "pos2";
        String key3 = "pos3";
        HashMap<String,List<Integer>> map = new HashMap<>();
        map.put(key1,a);

        System.out.println(map.get(key1));
        System.out.println(map.get(key2));
    }
}
