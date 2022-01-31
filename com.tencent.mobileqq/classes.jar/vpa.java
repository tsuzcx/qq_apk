import java.io.File;
import java.io.FileFilter;

class vpa
  implements FileFilter
{
  vpa(voz paramvoz) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpa
 * JD-Core Version:    0.7.0.1
 */