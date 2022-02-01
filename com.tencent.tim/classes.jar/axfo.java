import java.io.File;
import java.io.FilenameFilter;

class axfo
  implements FilenameFilter
{
  axfo(axfn paramaxfn) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfo
 * JD-Core Version:    0.7.0.1
 */