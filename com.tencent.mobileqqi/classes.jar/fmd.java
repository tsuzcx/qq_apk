import java.io.File;
import java.util.Comparator;

class fmd
  implements Comparator
{
  fmd(fmc paramfmc) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() - paramFile1.lastModified() > 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fmd
 * JD-Core Version:    0.7.0.1
 */