import java.io.File;
import java.io.FileFilter;

class ayko
  implements FileFilter
{
  ayko(aykn paramaykn) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayko
 * JD-Core Version:    0.7.0.1
 */