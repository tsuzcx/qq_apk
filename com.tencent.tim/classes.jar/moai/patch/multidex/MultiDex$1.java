package moai.patch.multidex;

import java.io.File;
import java.io.FilenameFilter;

final class MultiDex$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith("dex");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.multidex.MultiDex.1
 * JD-Core Version:    0.7.0.1
 */