package com.tencent.biz.qqstory.utils.pngquant;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import jpa;
import jpe;
import mqq.app.AppRuntime;
import rrd;

public final class PngQuantUtils
{
  public static AtomicBoolean bc = new AtomicBoolean(false);
  
  public static boolean LX()
  {
    if ((!bc.get()) && (jpa.di("1017")) && (jpa.C("1017", "https://libpngquantandroid.so")))
    {
      String str = jpe.dO("1017") + "1017" + File.separator + "libpngquantandroid.so";
      if (aqhq.fileExists(str))
      {
        System.load(str);
        bc.set(true);
        if (QLog.isColorLevel()) {
          QLog.d("PngQuantUtils", 2, "System.load file =" + str);
        }
      }
    }
    return bc.get();
  }
  
  public static boolean e(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null) {
      throw new NullPointerException();
    }
    if (!paramFile1.exists()) {
      return false;
    }
    if (paramFile2 == null) {
      throw new NullPointerException();
    }
    if (paramFile2.length() != 0L) {
      throw new IllegalArgumentException();
    }
    return nativePngQuantFile(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath());
  }
  
  public static void f(AppRuntime paramAppRuntime)
  {
    jpa.b("1017", paramAppRuntime, true, new rrd());
  }
  
  private static native boolean nativePngQuantFile(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils
 * JD-Core Version:    0.7.0.1
 */