import java.io.File;
import java.io.FilenameFilter;

class eox
  implements FilenameFilter
{
  eox(eow parameow) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eox
 * JD-Core Version:    0.7.0.1
 */