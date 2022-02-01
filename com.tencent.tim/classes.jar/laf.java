import java.io.File;
import java.io.FileFilter;

class laf
  implements FileFilter
{
  laf(lae paramlae) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     laf
 * JD-Core Version:    0.7.0.1
 */