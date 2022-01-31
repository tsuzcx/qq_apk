import java.io.File;
import java.io.FilenameFilter;

class eos
  implements FilenameFilter
{
  eos(eor parameor) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eos
 * JD-Core Version:    0.7.0.1
 */