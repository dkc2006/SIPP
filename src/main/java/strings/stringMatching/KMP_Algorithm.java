package strings.stringMatching;

import java.util.*;

public class KMP_Algorithm {
    public static void main(String[] args) {
        String txt = "geeksforgeeks";
        String pat = "geek";

        System.out.println(search(pat, txt));
    }

    static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        int[] lps = generateLPS(pat);
        int i = 0, j = 0;

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                ans.add(i - j); // Found pattern at i-j
                j = lps[j - 1]; // Continue for next possible match
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return ans;
    }

    static int[] generateLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
