package strings.stringMatching;

public class Z_Function {

    // Function to search all occurrences of pattern in text
    public static void search(String text, String pattern) {
        String concat = pattern + "$" + text;  // Combine pattern and text
        int l = concat.length();
        int[] Z = new int[l];

        getZarr(concat, Z);  // Generate Z-array

        for (int i = 0; i < l; ++i) {
            // If Z[i] == pattern length, pattern found at this position
            if (Z[i] == pattern.length()) {
                System.out.println("Pattern found at index " + (i - pattern.length() - 1));
            }
        }
    }

    // Function to calculate Z-array
    private static void getZarr(String str, int[] Z) {
        int n = str.length();
        int L = 0, R = 0;

        for (int i = 1; i < n; ++i) {
            if (i > R) {
                L = R = i;

                // Match characters starting from position i
                while (R < n && str.charAt(R - L) == str.charAt(R)) R++;

                Z[i] = R - L;
                R--;
            } else {
                int k = i - L;

                // Copy value if it lies within the known Z-box
                if (Z[k] < R - i + 1) Z[i] = Z[k];
                else {
                    // Recalculate Z[i] outside the known Z-box
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R)) R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "GEEKS FOR GEEKS";
        String pattern = "GEEK";
        search(text, pattern);
    }
}
