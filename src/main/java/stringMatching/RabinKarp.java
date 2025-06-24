package stringMatching;

import java.util.*;

public class RabinKarp {
    static int d = 256; // Number of characters in the input alphabet
    static int q = 101; // A prime number for modulus

    public static void main(String[] args) {
        String txt = "ABCCDDAEFG";
        String pat = "CDD";
        search(pat, txt);
    }

    static void search(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        // The value of h would be "pow(d, m-1)%q"
        for (i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++) {

            // Check the hash values of current window of text and pattern
            if (p == t) {
                // Check for characters one by one
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                // We might get negative values of t, converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }
}
