import java.io.File;
import java.util.Comparator;

public class hps
  implements Comparator
{
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareTo(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hps
 * JD-Core Version:    0.7.0.1
 */