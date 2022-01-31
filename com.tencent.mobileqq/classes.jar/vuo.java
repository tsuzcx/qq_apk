import java.io.File;
import java.io.FilenameFilter;

public final class vuo
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".mp4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vuo
 * JD-Core Version:    0.7.0.1
 */