import java.io.File;
import java.io.FileFilter;

class zbj
  implements FileFilter
{
  zbj(zbi paramzbi) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbj
 * JD-Core Version:    0.7.0.1
 */