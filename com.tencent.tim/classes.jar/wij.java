import java.io.File;
import java.util.Comparator;

class wij
  implements Comparator<File>
{
  wij(wii paramwii) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    long l = wii.a(this.this$0, paramFile1) - wii.a(this.this$0, paramFile2);
    if (l > 0L) {
      return 1;
    }
    if (l == 0L) {
      return 0;
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wij
 * JD-Core Version:    0.7.0.1
 */