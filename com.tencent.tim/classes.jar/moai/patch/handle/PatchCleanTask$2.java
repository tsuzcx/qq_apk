package moai.patch.handle;

import java.io.File;
import java.io.FilenameFilter;

class PatchCleanTask$2
  implements FilenameFilter
{
  PatchCleanTask$2(PatchCleanTask paramPatchCleanTask) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString.startsWith("moai_patch_")) {}
    for (;;)
    {
      return true;
      if (paramString.endsWith(".zip")) {
        return false;
      }
      try
      {
        paramFile = paramString.split("_");
        if (paramFile.length == 2)
        {
          int i = Integer.parseInt(paramFile[0]);
          if (i >= 0) {
            continue;
          }
          return false;
        }
      }
      catch (Exception paramFile) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchCleanTask.2
 * JD-Core Version:    0.7.0.1
 */