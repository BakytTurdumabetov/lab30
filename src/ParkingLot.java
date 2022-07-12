public class ParkingLot {
    private boolean isFree;

    public ParkingLot(boolean isFree) {
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "isFree=" + isFree +
                '}';
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
