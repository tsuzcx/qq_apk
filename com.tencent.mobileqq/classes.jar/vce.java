import java.io.File;
import java.io.FileFilter;

class vce
  implements FileFilter
{
  vce(vcd paramvcd) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vce
 * JD-Core Version:    0.7.0.1
 */