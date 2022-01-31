import java.io.File;
import java.io.FilenameFilter;

class xam
  implements FilenameFilter
{
  xam(xak paramxak) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xam
 * JD-Core Version:    0.7.0.1
 */