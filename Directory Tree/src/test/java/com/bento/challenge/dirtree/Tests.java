package com.bento.challenge.dirtree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import com.bento.challenge.dirtree.Solution.TreeComparator;

/**
 * The Class Tests.
 * @author Akshay
 * @version 1.0
 */
public class Tests {

    /**
     * DirTree tests.
     */
    @Test
    public void dirTreeTests() {
        TreeSet<File> tset = new TreeSet<>(new TreeComparator());
        Solution.buildDirTree(System.getProperty("user.dir"), tset);
        assertTrue(tset.size() > 0);
        File first = tset.first();
        File openedFile = new File(first.getPath());
        assertEquals(openedFile.length(), first.length());
        File last = tset.last();
        if(!first.equals(last))
            assertTrue(first.length() <= last.length());    // sorted in ascending order
        assertTrue(tset.contains(first));   // constant time op
    }
}
