import java.util.HashMap;
import java.util.Map;

public class Question2 {
    public static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        
        // If the lengths are different, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Create a frequency map for the first string
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        // Decrease the frequency map based on the second string
        for (char c : str2.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) < 0) {
                return false;
            }
        }
        
        // Check if all counts are zero
        for (int count : charCountMap.values()) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        
        System.out.println(areAnagrams(str1, str2));
    }
}
