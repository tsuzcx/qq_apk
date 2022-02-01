import java.io.File;
import java.io.FileFilter;

class ysb
  implements FileFilter
{
  ysb(ysa paramysa) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysb
 * JD-Core Version:    0.7.0.1
 */