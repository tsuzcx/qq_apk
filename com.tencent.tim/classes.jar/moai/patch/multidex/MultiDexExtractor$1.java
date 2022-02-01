package moai.patch.multidex;

import java.io.File;
import java.io.FileFilter;

final class MultiDexExtractor$1
  implements FileFilter
{
  MultiDexExtractor$1(String paramString) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().startsWith(this.val$extractedFilePrefix)) && (!paramFile.getName().startsWith("moai_patch_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.multidex.MultiDexExtractor.1
 * JD-Core Version:    0.7.0.1
 */