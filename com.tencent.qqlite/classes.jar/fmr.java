import java.io.File;
import java.io.FileFilter;

public final class fmr
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fmr
 * JD-Core Version:    0.7.0.1
 */