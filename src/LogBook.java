import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LogBook {
    private String idNumber;
    private int parkLot;
    private LocalDateTime startParking;
    private LocalDateTime endParking;

    public LogBook(String idNumber, int parkLot, LocalDateTime startParking, LocalDateTime endParking) {
        this.idNumber = idNumber;
        this.parkLot = parkLot;
        this.startParking = startParking;
        this.endParking = endParking;
    }

    @Override
    public String toString() {
        return "idNumber='" + idNumber + '\'' +
                ", parkLot=" + parkLot +
                ", startParking=" + startParking +
                ", endParking=" + endParking +
                '}';
    }

    public boolean isDurationLess(){
        if (endParking == null){
            return false;
        }
        else {
            Duration duration = Duration.between(startParking, endParking);
            return duration.toMinutes() < 30;
        }
    }

    public static int byIdNumber(LogBook e1, LogBook e2) {
        return e1.idNumber.compareTo(e2.idNumber);
    }

    public boolean isParkingFree(){
        boolean answer = false;
        if (endParking == null){
            answer = false;
        }
        else {
            if (startParking.toLocalTime().isBefore(LocalTime.of(9, 1)) || startParking.toLocalTime().isAfter(LocalTime.of(21,1))
            || endParking.toLocalTime().isBefore(LocalTime.of(9, 1)) || endParking.toLocalTime().isAfter(LocalTime.of(21,1))){
                answer = true;
            }
        }
        return answer;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getParkLot() {
        return parkLot;
    }

    public void setParkLot(int parkLot) {
        this.parkLot = parkLot;
    }

    public LocalDateTime getStartParking() {
        return startParking;
    }

    public void setStartParking(LocalDateTime startParking) {
        this.startParking = startParking;
    }

    public LocalDateTime getEndParking() {
        return endParking;
    }

    public void setEndParking(LocalDateTime endParking) {
        this.endParking = endParking;
    }
}
