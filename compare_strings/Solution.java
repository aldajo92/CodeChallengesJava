package compare_strings;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String A = "abcd,aabc,bd";
        String B = "aaa,aa";
        int[] ints = compareStrings(A, B);
        System.out.println(Arrays.toString(ints));
    }

    static int[] compareStrings(String s1, String s2) {
        String[] A = s1.split(",");
        String[] B = s2.split(",");

        HashMap<String, HashMap<Character, Integer>> mapA = new HashMap<>();
        char[] minimumCharsA = new char[A.length];

        HashMap<String, HashMap<Character, Integer>> mapB = new HashMap<>();
        char[] minimumCharsB = new char[B.length];

        for (int i = 0; i < A.length; i++) {
            String word = A[i];
            char minimumChar = word.charAt(0);
            HashMap<Character, Integer> mapFrequency = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                if (currentChar < minimumChar) {
                    minimumChar = currentChar;
                }
                if (mapFrequency.containsKey(currentChar)) {
                    int value = mapFrequency.get(currentChar) + 1;
                    mapFrequency.put(currentChar, value);
                } else {
                    mapFrequency.put(currentChar, 1);
                }
            }
            minimumCharsA[i] = minimumChar;
            mapA.put(word, mapFrequency);
        }

        for (int i = 0; i < B.length; i++) {
            String word = B[i];
            char minimumChar = word.charAt(0);
            HashMap<Character, Integer> mapFrequency = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                if (currentChar < minimumChar) {
                    minimumChar = currentChar;
                }
                if (mapFrequency.containsKey(currentChar)) {
                    int value = mapFrequency.get(currentChar) + 1;
                    mapFrequency.put(currentChar, value);
                } else {
                    mapFrequency.put(currentChar, 1);
                }
            }
            minimumCharsB[i] = minimumChar;
            mapB.put(word, mapFrequency);
        }

        int[] result = new int[B.length];
        for (int i = 0; i < minimumCharsB.length; i++) {
            String wordB = B[i];
            int freqBi = mapB.get(wordB).get(minimumCharsB[i]);
            int counterBMajorA = 0;
            for (int j = 0; j < minimumCharsA.length; j++) {
                String wordA = A[j];
                int freqAj = mapA.get(wordA).get(minimumCharsA[j]);
                if (freqBi > freqAj) {
                    counterBMajorA++;
                }
            }
            result[i] = counterBMajorA;
        }

        return result;
    }
}
