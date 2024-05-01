import java.util.Scanner;

class Employee {
    private String name;
    private int age;
    private String dateOfBirth;

    // Constructor to initialize the member variables
    public Employee(String name, int age, String dateOfBirth) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    // Method to generate a password
    public String generatePassword() {
        String[] dobParts = dateOfBirth.split("/");
        String year = dobParts[2];
        String[] nameParts = name.split(" ");
        String lastName = nameParts[nameParts.length - 1];
        return lastName + " " + year;
    }

    // Method to create an Employee object from a string
    public static Employee createEmployee(String str) {
        String[] parts = str.split(",");
        String name = parts[0];
        String dateOfBirth = parts[1];
        int age = Integer.parseInt(parts[2]);
        return new Employee(name, age, dateOfBirth);
    }

    // Method to print the details of the Employee
    public void printDetails() {
        String[] nameParts = name.split(" ");
        String firstName = nameParts[0];
        String middleName = "";
        if (nameParts.length > 2) {
            middleName = nameParts[1];
        }
        String lastName = nameParts[nameParts.length - 1];
        String[] dobParts = dateOfBirth.split("/");
        String dob = dobParts[0] + "-" + dobParts[1] + "-" + dobParts[2];
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);
        System.out.println("DOB: " + dob);
        System.out.println("Age: " + age);
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name, date of birth, and age (comma separated): ");
        String input = scanner.nextLine();
        Employee employee = Employee.createEmployee(input);
        System.out.println("Password: " + employee.generatePassword());
        employee.printDetails();
    }
}