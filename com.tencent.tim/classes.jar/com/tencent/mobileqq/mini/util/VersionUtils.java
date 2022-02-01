package com.tencent.mobileqq.mini.util;

import android.os.Build.VERSION;

public final class VersionUtils
{
  public static boolean isECLAIR_MR1()
  {
    return Build.VERSION.SDK_INT >= 7;
  }
  
  public static boolean isGingerBread()
  {
    return Build.VERSION.SDK_INT >= 9;
  }
  
  public static boolean isHoneycomb()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean isHoneycombMR2()
  {
    return Build.VERSION.SDK_INT >= 13;
  }
  
  public static boolean isIceScreamSandwich()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean isJellyBean()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean isKITKAT()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean isrFroyo()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.VersionUtils
 * JD-Core Version:    0.7.0.1
 */