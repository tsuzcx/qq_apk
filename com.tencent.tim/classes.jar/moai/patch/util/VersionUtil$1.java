package moai.patch.util;

import java.io.File;
import java.io.FilenameFilter;

final class VersionUtil$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("moai_patch_launch_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.util.VersionUtil.1
 * JD-Core Version:    0.7.0.1
 */