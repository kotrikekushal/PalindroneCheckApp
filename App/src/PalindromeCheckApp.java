import java.util.*;

public class PalindromeCheckApp {

    public static boolean stackPalindrome(String word) {
        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        for (char c : word.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static boolean dequePalindrome(String word) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    public static boolean recursivePalindrome(String word, int start, int end) {
        if (start >= end) return true;

        if (word.charAt(start) != word.charAt(end)) return false;

        return recursivePalindrome(word, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();

        long start1 = System.nanoTime();
        boolean result1 = stackPalindrome(word);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = dequePalindrome(word);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean result3 = recursivePalindrome(word, 0, word.length() - 1);
        long end3 = System.nanoTime();

        System.out.println("\nStack Method Result: " + result1);
        System.out.println("Execution Time: " + (end1 - start1) + " ns");

        System.out.println("\nDeque Method Result: " + result2);
        System.out.println("Execution Time: " + (end2 - start2) + " ns");

        System.out.println("\nRecursive Method Result: " + result3);
        System.out.println("Execution Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}
