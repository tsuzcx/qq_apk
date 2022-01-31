import java.io.File;
import java.io.FilenameFilter;

public final class ywx
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.toLowerCase().endsWith(".amr")) || (paramString.toLowerCase().endsWith(".mp3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywx
 * JD-Core Version:    0.7.0.1
 */