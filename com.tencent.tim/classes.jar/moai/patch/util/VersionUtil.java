package moai.patch.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;

public class VersionUtil
{
  private static File sFirstLaunchFile;
  
  public static int getVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static boolean isCurrentVersionFirstLaunch(Context paramContext)
  {
    if (sFirstLaunchFile == null) {}
    try
    {
      if (sFirstLaunchFile == null) {
        sFirstLaunchFile = new File(paramContext.getFilesDir(), "moai_patch_launch_" + getVersionCode(paramContext));
      }
      if (!sFirstLaunchFile.exists()) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public static void setCurrentVersionFirstLaunched(Context paramContext)
  {
    if (isCurrentVersionFirstLaunch(paramContext))
    {
      paramContext = paramContext.getFilesDir().listFiles(new VersionUtil.1());
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        paramContext[i].delete();
        i += 1;
      }
    }
    try
    {
      sFirstLaunchFile.createNewFile();
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.util.VersionUtil
 * JD-Core Version:    0.7.0.1
 */