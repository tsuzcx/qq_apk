import java.io.File;
import java.io.FilenameFilter;

class xev
  implements FilenameFilter
{
  xev(xet paramxet) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xev
 * JD-Core Version:    0.7.0.1
 */