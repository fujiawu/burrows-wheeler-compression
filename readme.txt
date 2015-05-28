/**********************************************************************
 *  readme.txt template                                                   
 *  Burrows-Wheeler data compression.
**********************************************************************/

Name:  Fujia Wu
Login:   fujiawu
Precept:   P04A

Partner name:     
Partner login:    
Partner precept:  



/**********************************************************************
 *  List in table format which input files you used to test your program.
 *  Fill in columns for how long your program takes to compress and
 *  decompress these instances (by applying BurrowsWheeler, MoveToFront,
 *  and Huffman in succession). Also, fill in the third column for
 *   the compression ratio.
 **********************************************************************/

File         Encoding Time    Decoding time      Compression ratio
------------------------------------------------------------------------
abra.txt       0.14s           0.125s              1.58
aesop.txt      1.258s          0.324s              0.34
CS_bricks.jpg  0.414s          0.250s              1.00
aesop.txt.huf  0.894s          0.290s              0.79 
bible.txt      7.939s          1.617s              0.26
mobydick.txt   2.196s          0.581s              0.35

/**********************************************************************
 *  Compare the results of your program (compression ratio and running
 *  time) on mobydick.txt to that of the most popular Windows
 *  compression program (pkzip) or the most popular Unix/Mac one (gzip).
 *  If you don't have pkzip, use 7zip and compress using zip format.
 **********************************************************************/
my program:
Encoding Time      Compression ratio
2.196s                     0.35
0.106s                     0.41


/**********************************************************************
 *  Give the order of growth of the running time of each of the 6
 *  methods as a function of the input size N and the alphabet size R
 *  both in practice (on typical English text inputs) and in theory
 *  (in the worst case), e.g., N, N log N, N^2, R N.
 **********************************************************************/

                             typical            worst
-----------------------------------------------------------
BurrowsWheeler encode()       N + sorting      N + sorting
BurrowsWheeler decode()       N + R            N + R
MoveToFront encode()          N                  NR
MoveToFront decode()          N                  NR
Huffman compress()            N + R log R        N + R log R
Huffman expand()              N                  N


/**********************************************************************
 *  Known bugs / limitations.
 **********************************************************************/
slow compared to gzip on Unix

/**********************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **********************************************************************/


/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/


/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
