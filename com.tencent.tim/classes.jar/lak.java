import java.io.File;
import java.io.FileFilter;

final class lak
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lak
 * JD-Core Version:    0.7.0.1
 */