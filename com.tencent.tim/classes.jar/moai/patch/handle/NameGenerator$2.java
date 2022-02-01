package moai.patch.handle;

import java.io.File;
import java.io.FileFilter;

final class NameGenerator$2
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().startsWith("moai_patch_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.NameGenerator.2
 * JD-Core Version:    0.7.0.1
 */