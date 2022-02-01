import java.io.File;
import java.io.FileFilter;

class rio
  implements FileFilter
{
  rio(rin paramrin) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rio
 * JD-Core Version:    0.7.0.1
 */