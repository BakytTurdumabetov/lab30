import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingManagement {
    private LocalDateTime ldt = LocalDateTime.now();
    private List<Car> cars = new ArrayList<>();
    private List<ParkingLot> parkingLots = new ArrayList<>();
    private List<LogBook> logBooks = new ArrayList<>();

    public void createCars(){
        for (int i = 0; i < 10; i++) {
            cars.add(new Car(String.valueOf(i+1), StateOfCar.InRoad));
        }
    }

    public void createParking(){
        for (int i = 0; i < 20; i++) {
            parkingLots.add(new ParkingLot(true));
        }
    }

    public void createLogBook(){
        for (int i = 0; i < 1; i++) {
            logBooks.add(new LogBook(cars.get(i).getId(), -1, null, null));
        }
    }

    public void printLogBook(){
        logBooks.forEach(System.out::println);
    }

    public void printParkingLots(){
        parkingLots.forEach(System.out::println);
    }

    public void printCars(){
        cars.forEach(System.out::println);
    }

    public void loggingOfCars(){
        for (LocalDateTime i = ldt; i.isBefore(ldt.plusDays(3)); i = i.plusMinutes(15)) {
            for (int j = 0; j < cars.size(); j++) {
                int random = new Random().nextInt(100);
                if (random < 4 && cars.get(j).getStateOfCar().equals(StateOfCar.InRoad)){
                    for (int k = 0; k < parkingLots.size(); k++) {
                        if (parkingLots.get(k).isFree()){
                            cars.get(j).setStateOfCar(StateOfCar.InParkingLot);
                            parkingLots.get(k).setFree(false);
                            for (int l = 0; l < logBooks.size(); l++) {
                                if (logBooks.get(l).getParkLot() == -1 && logBooks.get(l).getIdNumber().equals(cars.get(j).getId())){
                                    logBooks.get(l).setStartParking(i);
                                    logBooks.get(l).setParkLot(k + 1);
                                    break;
                                }
                                else {
                                    logBooks.add(new LogBook(cars.get(j).getId(), k + 1, i, null));
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
            for (int j = 0; j < cars.size(); j++) {
                int random = new Random().nextInt(100);
                if (random < 4 && cars.get(j).getStateOfCar().equals(StateOfCar.InParkingLot)){
                    for (int k = 0; k < logBooks.size(); k++) {
                        if (logBooks.get(k).getIdNumber().equals(cars.get(j).getId()) && logBooks.get(k).getStartParking() != null && logBooks.get(k).getEndParking() == null){
                            parkingLots.get(logBooks.get(k).getParkLot() - 1).setFree(true);
                            cars.get(j).setStateOfCar(StateOfCar.InRoad);
                            logBooks.get(k).setEndParking(i);
                            break;
                        }
                    }
                }
            }
        }

        logBooks.removeIf(LogBook::isDurationLess);
        logBooks.removeIf(LogBook::isParkingFree);
        logBooks.sort(LogBook::byIdNumber);
    }

}
