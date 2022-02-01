package moai.patch.handle;

import java.io.File;
import java.io.FilenameFilter;

final class PatchCleanTask$1
  implements FilenameFilter
{
  PatchCleanTask$1(int paramInt) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.startsWith("moai_patch_")) && (Integer.parseInt(paramString.substring(paramString.lastIndexOf("_") + 1)) < this.val$currentVersion);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchCleanTask.1
 * JD-Core Version:    0.7.0.1
 */