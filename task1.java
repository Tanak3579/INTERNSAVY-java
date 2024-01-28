import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Temperature Converter!");
        System.out.println("Choose an option:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                convertFahrenheitToCelsius();
                break;
            case 2:
                convertCelsiusToFahrenheit();
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
        }

        scanner.close();
    }

    private static void convertFahrenheitToCelsius() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter temperature in Fahrenheit:");
        double fahrenheit = scanner.nextDouble();

        double celsius = (fahrenheit - 32) * 5/9;

        System.out.println(fahrenheit + "°F is equal to " + celsius + "°C.");
    }

    private static void convertCelsiusToFahrenheit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter temperature in Celsius:");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 9/5) + 32;

        System.out.println(celsius + "°C is equal to " + fahrenheit + "°F.");
    }
}
