package com.tencent.mobileqq.mqsafeedit;

import android.content.Context;
import java.io.File;

public class CoreUtil
{
  public static String getTxLib(Context paramContext)
  {
    return paramContext.getFilesDir().getParent() + "/txlib/";
  }
  
  public static boolean loadLibrary(String paramString, Context paramContext)
  {
    bool2 = false;
    if (paramContext == null) {
      return false;
    }
    File localFile2 = new File(getTxLib(paramContext) + "lib" + paramString + ".so");
    File localFile1 = localFile2;
    if (!localFile2.exists()) {
      localFile1 = new File(paramContext.getFilesDir().getParent() + "/lib/lib" + paramString + ".so");
    }
    bool1 = bool2;
    if (localFile1.exists()) {}
    try
    {
      System.load(localFile1.getAbsolutePath());
      bool1 = true;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    bool2 = bool1;
    if (!bool1) {}
    try
    {
      System.loadLibrary(paramString);
      bool2 = true;
      return bool2;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.CoreUtil
 * JD-Core Version:    0.7.0.1
 */