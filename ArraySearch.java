import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] array = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // Input the element to search
        System.out.print("Enter number to search: ");
        int target = sc.nextInt();

        // Search for the number
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (array[i] == target) {
                System.out.println("Number found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Number not found in the array.");
        }

        sc.close();
    }
}
