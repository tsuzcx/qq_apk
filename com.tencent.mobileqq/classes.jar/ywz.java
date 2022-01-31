import java.io.File;
import java.util.Comparator;

public final class ywz
  implements Comparator
{
  public int a(File paramFile1, File paramFile2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywz
 * JD-Core Version:    0.7.0.1
 */