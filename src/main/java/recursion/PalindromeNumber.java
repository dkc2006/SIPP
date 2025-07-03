package recursion;

public class PalindromeNumber {
    static int revNum(int num,int rev){
        if(num == 0){
            return rev;
        }
        return revNum(num/10,rev*10+num%10);
    }
    static boolean isP(int num){
        return num == revNum(num,0);
    }
    public static void main(String[] args) {
        int num = 151;

        if(isP(num)){
            System.out.println(num + " is a Palindrome Number");
        }
        else{
            System.out.println(num + " is not a Palindrome Number");
        }
    }
}
