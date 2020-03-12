import java.util.ArrayList;
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

//        for (int i = 0; i < a.size(); i++) {
//            System.out.println("a"  + a.get(i));
//            for (int j = 0; j < b.size(); j++) {
//                System.out.println("b"  + b.get(j));
//            }
//            System.out.println("hellonam");
//        }

        Iterator iterA = a.iterator();
        Iterator iterB = b.iterator();
        while (iterA.hasNext()) {
            System.out.println("a" + iterA.next());
            while (iterB.hasNext()) {
                System.out.println("b" + iterB.next());
            }
            System.out.println("hello nam");
        }
    }
}
