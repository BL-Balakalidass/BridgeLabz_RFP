package Day_5;

import java.util.Scanner;

public class PowerOfTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to Square : ");
        int num=sc.nextInt();
        long square =(long) num*num;
        System.out.println("The Square of number "+num+" is " + square );
    }
}
