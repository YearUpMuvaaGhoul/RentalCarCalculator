package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculatorr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// Establish KNOWN values, from requirements.


        // Prompt user for questions
        System.out.print("Enter pickup date (MM/DD/YYYY): ");
        String pickupDate = scanner.nextLine();

        System.out.print("Enter number of rental days: ");
        int rentalDays = scanner.nextInt();

// Ask user if they want extras on top od base rental
        System.out.print("Do you want an electronic toll tag? Additional 3.95/Day (yes/no): ");
        boolean hasTollTag = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Do you want a GPS? Additional 2.95/Day (yes/no): ");
        boolean hasGPS = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Do you want roadside assistance? Additional 3.95/day (yes/no): ");
        boolean hasRoadsideAssistance = scanner.next().equalsIgnoreCase("yes");

// Establish age to inquire if they have extra fees for underage
        System.out.print("Enter your current age: ");
        int age = scanner.nextInt();


//Below this line is the calculations after user input

        // Calculate basic car rental price ($29.99 per day)
        double basicRentalCost = 29.99 * rentalDays;

        // Calculate extra options price ($3.95/day for roadside assistance & tag, $2.95/day for GPS)
        double extras = 0;
        if (hasTollTag) extras += 3.95 * rentalDays;
        if (hasGPS) extras += 2.95 * rentalDays;
        if (hasRoadsideAssistance) extras += 3.95 * rentalDays;

        // Calculate underage driver surcharge (30% fee)
        double underageSurcharge = (age < 25) ? (0.3 * basicRentalCost) : 0;

        // Calculate total price
        double totalCost = basicRentalCost + extras + underageSurcharge;

        // Display results
        System.out.println("Rental Summary:");
        System.out.println("Base rental price:                $" + basicRentalCost);
        System.out.println("Extra options cost:               $" + extras);
        System.out.println("Underage driver surcharge:        $" + underageSurcharge);
        System.out.println("-------------------------------------------------------");
        System.out.println("Total cost:                       $" + totalCost);
        System.out.println("We accept all major credit cards, cash, check and ApplePay.");

        scanner.close();
    }
}