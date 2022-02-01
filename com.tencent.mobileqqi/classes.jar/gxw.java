import java.io.File;
import java.io.FilenameFilter;

class gxw
  implements FilenameFilter
{
  gxw(gxv paramgxv) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxw
 * JD-Core Version:    0.7.0.1
 */