import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFormatDate {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String time = formatter.format(new Date());
        System.out.println(time);

        try (Stream<Path> walk = Files.walk(
                Paths.get("C:\\Users\\phannam\\Downloads\\DMKH\\120"),
                1, FileVisitOption.FOLLOW_LINKS)) {
            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());
            result.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
