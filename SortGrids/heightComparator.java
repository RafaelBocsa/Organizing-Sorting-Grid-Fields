package SortGrids;

import java.util.Comparator;

//This class compares heights of the blocks
public class heightComparator implements Comparator<Block> {
  
 public int compare(Block first, Block second) {
   int heightFirst = first.getHeight();
   int heightSecond = second.getHeight();
   
   if(heightFirst == heightSecond){
     return 0;
   } else if (heightFirst > heightSecond){
     return +1;
   }else{
     return -1;
   }
 }
}
