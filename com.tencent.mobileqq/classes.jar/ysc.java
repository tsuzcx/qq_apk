import java.io.File;
import java.io.FilenameFilter;

class ysc
  implements FilenameFilter
{
  ysc(ysa paramysa) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysc
 * JD-Core Version:    0.7.0.1
 */