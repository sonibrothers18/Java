import java.util.Scanner;   //--> input class

@SuppressWarnings("unused")
public class J_005_user_input {
    public static void main(String[] args) {
        System.out.println("Taking input from the user");

        Scanner sc = new Scanner(System.in);
        System.out.println( "Enter number 1");
        int num1 = sc.nextInt();
        System.out.println("Enter number 2"); 
        float num2 = sc.nextFloat();

        float sum = num1+num2;
        System.out.println("Sum is : "+sum);
    }
}