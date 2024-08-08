import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int targetSum = 6;
        
        List<int[]> pairs = findPairsWithSum(arr, targetSum);
        
        System.out.print("[ ");
        for (int i = 0; i < pairs.size(); i++) {
            System.out.print(Arrays.toString(pairs.get(i)) + " ");
        }
        System.out.print("]");
    }

    public static List<int[]> findPairsWithSum(int[] arr, int targetSum) {
        // HashMap to store numbers we've seen so far
        Map<Integer, Boolean> seen = new HashMap<>();
        // List to store the result pairs
        List<int[]> result = new ArrayList<>();
        
        // Iterate through the array
        for (int number : arr) {
            // Calculate the complement that would add up to the targetSum
            int complement = targetSum - number;
            
            // If the complement is in the seen map, we've found a pair
            if (seen.containsKey(complement)) {
                result.add(new int[] {complement, number});
            }
            
            // Add the number to the seen map
            seen.put(number, true);
        }
        
        return result;
    }
}
