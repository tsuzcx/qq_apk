package moai.patch.handle;

import android.content.Context;
import java.io.File;
import java.io.FileFilter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import moai.patch.log.PatchLog;

public class NameGenerator
{
  public static final String APK_NAME = "patch.apk";
  public static final String PATCH_DEX_PREFIX = "moai_patch_";
  public static final String PATCH_DIR_PREFIX = "moai_patch_";
  
  public static String currentPatchDirName(Context paramContext)
  {
    paramContext = getMaxMoaiPatchDir(paramContext, true);
    if (paramContext == null) {
      return "";
    }
    return paramContext.getName();
  }
  
  private static int findMaxVersion(File paramFile)
  {
    return findMaxVersion(paramFile, new NameGenerator.2());
  }
  
  private static int findMaxVersion(File paramFile, FileFilter paramFileFilter)
  {
    int j = 0;
    int i = 0;
    paramFile = paramFile.listFiles(paramFileFilter);
    int k = j;
    if (paramFile != null)
    {
      k = j;
      if (paramFile.length > 0)
      {
        int m = paramFile.length;
        j = 0;
        k = i;
        if (j < m)
        {
          paramFileFilter = paramFile[j].getName();
          k = Integer.parseInt(paramFileFilter.substring(paramFileFilter.lastIndexOf('_') + 1, paramFileFilter.length()));
          if (k <= i) {
            break label87;
          }
          i = k;
        }
      }
    }
    label87:
    for (;;)
    {
      j += 1;
      break;
      return k;
    }
  }
  
  public static File getMaxMoaiPatchDir(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getDir("patch", 0).listFiles(new NameGenerator.1());
    if ((paramContext != null) && (paramContext.length > 0))
    {
      Arrays.sort(paramContext, new PatchDirSorter());
      if (!paramBoolean) {
        return paramContext[0];
      }
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        File localFile = paramContext[i];
        if (new File(localFile, "working_finish").exists())
        {
          PatchLog.d("getMaxMoaiPatchDir result:" + localFile.getAbsolutePath());
          return localFile;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private static String maxPatchDirName(File paramFile)
  {
    return "moai_patch_" + findMaxVersion(paramFile);
  }
  
  static String nextPatchDirName(File paramFile)
  {
    return "moai_patch_" + (findMaxVersion(paramFile) + 1);
  }
  
  static class PatchDirSorter
    implements Comparator<File>
  {
    public int compare(File paramFile1, File paramFile2)
    {
      paramFile1 = paramFile1.getName();
      paramFile2 = paramFile2.getName();
      int i = Integer.parseInt(paramFile1.substring(paramFile1.lastIndexOf("_") + 1));
      int j = Integer.parseInt(paramFile2.substring(paramFile2.lastIndexOf("_") + 1));
      System.err.println("v1:" + i + ",v2:" + j);
      if (i >= j) {
        return -1;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.NameGenerator
 * JD-Core Version:    0.7.0.1
 */