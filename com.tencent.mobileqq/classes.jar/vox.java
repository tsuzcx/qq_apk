import java.io.File;
import java.io.FileFilter;

class vox
  implements FileFilter
{
  vox(vow paramvow) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vox
 * JD-Core Version:    0.7.0.1
 */