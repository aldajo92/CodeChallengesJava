package longest_substring;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ababcdefast"));
    }

    // Brute force
    public static int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int n = s.length();
        if(n == 0 || n == 1){
            return n;
        }
        ArrayList<Character> currentChars = new ArrayList<>();
        ArrayList<Character> maxSubstring = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                char initial = s.charAt(i);
                char pivot = s.charAt(j);
                if(currentChars.size() > 0){
                    if (currentChars.contains(pivot)) {
                        currentChars.clear();
                        break;
                    } else {
                        currentChars.add(pivot);
                    }
                } else {
                    currentChars.add(initial);
                    if(pivot != initial){
                        currentChars.add(pivot);
                    }
                }

                if (currentChars.size() > maxSubstring.size()) {
                    maxSubstring.clear();
                    maxSubstring.addAll(currentChars);
                }
            }
        }
        return maxSubstring.size();
    }
}
