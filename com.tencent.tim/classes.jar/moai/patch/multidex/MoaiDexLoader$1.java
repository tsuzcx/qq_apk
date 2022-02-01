package moai.patch.multidex;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.List;

final class MoaiDexLoader$1
  implements FilenameFilter
{
  MoaiDexLoader$1(List paramList) {}
  
  private String pickPatchDexName(String paramString)
  {
    paramString = paramString.substring(0, paramString.lastIndexOf("."));
    return paramString.substring(paramString.lastIndexOf("_") + 1);
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    if (!paramString.endsWith("zip")) {
      return false;
    }
    paramFile = this.val$files.iterator();
    while (paramFile.hasNext()) {
      if (paramString.contains(pickPatchDexName(((File)paramFile.next()).getName()))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.multidex.MoaiDexLoader.1
 * JD-Core Version:    0.7.0.1
 */