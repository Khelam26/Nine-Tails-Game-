/*
Reverse the numbers on the array using stack and recursion.
The user should be prompted to enter how many integer numbers want to store in 
an array (at lease 5 numbers). They should also be prompted to enter each number 
that to be stored into an array. Use stack and recursion concepts for reversing 
each number. After reversing, all the reversed numbers should be stored in the 
same array and display them on the output screen. 
*/
package ds_projectone;

import java.util.Scanner;
import java.util.Stack;

/**
 * Date Modified: 03/27
 * @author khelan
 */
public class DS_ProjectOne {

    // Stack Integer used to load numbers into it
    static Stack<Integer> stck = new Stack<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int size = 5; // the default size of the array
        Scanner input = new Scanner(System.in);

        System.out.println("How many numbers do you want to enter (Default is 5): ");
        if (input.nextInt() > 5) { // The minimum size of the array is 5. 
            size = input.nextInt();
        }

        int[] arr = new int[size];
        
        // Loop to enter the values for each element of the array
        for (int i = 0; i < size; i++) {
            System.out.println("Enter number for index " + (i + 1) + " : ");
            arr[i] = (input.nextInt());
        }

        // the reversed array is assigned to the original array
        arr = stackArr(arr);
        
        // Printing the reversed array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * The original number is taken in as a parameter and the reversed number is returned
     * The Number is broken into individual digits and then each digit is added to the stack
     * @param num
     * @return integer: Reversed Number 
     */
    public static int reverseNumber(int num) {
        while (num != 0) {
            stck.push(num % 10);
            num /= 10;
        }
        return recMethod(stck, 0, 1);
    }

    /**
     * Recursive method
     * Each number from the stack is taken 
     * Further, the digits are multiplied by multiples of 10 accordingly and then added together
     * @param stck
     * @param num
     * @param basePow
     * @return 
     */
    public static int recMethod(Stack<Integer> stck, int num, int basePow) {
        if (!stck.isEmpty()) {
            num = (stck.peek() * basePow);
            stck.pop();
            num += recMethod(stck, num, basePow *= 10);
            return num;
        }
        return 0;
    }

    /**
     * each element is assigned with its reverse
     * @param arr
     * @return array, the reversed array is returned 
     */
    public static int[] stackArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reverseNumber(arr[i]);
        }
        return arr;
    }
}
