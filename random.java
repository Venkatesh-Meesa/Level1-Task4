import java.security.SecureRandom;
import java.util.Scanner;

public class random {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.println("Random Password Generator");

        // Get the desired length of the password from the user
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        // Prompt the user to specify whether to include numbers
        System.out.print("Include numbers? (yes or no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        // Prompt the user to specify whether to include lowercase letters
        System.out.print("Include lowercase letters? (yes or no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        // Prompt the user to specify whether to include uppercase letters
        System.out.print("Include uppercase letters? (yes or no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        // Prompt the user to specify whether to include special characters
        System.out.print("Include special characters? (yes or no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        // Build the character set based on user preferences
        StringBuilder characterSet = new StringBuilder();
        if (includeNumbers) {
            characterSet.append(NUMBERS);
        }
        if (includeLowercase) {
            characterSet.append(LOWERCASE);
        }
        if (includeUppercase) {
            characterSet.append(UPPERCASE);
        }
        if (includeSpecial) {
            characterSet.append(SPECIAL_CHARACTERS);
        }

        // Check if at least one character set is selected
        if (characterSet.length() == 0) {
            System.out.println("You must select at least one character set.");
            return;
        }

        // Generate the random password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }

        // Display the generated password
        System.out.println("Generated password: " + password.toString());

        scanner.close();
    }
}
