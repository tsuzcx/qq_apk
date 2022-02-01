package moai.patch.util;

import java.io.File;
import java.io.FileFilter;

public class DexFilter
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".dex");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.util.DexFilter
 * JD-Core Version:    0.7.0.1
 */