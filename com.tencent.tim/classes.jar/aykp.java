import java.io.File;
import java.io.FilenameFilter;

class aykp
  implements FilenameFilter
{
  aykp(aykn paramaykn) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp")) || (paramString.endsWith(".apng"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aykp
 * JD-Core Version:    0.7.0.1
 */