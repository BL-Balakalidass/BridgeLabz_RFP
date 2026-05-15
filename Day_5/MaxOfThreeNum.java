package Day_5;

import java.util.Scanner;

public class MaxOfThreeNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a : ");
        int a = sc.nextInt();
        System.out.print("Enter b : ");
        int b = sc.nextInt();
        System.out.print("Enter c : ");
        int c = sc.nextInt();
        int max = findMaxOfThree(a, b, c);
        System.out.println("The maxmimun of three number is : " + max);
    }

    private static int findMaxOfThree(int a, int b, int c) {
        int max = a;
        if (max < b) {
            max = b;
        }
        if (max < c) {
            max = c;
        }
        return max;
    }
}
