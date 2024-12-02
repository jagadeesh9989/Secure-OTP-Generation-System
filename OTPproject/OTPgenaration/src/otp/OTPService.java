package otp;

import java.util.Random;

public class OTPService {
    private String currentOTP;
    private long otpGeneratedTime;
    private static final int OTP_VALIDITY_PERIOD = 300; // 5 minutes in seconds
    private static final int OTP_LENGTH = 6; // Fixed OTP length

    // Method to generate OTP
    public String generateOTP() {
        String digits = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(digits.charAt(random.nextInt(digits.length())));
        }

        currentOTP = otp.toString();
        otpGeneratedTime = System.currentTimeMillis(); // Save the time when OTP was generated
        return currentOTP;
    }

    // Method to validate OTP
    public boolean validateOTP(String userInput) {
        if (currentOTP == null) {
            System.out.println("No OTP generated!");
            return false;
        }

        long currentTime = System.currentTimeMillis();
        long timeElapsed = (currentTime - otpGeneratedTime) / 1000; // Convert to seconds

        if (timeElapsed > OTP_VALIDITY_PERIOD) {
            System.out.println("OTP has expired!");
            currentOTP = null; // Invalidate the OTP
            return false;
        }

        if (userInput.equals(currentOTP)) {
            System.out.println("OTP verified successfully!");
            currentOTP = null; // Invalidate after successful verification
            return true;
        } else {
            System.out.println("Invalid OTP!");
            return false;
        }
    }

    // Method to simulate sending OTP
    public void sendOTP(String otp, String recipient) {
        System.out.println("OTP " + otp + " has been sent to " + recipient);
    }
}
