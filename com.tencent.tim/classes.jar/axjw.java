import java.io.File;
import java.io.FileFilter;

public final class axjw
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjw
 * JD-Core Version:    0.7.0.1
 */