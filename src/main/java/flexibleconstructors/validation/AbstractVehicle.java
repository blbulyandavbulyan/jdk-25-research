package flexibleconstructors.validation;

public abstract class AbstractVehicle {
    private final int speed;
    private final int loadCapacity;
    private final String name;
    private final int numberOfDoors;

    public AbstractVehicle(int speed, int loadCapacity, String name, int numberOfDoors) {
        this.speed = speed;
        this.loadCapacity = loadCapacity;
        this.name = name;
        this.numberOfDoors = numberOfDoors;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}
