import java.io.File;
import java.io.FileFilter;

class lag
  implements FileFilter
{
  lag(lae paramlae) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".json")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lag
 * JD-Core Version:    0.7.0.1
 */