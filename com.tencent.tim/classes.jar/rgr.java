import java.io.File;
import java.io.FilenameFilter;

class rgr
  implements FilenameFilter
{
  rgr(rgp paramrgp) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgr
 * JD-Core Version:    0.7.0.1
 */