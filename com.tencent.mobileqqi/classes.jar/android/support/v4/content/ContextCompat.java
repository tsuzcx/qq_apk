package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;

public class ContextCompat
{
  private static final String DIR_ANDROID = "Android";
  private static final String DIR_CACHE = "cache";
  private static final String DIR_DATA = "data";
  private static final String DIR_FILES = "files";
  private static final String DIR_OBB = "obb";
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    String str;
    if (i < j)
    {
      str = paramVarArgs[i];
      if (paramFile == null) {
        paramFile = new File(str);
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (str != null)
      {
        paramFile = new File(paramFile, str);
        continue;
        return paramFile;
      }
    }
  }
  
  public static File[] getExternalCacheDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19) {
      return ContextCompatKitKat.getExternalCacheDirs(paramContext);
    }
    if (i >= 8) {}
    for (paramContext = ContextCompatFroyo.getExternalCacheDir(paramContext);; paramContext = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "data", paramContext.getPackageName(), "cache" })) {
      return new File[] { paramContext };
    }
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19) {
      return ContextCompatKitKat.getExternalFilesDirs(paramContext, paramString);
    }
    if (i >= 8) {}
    for (paramContext = ContextCompatFroyo.getExternalFilesDir(paramContext, paramString);; paramContext = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "data", paramContext.getPackageName(), "files", paramString })) {
      return new File[] { paramContext };
    }
  }
  
  public static File[] getObbDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19) {
      return ContextCompatKitKat.getObbDirs(paramContext);
    }
    if (i >= 11) {}
    for (paramContext = ContextCompatHoneycomb.getObbDir(paramContext);; paramContext = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "obb", paramContext.getPackageName() })) {
      return new File[] { paramContext };
    }
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 16)
    {
      ContextCompatJellybean.startActivities(paramContext, paramArrayOfIntent, paramBundle);
      return true;
    }
    if (i >= 11)
    {
      ContextCompatHoneycomb.startActivities(paramContext, paramArrayOfIntent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v4.content.ContextCompat
 * JD-Core Version:    0.7.0.1
 */