import java.io.File;
import java.io.FilenameFilter;

class yyg
  implements FilenameFilter
{
  yyg(yye paramyye) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyg
 * JD-Core Version:    0.7.0.1
 */