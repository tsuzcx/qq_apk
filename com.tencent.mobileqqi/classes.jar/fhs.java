import java.io.File;
import java.util.Comparator;

class fhs
  implements Comparator
{
  fhs(fhp paramfhp) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() - paramFile1.lastModified() > 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fhs
 * JD-Core Version:    0.7.0.1
 */