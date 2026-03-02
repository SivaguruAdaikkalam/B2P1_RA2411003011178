import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindromeBasic(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return input.equals(reversed);
    }

    public static boolean isPalindromeIgnoreCase(String input) {
        String lower = input.toLowerCase();
        String reversed = "";
        for (int i = lower.length() - 1; i >= 0; i--) {
            reversed += lower.charAt(i);
        }
        return lower.equals(reversed);
    }

    public static boolean isPalindromeAdvanced(String input) {
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed += cleaned.charAt(i);
        }
        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Checker App =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\nChoose Mode:");
        System.out.println("1. Basic (Case Sensitive)");
        System.out.println("2. Ignore Case");
        System.out.println("3. Ignore Case + Special Characters");
        System.out.print("Enter choice (1-3): ");

        int choice = scanner.nextInt();
        boolean result = false;

        switch (choice) {
            case 1:
                result = isPalindromeBasic(input);
                break;
            case 2:
                result = isPalindromeIgnoreCase(input);
                break;
            case 3:
                result = isPalindromeAdvanced(input);
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        if (result) {
            System.out.println("Result: The given string IS a palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a palindrome.");
        }

        scanner.close();
    }
}