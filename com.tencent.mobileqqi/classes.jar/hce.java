import java.io.File;
import java.io.FilenameFilter;

class hce
  implements FilenameFilter
{
  hce(hcd paramhcd) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hce
 * JD-Core Version:    0.7.0.1
 */