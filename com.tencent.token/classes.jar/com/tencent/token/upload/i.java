package com.tencent.token.upload;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.DecimalFormat;

public class i
{
  private static DecimalFormat a = new DecimalFormat("#0");
  private static DecimalFormat b = new DecimalFormat("#0.#");
  
  public static long a(Context paramContext)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.availMem;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return g.b;
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static long b()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return g.b;
  }
  
  public static long c()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return g.b;
  }
  
  public static long d()
  {
    try
    {
      if (a())
      {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l = localStatFs.getBlockSize();
        int i = localStatFs.getAvailableBlocks();
        return i * l;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return g.b;
  }
  
  public static long e()
  {
    try
    {
      if (a())
      {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l = localStatFs.getBlockSize();
        int i = localStatFs.getBlockCount();
        return i * l;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return g.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.i
 * JD-Core Version:    0.7.0.1
 */