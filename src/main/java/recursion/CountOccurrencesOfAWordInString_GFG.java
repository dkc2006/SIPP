package recursion;

public class CountOccurrencesOfAWordInString_GFG {
    static int sol(String str, String word) {
        int count = 0;
        String[] s = str.split(" ");

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "Hey! I am a good boy and My name is is Deepanshu";
        String word = "is";

        System.out.println(sol(str, word));
    }
}
