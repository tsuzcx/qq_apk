import java.io.File;
import java.io.FilenameFilter;

class zcb
  implements FilenameFilter
{
  zcb(zbz paramzbz) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcb
 * JD-Core Version:    0.7.0.1
 */