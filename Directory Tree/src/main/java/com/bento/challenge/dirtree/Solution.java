package com.bento.challenge.dirtree;

import java.io.File;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Solution for the directory tree challenge
 * @author Akshay
 * @version 1.0
 */
public class Solution {

    /**
     * The inner Class TreeComparator.
     */
    static class TreeComparator implements Comparator<File> {
        public int compare(File o1, File o2) {
            return (int) (o1.length() - o2.length());   // Ascending order
        }
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {   
        TreeSet<File> tset = new TreeSet<>(new TreeComparator()); 
        if(args.length < 1) {
            System.err.println("Please enter a valid path!");
            System.exit(-1);
        }

        buildDirTree(args[0], tset);
        for(File me : tset) 
            System.out.println(me.length() + "\t" + me.getParent() + "\t" + me.getName()); 
        System.exit(0);
    }

   
    /**
     * Builds the directory tree.
     *
     * @param pathName the path name
     * @param tset the tset
     * @return the sorted set
     */
    public static SortedSet<File> buildDirTree(String pathName, SortedSet<File> tset) {
        try {
            // create new file
            File file = new File(pathName);
            // store all the path names of files and dirs in the given path
            File[] paths = file.listFiles();
            if(paths == null || paths.length == 0)  // empty folder
                return tset;
            // traverse the paths in the current path
            for(File path:paths) {
                tset.add(path); // build the tree set
                buildDirTree(path.toString(), tset);    // recursively 
            }
        } catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
        return tset;
    }
}
