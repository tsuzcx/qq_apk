package com.qzone.utils;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class SDCardUtil
{
  private static final String NO_SDCARD_TIPS = "无SD Card";
  private static final long UNIT = 1048576L;
  private static final String UNIT_NAME = "MB";
  
  private static String calcCapUnit(int paramInt, float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return "";
    }
    if (paramFloat < 1024.0F) {
      return String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }) + countToUnit(paramInt);
    }
    return calcCapUnit(paramInt + 1, paramFloat / 1024.0F);
  }
  
  private static String calcCapUnit(long paramLong)
  {
    return calcCapUnit(0, (float)paramLong);
  }
  
  private static String countToUnit(int paramInt)
  {
    if (paramInt == 0) {
      return "byte";
    }
    if (paramInt == 1) {
      return "KB";
    }
    if (paramInt == 2) {
      return "MB";
    }
    if (paramInt == 3) {
      return "GB";
    }
    if (paramInt == 4) {
      return "TB";
    }
    if (paramInt == 5) {
      return "PB";
    }
    return "";
  }
  
  public static long getSDCardCapability()
  {
    if (!isSDCardMounted()) {
      return -1L;
    }
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  public static String getSDCardCapabilityForDisplay()
  {
    long l = getSDCardCapability();
    if (l >= 0L) {
      return calcCapUnit(l);
    }
    return "无SD Card";
  }
  
  public static long getSDCardRemain()
  {
    if (!isSDCardMounted()) {
      return -1L;
    }
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  public static String getSDCardRemainForDisplay()
  {
    long l = getSDCardRemain();
    if (l >= 0L) {
      return calcCapUnit(l);
    }
    return "无SD Card";
  }
  
  public static String getSDCardState()
  {
    return Environment.getExternalStorageState();
  }
  
  public static boolean isSDCardMounted()
  {
    return getSDCardState().equals("mounted");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.SDCardUtil
 * JD-Core Version:    0.7.0.1
 */