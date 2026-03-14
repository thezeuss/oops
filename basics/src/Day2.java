
class Car {

    int horsePower;
    String name;
    String color;

    static long noOfWheels = 4;
    static long noOfDoors;

    static {
        System.out.println("Constructing Car static values");
        noOfDoors = 4;
    }

    public Car(int horsePower, String name, String color) {
        this.horsePower = horsePower;
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "horsePower=" + horsePower +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class Day2 {


    static void main() {

        System.out.println(Car.noOfDoors);

        Car car = new Car(1200, "BMW", "Red");

        Car car2 = new Car(1200, "Mdz", "Red");

        System.out.println(car2);
        System.out.println(car);

        System.out.println(Car.noOfWheels);

    }
}


