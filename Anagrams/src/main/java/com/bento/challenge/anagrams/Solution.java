package com.bento.challenge.anagrams;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution to the Anagrams challenge
 * @author Akshay
 * @version 1.0
 */
public class Solution {


    /** The Constant ANAGRAM_WORDS. */
    private static final String ANAGRAM_WORDS = "vase bat gods latte name apres spit joke ham dog act tale parse pits asper tab table mane late god cat\r\n" + 
            "table save spare";


    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        String[] words = ANAGRAM_WORDS.split(" ");  // Extract words from the given list based on space
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i != j && isAnagram(words[i].toLowerCase(), words[j].toLowerCase())) {
                    System.out.println(words[i] + ", " + words[j]);
                }
            }
        }
        
    }

    /**
     * Check if str1 is an anagram of str2.
     *
     * @param str1 the string 1
     * @param str2 the string 2
     * @return true, if is anagram
     */
    public static boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length())  // Skip the workload if lengths do not match
            return false;
        /** Buld a hash map of letters in str1 with their occurrences **/
        Map<Character, Integer> map = buildLetterMap(str1);
        for(int i = 0; i < str2.length(); i++) {    // Traverse str2 and check against and manipulate the built map
            char c = str2.charAt(i);
            Integer count = map.get(c);
            if(count == null)   // Letter not found in str1
                return false;
            if(--count == 0)
                map.remove(c);
            else
                map.put(c, count);
        }
        return map.isEmpty();
    }

    /**
     * Builds the letter map.
     *
     * @param str the string
     * @return the map
     */
    public static Map<Character, Integer> buildLetterMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int i;
        for(i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer count = map.get(c);
            count = count == null ? 1 : count + 1;
            map.put(c, count);
        }
        return map;
    }

}
