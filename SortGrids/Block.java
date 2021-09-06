package SortGrids;

//This method stores an int width, int height and String content
public class Block{
 private int width;
 private int height;
 private String content;
 
 public Block(int width, int height, String content) {
  this.width = width;
  this.height = height;
  this.content = content;
 }
 
 public int getWidth() {
  return width;
 }
  public int getHeight() {
  return height;
 }
   public String getContent() {
  return content;
 }
}

