import java.io.File;
import java.io.FilenameFilter;

public final class zgx
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".mp4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgx
 * JD-Core Version:    0.7.0.1
 */