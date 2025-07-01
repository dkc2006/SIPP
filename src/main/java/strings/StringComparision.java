package strings;

public class StringComparision {
    public static void main(String[] args) {

        String s1 = "JAVA";
        String s2 = "JAVA";
        String str = new String("JAVA");
        String str2 = new String("JAVA");

        System.out.println(str2 == str); // false
        System.out.println(str2.equals(str)); // true

        System.out.println(s1==s2); // true
        System.out.println(s1.equals(s2)); // true;

        System.out.println(s1 == str); //false
        System.out.println(s1.equals(str)); //true
    }
}
