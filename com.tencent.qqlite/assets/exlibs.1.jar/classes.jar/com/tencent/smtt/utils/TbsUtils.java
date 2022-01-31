package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class TbsUtils
{
  private static final String MM_PACKAGE_NAME = "com.tencent.mm";
  private static File mDirectoryTBSShare = null;
  
  @TargetApi(9)
  public static boolean createDirectoryTBS(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      if (mDirectoryTBSShare == null) {
        try
        {
          if (paramContext.getApplicationInfo().processName.contains("com.tencent.mm"))
          {
            paramContext = paramContext.getDir("tbs", 0);
            if ((paramContext != null) && (paramContext.isDirectory()))
            {
              paramContext = new File(paramContext, "share");
              if (paramContext != null)
              {
                if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
                  continue;
                }
                mDirectoryTBSShare = paramContext;
                paramContext.setExecutable(true, false);
                return true;
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return false;
        }
      }
    }
    return true;
  }
  
  public static long getApkSize(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        return paramString.length() / 1024L;
      }
    }
    return 0L;
  }
  
  public static long getDirSize(File paramFile)
  {
    if ((paramFile != null) && (paramFile.isDirectory()))
    {
      long l = 0L;
      paramFile = paramFile.listFiles();
      int i = 0;
      while (i < paramFile.length)
      {
        l += paramFile[i].length();
        i += 1;
      }
      return l / 1024L;
    }
    return 0L;
  }
  
  public static long getROMAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks() / 1024L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsUtils
 * JD-Core Version:    0.7.0.1
 */