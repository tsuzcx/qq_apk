import java.io.File;
import java.io.FileFilter;

public final class iad
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iad
 * JD-Core Version:    0.7.0.1
 */