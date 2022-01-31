package com.tencent.mobileqq.ptt;

import android.content.Context;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PttSoLoader
{
  private static final String a = "PttSoLoader";
  public static final boolean a = true;
  
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    int j = 0;
    int i = 0;
    int k;
    int m;
    do
    {
      j = paramString1.indexOf(paramString2, j);
      k = j;
      if (j == -1) {
        break;
      }
      k = j;
      if (i >= paramInt) {
        break;
      }
      k = j + paramString2.length();
      m = i + 1;
      j = k;
      i = m;
    } while (m < paramInt);
    return k;
  }
  
  public static String a()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplicationImpl.a);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return str + "/UnCompressPttSoTemp/";
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    int i = VcSystemInfo.f();
    Object localObject = c();
    String str = b();
    boolean bool1;
    switch (i)
    {
    default: 
      localObject = str + "lib" + paramString + (String)localObject + ".so";
      str = str + "lib" + paramString + "_5_8" + ".so";
      bool1 = new File((String)localObject).exists();
      if (!bool1)
      {
        bool1 = new File(str).exists();
        localObject = str;
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "start LoadPttSo: " + (String)localObject);
      }
      if (bool1) {}
      for (;;)
      {
        try
        {
          System.load((String)localObject);
          bool1 = true;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("PttSoLoader", 2, "load from txlib failed: " + localUnsatisfiedLinkError.getMessage());
          bool2 = SoLoadUtilNew.loadSoByName(paramContext, paramString);
          bool1 = false;
          continue;
        }
        PttInfoCollector.a(bool1);
        if (QLog.isColorLevel()) {
          QLog.i("PttSoLoader", 2, "load " + (String)localObject + " result=" + bool1);
        }
        return bool2;
        localObject = str + "lib" + paramString + (String)localObject + "_v7.so";
        str = str + "lib" + paramString + "_5_8" + "_v7.so";
        break;
        localObject = str + "lib" + paramString + (String)localObject + "_mips.so";
        str = str + "lib" + paramString + "_5_8" + "_mips.so";
        break;
        localObject = str + "lib" + paramString + (String)localObject + "_x86.so";
        str = str + "lib" + paramString + "_5_8" + "_x86.so";
        break;
        if (QLog.isColorLevel()) {
          QLog.i("PttSoLoader", 2, "no ptt so in txlib.");
        }
        bool2 = SoLoadUtilNew.loadSoByName(paramContext, paramString);
        bool1 = false;
      }
    }
  }
  
  public static String b()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplicationImpl.a);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return str + "/txPttlib/";
  }
  
  public static String c()
  {
    String str = "3.5.0".replace(".", "_");
    int i = a(str, "_", 2);
    if (i == -1) {
      return "_" + str;
    }
    return "_" + str.substring(0, i - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttSoLoader
 * JD-Core Version:    0.7.0.1
 */