package moai.patch.natives;

import java.io.File;
import java.io.FileFilter;

final class MoaiNativeLoader$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".so");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.natives.MoaiNativeLoader.1
 * JD-Core Version:    0.7.0.1
 */