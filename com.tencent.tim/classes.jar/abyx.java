import java.io.File;
import java.util.Comparator;

public final class abyx
  implements Comparator<File>
{
  public int compare(File paramFile1, File paramFile2)
  {
    if ((paramFile1.exists()) && (paramFile2.exists()))
    {
      if (paramFile1.lastModified() - paramFile2.lastModified() > 0L) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abyx
 * JD-Core Version:    0.7.0.1
 */