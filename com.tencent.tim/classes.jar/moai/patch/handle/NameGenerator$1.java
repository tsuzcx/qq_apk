package moai.patch.handle;

import java.io.File;
import java.io.FilenameFilter;

final class NameGenerator$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("moai_patch_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.NameGenerator.1
 * JD-Core Version:    0.7.0.1
 */