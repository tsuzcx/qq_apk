import java.io.File;
import java.io.FilenameFilter;

class apzx
  implements FilenameFilter
{
  apzx(apzu paramapzu, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.startsWith(this.cdF)) && (paramString.endsWith(".localstorage"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzx
 * JD-Core Version:    0.7.0.1
 */