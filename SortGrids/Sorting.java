package SortGrids;

import BasicIO.*;
import java.lang.Math.*;
import java.util.Comparator;

/* This class will sort blocks depending on what the user wants to sort by (width, height or content). The user first selects the .txt file 
 * of blocks (gridfeilds01.txt, gridfeilds02.txt ... etc. which ever one you want. The program will then start to read the blocks, sort them the print them to an 
 * output file called gridfeildsResult(01, 02 ... or 10) .txt.
 * 
 * INSTRUCTIONS: On line 58 there will be something written such as "selectionSort(blockArray , numOfBlocks,new widthComparator());",
 *               to sort by the subsort you wish, you must write instead: new widthComparator() to sort by width
 *                                                                     OR new heightComparator() to sort by height
 *                                                                     OR new contentComparator() to sort by content
 */
public class Sorting{
  
  public ASCIIDataFile input;//.txt file inputted by user
  public ASCIIOutputFile output;//output file thats prints sorted blocks
  public String[] stringArray;//array of block strings
  public Block[] blockArray;//array of blocks
  
  int numOfBlocks;
  int width;
  int height;
  String content;
  
  /* This constructor will read and print the number of blocks in the .txt file, read the width and height of each block 
   * ,loops through how many blocks there are in the file and reads each block, then sorts the file depending on
   * what the use wishes to sort by and finally prints the sorted file.
   */
  public Sorting(){
    
    input = new ASCIIDataFile();
    output = new ASCIIOutputFile();
    
    numOfBlocks = input.readInt();//reads number of blocks in .txt file
    output.writeString(numOfBlocks + " Blocks");
    output.newLine();
    blockArray = new Block[numOfBlocks];//makes an array of blocks depending on how many blocks there are
    output.newLine();
    
    for (int i = 0; i < numOfBlocks; i++){//reads blocks depending on how many blocks there are
      input.nextLine();
      
      width = input.readInt();//reads width
      height = input.readInt();//reads height
      
      stringArray = new String[height];//array of size of however high the block is
      storeBlocks();
      blockArray[i] =new Block(width, height, content);
    }
    selectionSort(blockArray , numOfBlocks,new contentComparator());
    selectionSort(blockArray , numOfBlocks,new heightComparator());
    selectionSort(blockArray , numOfBlocks,new widthComparator());
    printBlocks();
  }
  
  /* This method reads each line of a block and then
   * passes that string to content which tells you
   * what is the content of that block
   */
  public void storeBlocks(){
    for (int i = 0; i < height; i++){
      stringArray[i] = input.readLine();
      content = stringArray[i];
    }
  }
  
  /* This method prints the block specification(width & height) 
   * and prints the blocks after being sorted
   */
  public void printBlocks(){
    for (int i = 0; i < numOfBlocks; i++){
      output.writeString ("Width: " + blockArray[i].getWidth());
      output.writeString ("Height: " + blockArray[i].getHeight());
      output.newLine();
      for (int j = 0; j < blockArray[i].getHeight() ; j++){//prints contents depending on how high the sorted blocks are
        output.writeString(blockArray[i].getContent());//prints contents of a block
        output.newLine();
      }
      output.newLine();
    }
  }
  
  /* This method sorts the block using a selection sort algorithm.
   * It looks at the beginning and the next position of the array of Blocks.
   * It first sets the smallest position to the first block.
   * If block j (which j is i + 1 meaning the next block) is less than the smallest position,
   * set the smallest position to j
   */
  private void selectionSort (Block data[], int numOfBlocks, Comparator<Block> cmp){
    int smallPos; // position of smallest item
    Block temp;//temporary Block
    int i, j;
    for (i = 0; i < numOfBlocks - 1 ; i++){
      smallPos = i;
      for (j = i + 1; j < numOfBlocks; j++){
        if (cmp.compare(data[j], data[smallPos]) < 0){//condition checks if current is less than the smallest position
          smallPos = j;
        }
      }
      //swaps using temproray variable
      temp = data[smallPos];
      for(j = smallPos; j > i; j--){
        data[j] = data[j - 1];
      }
      data[i] = temp;
    }
  }
  public static void main ( String[] args ) { Sorting s = new Sorting();}
}