package com.tencent.common;

import awtj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;

public class GifUtil
{
  static
  {
    try
    {
      awtj.init();
      System.load(new File(FeatureManager.getSoDir(), "libgiflossy.so").getPath());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("GifUtil", 4, "load libgiflossy.so fail, msg = " + localException.getMessage());
    }
  }
  
  public static native int compressGif(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.GifUtil
 * JD-Core Version:    0.7.0.1
 */