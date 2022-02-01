import java.io.File;
import java.io.FileFilter;

class yyf
  implements FileFilter
{
  yyf(yye paramyye) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyf
 * JD-Core Version:    0.7.0.1
 */