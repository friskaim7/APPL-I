// ****************************************************************
// MathUtils.java
// Provides static mathematical utility functions.
// ****************************************************************
public class MathUtils {
    // -------------------------------------------------------------
    // Returns the factorial of the argument given
    // or throw an IllegalArgumentException.
    // -------------------------------------------------------------
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(n + " is a negative value.");
        } else if (n > 16) {
            throw new IllegalArgumentException(n + " is more than 16.");
        } else {
            int fac = 1;
            for (int i = n; i > 0; i--)
                fac *= i;
            return fac;
        }
    }
}