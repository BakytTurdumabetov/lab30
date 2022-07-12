import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {

    ParkingManagement cars = new ParkingManagement();
    cars.createCars();
    cars.createParking();
    cars.createLogBook();
//    cars.printParkingLots();
    cars.loggingOfCars();
    cars.printLogBook();
    cars.printCars();




    }
}