import java.io.File;
import java.io.FileFilter;

class vlw
  implements FileFilter
{
  vlw(vlv paramvlv) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vlw
 * JD-Core Version:    0.7.0.1
 */