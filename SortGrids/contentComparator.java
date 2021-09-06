package SortGrids;

import java.util.Comparator;

//This class compares the contents of the blocks
public class contentComparator implements Comparator<Block> {

  public int compare(Block first, Block second) {
   String s1 = first.getContent() + "";
   String s2 = second.getContent() + "";
   int result = s1.compareTo(s2);
   
   if(result == 0 ){
     return 0;
   } else if (result < 0){
     return -1;
   }else{
     return +1;
   }
 }
}
