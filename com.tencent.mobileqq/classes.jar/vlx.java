import java.io.File;
import java.io.FilenameFilter;

class vlx
  implements FilenameFilter
{
  vlx(vlv paramvlv) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vlx
 * JD-Core Version:    0.7.0.1
 */