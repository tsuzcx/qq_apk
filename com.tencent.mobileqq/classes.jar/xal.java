import java.io.File;
import java.io.FileFilter;

class xal
  implements FileFilter
{
  xal(xak paramxak) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xal
 * JD-Core Version:    0.7.0.1
 */