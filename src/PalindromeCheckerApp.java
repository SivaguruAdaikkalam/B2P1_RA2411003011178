import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "AmanaplanacanalPanama".toLowerCase();

        System.out.println("Comparing Palindrome Algorithms Performance\n");

        // 1️⃣ Loop Reversal
        long start1 = System.nanoTime();
        boolean result1 = loopReverse(input);
        long end1 = System.nanoTime();

        // 2️⃣ Two Pointer
        long start2 = System.nanoTime();
        boolean result2 = twoPointer(input);
        long end2 = System.nanoTime();

        // 3️⃣ Stack Approach
        long start3 = System.nanoTime();
        boolean result3 = stackMethod(input);
        long end3 = System.nanoTime();

        System.out.println("Loop Reversal Result: " + result1);
        System.out.println("Time Taken: " + (end1 - start1) + " ns\n");

        System.out.println("Two Pointer Result: " + result2);
        System.out.println("Time Taken: " + (end2 - start2) + " ns\n");

        System.out.println("Stack Method Result: " + result3);
        System.out.println("Time Taken: " + (end3 - start3) + " ns\n");
    }

    // Loop reversal method
    public static boolean loopReverse(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return input.equals(reversed);
    }

    // Two pointer method
    public static boolean twoPointer(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Stack method
    public static boolean stackMethod(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}