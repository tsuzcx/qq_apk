import java.io.File;
import java.io.FilenameFilter;

class uzb
  implements FilenameFilter
{
  uzb(uyz paramuyz) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzb
 * JD-Core Version:    0.7.0.1
 */