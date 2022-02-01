package moai.patch.util;

import java.io.File;
import java.io.FileFilter;

public class ZipFilter
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".zip");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.util.ZipFilter
 * JD-Core Version:    0.7.0.1
 */