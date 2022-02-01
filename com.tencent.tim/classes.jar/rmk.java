import java.io.File;
import java.io.FilenameFilter;

public final class rmk
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".mp4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmk
 * JD-Core Version:    0.7.0.1
 */