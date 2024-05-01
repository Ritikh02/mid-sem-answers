import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Car {
    private String modelNo;
    private String name;
    private double price;

    public Car(String modelNo, String name, double price) {
        this.modelNo = modelNo;
        this.name = name;
        this.price = price;
    }

    public String getModelNo() {
        return modelNo;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Model No: " + modelNo + ", Name: " + name + ", Price: $" + price;
    }
}

class CarApp {
    private ArrayList<Car> carShowroom;

    public CarApp() {
        carShowroom = new ArrayList<>();
    }

    public void addCar(Car car) {
        carShowroom.add(car);
    }

    public void sortCarsByPrice() {
        Collections.sort(carShowroom, Comparator.comparingDouble(Car::getPrice));
    }

    public Car searchCarByPrice(double price) {
        for (Car car : carShowroom) {
            if (car.getPrice() == price) {
                return car;
            }
        }
        return null;
    }

    public void displayCars() {
        for (Car car : carShowroom) {
            System.out.println(car);
        }
    }

}

public class Q2 {
    public static void main(String[] args) {
        CarApp carApp = new CarApp();

        // Adding cars to the showroom
        carApp.addCar(new Car("001", "Toyota Camry", 25000));
        carApp.addCar(new Car("002", "Honda Civic", 22000));
        carApp.addCar(new Car("003", "Ford Mustang", 40000));
        carApp.addCar(new Car("004", "Chevrolet Corvette", 65000));

        // Sorting the showroom by price
        carApp.sortCarsByPrice();

        // Displaying the sorted cars
        System.out.println("Cars in the showroom after sorting by price:");
        carApp.displayCars();

        // Searching for a car by price
        double searchPrice = 22000;
        Car searchedCar = carApp.searchCarByPrice(searchPrice);
        if (searchedCar != null) {
            System.out.println("\nFound car with price $" + searchPrice + ": " + searchedCar);
        } else {
            System.out.println("\nCar with price $" + searchPrice + " not found.");
        }
    }
}
