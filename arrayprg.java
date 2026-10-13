// Importing the Arrays class
import java.util.Arrays;

// Public Main Class
public class arrayprg {
  public static void main(String[] args) {
    // Declaring an array
    int arr[] = {8, 5, 3, 10, 2, 1, 15, 20};

    // Sorting the array
    Arrays.sort(arr);

    // Taking an element to search
    int ele = 15;

    // Using binarySearch() method to search "ele"
    System.out.println(
      ele + " presents at the index = " +
      Arrays.binarySearch(arr, ele));
  }
}