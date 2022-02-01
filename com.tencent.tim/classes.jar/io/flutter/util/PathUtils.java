package io.flutter.util;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;

public final class PathUtils
{
  public static String getCacheDirectory(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getCodeCacheDir().getPath();
    }
    return paramContext.getCacheDir().getPath();
  }
  
  public static String getDataDirectory(Context paramContext)
  {
    return paramContext.getDir("flutter", 0).getPath();
  }
  
  public static String getFilesDir(Context paramContext)
  {
    return paramContext.getFilesDir().getPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.util.PathUtils
 * JD-Core Version:    0.7.0.1
 */