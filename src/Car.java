public class Car {
    private String id;
    private StateOfCar stateOfCar;

    public Car(String id, StateOfCar stateOfCar) {
        this.id = id;
        this.stateOfCar = stateOfCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", stateOfCar=" + stateOfCar +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StateOfCar getStateOfCar() {
        return stateOfCar;
    }

    public void setStateOfCar(StateOfCar stateOfCar) {
        this.stateOfCar = stateOfCar;
    }
}
