package com.tencent.mobileqq.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class SystemUtil
{
  public static String a = "/data/data/com.tencent.mobileqqi/files/";
  
  public static long a()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null) {
      a = paramContext.getApplicationContext().getFilesDir().getAbsolutePath() + "/";
    }
  }
  
  public static boolean a()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = Environment.getExternalStorageState().equals("mounted");
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static long b()
  {
    try
    {
      StatFs localStatFs = new StatFs(a);
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemUtil
 * JD-Core Version:    0.7.0.1
 */