package com.tencent.open.base;

import android.text.TextUtils;
import arwt;

public class BspatchUtil
{
  protected static final String TAG = BspatchUtil.class.getName();
  protected static boolean ddp;
  
  static
  {
    try
    {
      System.loadLibrary("c++_shared");
      System.loadLibrary("bspatch");
      ddp = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      arwt.e(TAG, "load bspatch error : " + localThrowable.toString());
      ddp = false;
    }
  }
  
  public static boolean D(String paramString1, String paramString2, String paramString3)
  {
    arwt.i(TAG, "srcFile = " + paramString1 + "\npatchFile = " + paramString2 + "\ndstFile = " + paramString3 + "\nisSupport = " + String.valueOf(ddp));
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (!ddp)) {
      return false;
    }
    try
    {
      boolean bool = bspatch(paramString1, paramString3, paramString2);
      return bool;
    }
    catch (Throwable paramString1)
    {
      arwt.e(TAG, "patch error : " + paramString1.toString());
    }
    return false;
  }
  
  protected static native boolean bspatch(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.base.BspatchUtil
 * JD-Core Version:    0.7.0.1
 */