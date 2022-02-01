import java.io.File;
import java.io.FilenameFilter;

class avge
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.val$pluginId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avge
 * JD-Core Version:    0.7.0.1
 */