import java.io.File;
import java.io.FileFilter;

class rgq
  implements FileFilter
{
  rgq(rgp paramrgp) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgq
 * JD-Core Version:    0.7.0.1
 */