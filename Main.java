import java.util.Scanner;

/**
 * Lab 1: A menu program that helps the user do conversions (length, weight, time and coins).
 *
 * @author Partner1_Kelvin Myat
 * @author Partner2_Colton
 */
public class Main {

    /**
     * Prints the menu and returns the user's choice.
     * @param sc the Scanner used to read input
     * @return the menu option chosen by the user (1-7)
     */
    public static int menu(Scanner sc) {
        System.out.println("\nConversion Menu");
        System.out.println("1. Convert meters to feet and inches");
        System.out.println("2. Convert feet and inches to meters");
        System.out.println("3. Convert grams to pounds and ounces");
        System.out.println("4. Convert pounds and ounces to grams");
        System.out.println("5. Convert seconds to hours, minutes and seconds");
        System.out.println("6. Convert coins to dollars and leftover cents");
        System.out.println("7. Quit");
        System.out.print("Choose an option (1-7): ");

        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number 1-7: ");
            sc.next();
        }

        int choice = sc.nextInt();

        while (choice < 1 || choice > 7) {
            System.out.print("Choice must be 1-7. Try again: ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number 1-7: ");
                sc.next();
            }
            choice = sc.nextInt();
        }

        return choice;
    }

    /**
     * Receives a value in meters, converts it to feet and inches and prints the result.
     * @param meters value in meters
     */
    public static void metersToFeetAndInches(double meters) {
        if (meters < 0) {
            System.out.println("Meters cannot be negative.");
            return;
        }

        double totalInches = meters * 39.37007874;
        int feet = (int) (totalInches / 12);
        double inches = totalInches - (feet * 12);

        System.out.printf("%.4f meters = %d feet and %.2f inches%n", meters, feet, inches);
    }

    /**
     * Receives feet and inches and returns the corresponding value in meters.
     * @param feet value in feet (non-negative)
     * @param inches value in inches (non-negative)
     * @return the equivalent length in meters
     */
    public static double feetAndInchesToMeters(int feet, double inches) {
        if (feet < 0 || inches < 0) {
            return -1;
        }
        double totalInches = feet * 12.0 + inches;
        return totalInches * 0.0254;
    }

    /**
     * Receives a value in grams, converts it to pounds and ounces and prints the result.
     * @param grams value in grams
     */
    public static void gramsToPoundsAndOunces(double grams) {
        if (grams < 0) {
            System.out.println("Grams cannot be negative.");
            return;
        }

        double totalOunces = grams / 28.349523125;
        int pounds = (int) (totalOunces / 16);
        double ounces = totalOunces - (pounds * 16);

        System.out.printf("%.2f grams = %d pounds and %.2f ounces%n", grams, pounds, ounces);
    }

    /**
     * Receives pounds and ounces and returns the corresponding value in grams.
     * @param pounds value in pounds (non-negative)
     * @param ounces value in ounces (non-negative)
     * @return the equivalent weight in grams
     */
    public static double poundsAndOuncesToGrams(int pounds, double ounces) {
        if (pounds < 0 || ounces < 0) {
            return -1;
        }

        double totalOunces = pounds * 16.0 + ounces;
        return totalOunces * 28.349523125;
    }

    /**
     * Receives a value in seconds and prints the breakdown into hours, minutes and seconds.
     * @param totalSeconds total number of seconds
     */
    public static void time(int totalSeconds) {
        if (totalSeconds < 0) {
            System.out.println("Seconds cannot be negative.");
            return;
        }

        int hours = totalSeconds / 3600;
        int remaining = totalSeconds % 3600;
        int minutes = remaining / 60;
        int seconds = remaining % 60;

        System.out.printf("%d seconds = %d hour(s), %d minute(s), %d second(s)%n",
                totalSeconds, hours, minutes, seconds);
    }

    /**
     * Receives counts of quarters, dimes, nickels and pennies and prints full dollars and remaining cents.
     * @param quarters number of quarters
     * @param dimes number of dimes
     * @param nickels number of nickels
     * @param pennies number of pennies
     */
    public static void change(int quarters, int dimes, int nickels, int pennies) {
        if (quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0) {
            System.out.println("Coin counts cannot be negative.");
            return;
        }

        int totalCents = quarters * 25 + dimes * 10 + nickels * 5 + pennies;
        int dollars = totalCents / 100;
        int cents = totalCents % 100;

        System.out.printf("Total cents = %d = %d dollar(s) and %d cent(s) leftover%n",
                totalCents, dollars, cents);
    }

    /**
     * Reads a non-negative integer from the user.
     * @param sc the Scanner used to read input
     * @return a non-negative integer
     */
    public static int readNonNegativeInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid integer. Try again: ");
            sc.next();
        }
        int value = sc.nextInt();
        while (value < 0) {
            System.out.print("Must be non-negative. Try again: ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid integer. Try again: ");
                sc.next();
            }
            value = sc.nextInt();
        }
        return value;
    }

    /**
     * Reads a non-negative double from the user.
     *
     * @param sc the Scanner used to read input
     * @return a non-negative double
     */
    public static double readNonNegativeDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid number. Try again: ");
            sc.next();
        }
        double value = sc.nextDouble();
        while (value < 0) {
            System.out.print("Must be non-negative. Try again: ");
            while (!sc.hasNextDouble()) {
                System.out.print("Invalid number. Try again: ");
                sc.next();
            }
            value = sc.nextDouble();
        }
        return value;
    }

    /**
     * Main method: calls menu, runs the chosen conversion and repeats until user quits.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = menu(sc);

        while (choice != 7) {

            switch (choice) {
                case 1:
                    System.out.print("Enter meters: ");
                    double meters = readNonNegativeDouble(sc);
                    metersToFeetAndInches(meters);
                    break;

                case 2:
                    System.out.print("Enter feet: ");
                    int feet = readNonNegativeInt(sc);

                    System.out.print("Enter inches: ");
                    double inches = readNonNegativeDouble(sc);

                    double metersResult = feetAndInchesToMeters(feet, inches);
                    if (metersResult < 0) {
                        System.out.println("Invalid input for feet/inches.");
                    } else {
                        System.out.printf("%d feet and %.2f inches = %.4f meters%n",
                                feet, inches, metersResult);
                    }
                    break;

                case 3:
                    System.out.print("Enter grams: ");
                    double grams = readNonNegativeDouble(sc);
                    gramsToPoundsAndOunces(grams);
                    break;

                case 4:
                    System.out.print("Enter pounds: ");
                    int pounds = readNonNegativeInt(sc);

                    System.out.print("Enter ounces: ");
                    double ounces = readNonNegativeDouble(sc);

                    double gramsResult = poundsAndOuncesToGrams(pounds, ounces);
                    if (gramsResult < 0) {
                        System.out.println("Invalid input for pounds/ounces.");
                    } else {
                        System.out.printf("%d pounds and %.2f ounces = %.2f grams%n",
                                pounds, ounces, gramsResult);
                    }
                    break;

                case 5:
                    System.out.print("Enter total seconds (integer): ");
                    int seconds = readNonNegativeInt(sc);
                    time(seconds);
                    break;

                case 6:
                    System.out.print("Enter quarters: ");
                    int q = readNonNegativeInt(sc);

                    System.out.print("Enter dimes: ");
                    int d = readNonNegativeInt(sc);

                    System.out.print("Enter nickels: ");
                    int n = readNonNegativeInt(sc);

                    System.out.print("Enter pennies: ");
                    int p = readNonNegativeInt(sc);

                    change(q, d, n, p);
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

            choice = menu(sc);
        }

        System.out.println("Goodbye!");
        sc.close();
    }
}