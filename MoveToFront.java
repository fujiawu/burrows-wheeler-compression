/*************************************************************************
 *  Compilation:  javac MoveToFront.java
 *  Execution:     java MoveToFront - < input.txt   (encode)
 *  Execution:     java MoveToFront + < input.txt   (decode)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *
 *  Move-to-front encode or decode a text file.
 *
 *************************************************************************/

    
public class MoveToFront {

    static private final int R = 256;
    
    // Move-to-front encoding
    public static void encode() {
      // initialize ordered char array
      char[] a = new char[R];
      for (char i = 0; i < R; i++)
         a[i] = i;
      // read the input
      String s = BinaryStdIn.readString();
      char[] input = s.toCharArray();
      char index = 0;
      for (int i = 0; i < input.length; i++) {
        index = 0;
        // look for index where input[i] appears
        while (a[index] != input[i])
          index++;
        BinaryStdOut.write(index);
        // move to front
        while (index > 0) {
          a[index] = a[index-1];
          index--;
        }
        a[0] = input[i];
      }
       // close output
       BinaryStdOut.close();
    }

     // Move-to-front decoding
    public static void decode() {
      
      // initialize ordered char array
      char[] a = new char[R];
      for (char i = 0; i < R; i++)
         a[i] = i;
      // read the input
      String s = BinaryStdIn.readString();
      char[] input = s.toCharArray();
       char index = 0;
       for (int i = 0; i < input.length; i++) {
        index = input[i];
        BinaryStdOut.write(a[index]);
        // move to front
        char a0 = a[index];
        while (index > 0) {
          a[index] = a[index-1];
          index--;
        }
        a[0] = a0;
      }
       // close output
       BinaryStdOut.close();
    }

    // if args[0] is '-', apply Move-to-front encoding
    // if args[0] is '+', apply Move-to-front decoding
    public static void main(String[] args) {
        if      (args[0].equals("-")) encode();
        else if (args[0].equals("+")) decode();
        else throw new RuntimeException("Illegal command line argument");
    }

}
