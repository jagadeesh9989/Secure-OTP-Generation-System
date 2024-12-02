package otp;

import java.util.Scanner;

public class OTPApplication {
    public static void main(String[] args) {
        OTPService otpService = new OTPService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the OTP System!");

        // Step 1: Generate OTP
        String otp = otpService.generateOTP();

        // Step 2: Simulate sending OTP
        System.out.print("Enter recipient (email/phone): ");
        String recipient = scanner.next();
        otpService.sendOTP(otp, recipient);

        // Step 3: Wait for user input
        System.out.println("\nPlease enter the 6-digit OTP you received:");
        String userInput = scanner.next();

        // Step 4: Validate OTP
        boolean isValid = otpService.validateOTP(userInput);

        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }
}
