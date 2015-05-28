/*************************************************************************
 *  Compilation:  javac BurrowsWheeler.java
 *  Execution:     java BurrowsWheeler - < input.txt   (encode)
 *  Execution:     java BurrowsWheeler + < input.txt   (decode)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *
 *  Encode or decode a text file using Burrows-Wheeler transform.
 *
 *************************************************************************/

import java.util.Arrays;

    
public class BurrowsWheeler {

    static private final int R = 256;
    
    // apply Burrows-Wheeler encoding, reading from standard input and 
    // writing to standard output
    public static void encode() {
       // read the input
       String s = BinaryStdIn.readString();
       int N = s.length();
       // concatenate the string to itself
       String ss = s.concat(s);
       String[] strs = new String[N];
       for (int i = 0; i < N; i++)
         strs[i] = ss.substring(i, i+N);
       // using system sort
       Arrays.sort(strs);
       int index = Arrays.binarySearch(strs, s);
       BinaryStdOut.write(index);
       for (int i = 0; i < N; i++)
           BinaryStdOut.write(strs[i].charAt(N-1));
       // close output
       BinaryStdOut.close();
    }

    // apply Burrows-Wheeler decoding, reading from standard input 
    // and writing to standard output
    public static void decode() {
       // read first and t[]
       int first = BinaryStdIn.readInt();
       String s = BinaryStdIn.readString();
       int N = s.length();
       // allocate the ending array
       char[] t = new char[N];
       for (int i = 0; i < N; i++)
         t[i] = s.charAt(i);
       // allocate an array to store the next array
       int[] next = new int[N]; 
       // allocate an array to store 1st char of the sorted suffixes
       char[] f = new char[N]; 
       // an array to store the total count for each character
       int[] count = new int[R+1];
       // do key-index counting, but store values in the next[] array
       for (int i = 0; i < N; i++)
         count[t[i]+1]++;
       for (int r = 0; r < R; r++)
         count[r+1] += count[r];
       for (int i = 0; i < N; i++) {
          next[count[t[i]]] = i;
          f[count[t[i]]++] = t[i];
       }
       // write out
        int current = first;
       for (int i = 0; i < N; i++) {
        BinaryStdOut.write(f[current]);
        current = next[current];
       }
       // close output
       BinaryStdOut.close();
    }

    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args) {
        if      (args[0].equals("-")) encode();
        else if (args[0].equals("+")) decode();
        else throw new RuntimeException("Illegal command line argument");
    }

}
