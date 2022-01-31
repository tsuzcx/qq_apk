import java.io.File;
import java.io.FileFilter;

public final class fkl
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fkl
 * JD-Core Version:    0.7.0.1
 */