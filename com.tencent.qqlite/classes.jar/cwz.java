import java.io.File;
import java.util.Comparator;

class cwz
  implements Comparator
{
  cwz(cwy paramcwy) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() - paramFile1.lastModified() > 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cwz
 * JD-Core Version:    0.7.0.1
 */