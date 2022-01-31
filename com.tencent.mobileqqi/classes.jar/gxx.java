import java.io.File;
import java.io.FilenameFilter;

class gxx
  implements FilenameFilter
{
  gxx(gxw paramgxw) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxx
 * JD-Core Version:    0.7.0.1
 */