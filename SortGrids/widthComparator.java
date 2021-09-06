package SortGrids;

import java.util.Comparator;

//This class compares widths of the blocks
public class widthComparator implements Comparator<Block> {
  
 public int compare(Block first, Block second) {
   int widthFirst = first.getWidth();
   int widthSecond = second.getWidth();
   
   if(widthFirst == widthSecond){
     return 0;
   } else if (widthFirst > widthSecond){
     return +1;
   }else{
     return -1;
   }
 }
}
