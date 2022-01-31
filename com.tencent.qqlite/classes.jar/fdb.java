import java.io.File;
import java.util.Comparator;

public class fdb
  implements Comparator
{
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareTo(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fdb
 * JD-Core Version:    0.7.0.1
 */