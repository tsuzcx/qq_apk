import java.io.File;
import java.util.Comparator;

class aevu
  implements Comparator<File>
{
  aevu(aevt paramaevt) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() > paramFile1.lastModified()) {
      return 1;
    }
    if (paramFile2.lastModified() < paramFile1.lastModified()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevu
 * JD-Core Version:    0.7.0.1
 */