import java.io.File;
import java.io.FilenameFilter;

public final class xjd
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".mp4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjd
 * JD-Core Version:    0.7.0.1
 */