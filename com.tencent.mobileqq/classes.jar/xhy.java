import java.io.File;
import java.io.FileFilter;

class xhy
  implements FileFilter
{
  xhy(xhx paramxhx) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhy
 * JD-Core Version:    0.7.0.1
 */