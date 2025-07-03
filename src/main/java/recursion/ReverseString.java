package recursion;

public class ReverseString {
    static String reverse(String str){
        if(str.isEmpty()){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }
    public static void main(String[] args) {
        String str = "Deepanshu";
        String rev = reverse(str);
        System.out.println("Original" +" -> " +str);
        System.out.println("Reversed" + " -> "+rev);

    }
}
