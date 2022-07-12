import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Test {
    public static void main(String[] args) {
        LocalDateTime startParking = LocalDateTime.now();
        LocalDateTime endParking = LocalDateTime.now().plusDays(1);
        int p = startParking.compareTo(endParking);
        Duration duration = Duration.between(startParking, endParking);

        System.out.println(startParking);
        System.out.println(startParking.toLocalTime().isBefore(LocalTime.of(21,01)));
    }
}
