package com.bento.challenge.anagrams;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * The Class Tests.
 * @author Akshay
 * @version 1.0
 */
public class Tests {
    
    /**
     * Anagram tests.
     */
    @Test
    public void anagramTests() {
        String testString = "hi hello hey";
        Map<Character, Integer> map = Solution.buildLetterMap(testString);
        assertEquals(3, (int) map.get('h')); 
        assertEquals(2, (int) map.get('l'));
        assertEquals(1, (int) map.get('o'));
        
        assertTrue(Solution.isAnagram("cat", "act"));
        assertTrue(Solution.isAnagram("Discounted", "Deductions"));
        assertFalse(Solution.isAnagram("act", "cats"));
        assertFalse(Solution.isAnagram("Akshay", "Sadarangani"));
    }
}
