import java.io.File;
import java.io.FilenameFilter;

class apzy
  implements FilenameFilter
{
  apzy(apzu paramapzu, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.startsWith(this.cdF)) && (paramString.endsWith(".localstorage"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzy
 * JD-Core Version:    0.7.0.1
 */