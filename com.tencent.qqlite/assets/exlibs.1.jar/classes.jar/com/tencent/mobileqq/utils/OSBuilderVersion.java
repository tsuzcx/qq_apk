package com.tencent.mobileqq.utils;

import android.os.Build.VERSION;

public class OSBuilderVersion
{
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 9;
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 12;
  }
  
  public static boolean e()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.OSBuilderVersion
 * JD-Core Version:    0.7.0.1
 */