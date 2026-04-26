package exercise_2;

public class Ulam {
    public static void main(String[] args) {
        int limit = 1000000;
        System.out.println("Starting verification for n < " + limit + "...");
        
        for (int i = 1; i < limit; i++) {
            if (!verifies(i)) {
                System.out.println("Failed for n = " + i);
                return;
            }
        }
        System.out.println("Verification complete. All positive integers n < 1,000,000 terminate with 1.");
    }

    private static boolean verifies(int n) {
        long current = n; // long to prevent overflow during 3n + 1
        while (current != 1) {
            if (current % 2 == 0) {
                current /= 2;
            } else {
                current = 3 * current + 1;
            }
            // safety break if it somehow goes below 1 or reaches a cycle (not expected for n < 1M)
            if (current <= 0) return false;
        }
        return true;
    }
}
