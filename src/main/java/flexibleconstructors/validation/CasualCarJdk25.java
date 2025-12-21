package flexibleconstructors.validation;

public class CasualCarJdk25 extends AbstractVehicle {

    public CasualCarJdk25(int speed, int loadCapacity, String name, int numberOfDoors) {
        if (numberOfDoors > 4) {
            throw new IllegalArgumentException("Too much doors for casual cars, can't be more then 4");
        }
        if (numberOfDoors < 1) {
            throw new IllegalArgumentException("On casual cars there should be at least 1 door");
        }
        if (loadCapacity > 150) {
            throw new RuntimeException("Casual cars can't have load capacity larger then 150 kg");
        }
        if (speed > 300) {
            throw new IllegalArgumentException("Speed can't be more then 300 km/h for casual cars, this is not a jet!!");
        }
        if (speed < 10) {
            throw new IllegalArgumentException("Does it really a car bro??? 10 km/h looks like a bicycle");
        }
        super(speed, loadCapacity, name, numberOfDoors);
    }
}
