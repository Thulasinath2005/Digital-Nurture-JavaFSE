// Exercise 17: Class and Object Creation
public class CarDemo {

    static class Car {
        String make;
        String model;
        int year;

        Car(String make, String model, int year) {
            this.make  = make;
            this.model = model;
            this.year  = year;
        }

        void displayDetails() {
            System.out.println(year + " " + make + " " + model);
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Honda",  "Civic", 2023);
        Car car3 = new Car("Tesla",  "Model 3", 2024);

        car1.displayDetails();
        car2.displayDetails();
        car3.displayDetails();
    }
}
