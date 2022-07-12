import java.time.Duration;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        LocalDateTime startParking = LocalDateTime.now();
        LocalDateTime endParking = LocalDateTime.now().plusDays(1);
        int p = startParking.compareTo(endParking);
        Duration duration = Duration.between(startParking, endParking);

        System.out.println(startParking.isAfter(endParking));
    }
}
