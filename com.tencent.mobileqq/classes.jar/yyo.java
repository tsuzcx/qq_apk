import java.io.File;
import java.io.FileFilter;

final class yyo
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyo
 * JD-Core Version:    0.7.0.1
 */