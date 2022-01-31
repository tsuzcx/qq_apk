import java.io.File;
import java.io.FileFilter;

public final class iey
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iey
 * JD-Core Version:    0.7.0.1
 */