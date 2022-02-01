import java.io.File;
import java.io.FileFilter;

class zfe
  implements FileFilter
{
  zfe(zfd paramzfd) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfe
 * JD-Core Version:    0.7.0.1
 */