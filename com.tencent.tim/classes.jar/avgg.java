import java.io.File;
import java.io.FileFilter;

final class avgg
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgg
 * JD-Core Version:    0.7.0.1
 */