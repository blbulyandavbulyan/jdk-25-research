package flexibleconstructors.validation;

public class CasualCar extends AbstractVehicle {
    public CasualCar(int speed, int loadCapacity, String name, int numberOfDoors) {
        super(validateSpeed(speed), validateCapacity(loadCapacity), name, validateNumberOfDoors(numberOfDoors));
    }

    private static int validateNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors > 4) {
            throw new IllegalArgumentException("Too much doors for casual cars, can't be more then 4");
        }
        if (numberOfDoors < 1) {
            throw new IllegalArgumentException("On casual cars there should be at least 1 door");
        }
        return numberOfDoors;
    }

    private static int validateCapacity(int loadCapacity) {
        if (loadCapacity > 150) {
            throw new RuntimeException("Casual cars can't have load capacity larger then 150 kg");
        }
        return loadCapacity;
    }

    public static int validateSpeed(int speed) {
        if (speed > 300) {
            throw new IllegalArgumentException("Speed can't be more then 300 km/h for casual cars, this is not a jet!!");
        }
        if (speed < 10) {
            throw new IllegalArgumentException("Does it really a car bro??? 10 km/h looks like a bicycle");
        }
        return speed;
    }
}
