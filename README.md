# Bento
Coding challenge for Bento

## Overview
The two problems are divided into two folders but are essentially the same maven project (with the only difference being the main class declaration in the pom.xml). I used Maven for this project for easy heirarchy and dependency tree and the fact that JUnit tests can be either automated or run individually per requirement.

If all that is required are the two source java files, feel free to just download them. For a full project, read on for the instructions.

## Instructions
* Clone the repository locally
* Navigate to each folder in the terminal and use "mvn install" from the directory where pom.xml resides for each problem.
* Tests will be automatically carried out when the project is building
* To test locally, use `mvn test` 
* Navigate to the target folder (`cd target`)
* Now you can simply run the built jar file using `java -jar Bento-0.0.1-SNAPSHOT.jar` 
* For the Directory Tree problem, provide the command line argument after the file name e.g. `java -jar Bento-0.0.1-SNAPSHOT.jar "C:\Users\Akshay\Desktop"`
## Choices Made
### Anagrams Problem
The anagrams problem is solved using the HashMap approach where characters and their respective occurence counts of the first string are stored as a key-value pair for constant lookup by the second string traversal. 
**Running time** for this problem is **O(n)** where _n_ is the length of the string. Since we only check for anagrams if both strings are of the same length, _n_ is the length of both strings. HashMap operations take constant time **O(1)** while traversing the strings takes **O(n)**.

### Directory Tree Problem
The directory tree problem is solved using a SortedSet or TreeSet approach. File sizes are compared while being inserted into the red-black tree (as and when they are explored/discovered) and are therefore inserted in sorted order. A custom comparator is declared as an inner class in the Solution class to aid this. This operation takes **O(log n)** time for each insertion and there are _n_ insertions where _n_ is the number of files discovered. So the overall **Running Time** for this problem is **O(n log n)**.

**NOTE:** this approach assumes that we don't care about duplicate files and so a TreeSet is used. The regular approach could be using an ArrayList to hold all files (including duplicates which may or may not have different file sizes though) and sort the ArrayList with the help of a similar custom comparator and sort it in **O(n log n)** using merge sort or similar. In Java we could use Collections.sort(list).
