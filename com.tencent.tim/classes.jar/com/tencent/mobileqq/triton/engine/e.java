package com.tencent.mobileqq.triton.engine;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.statics.NativeLibraryLoadStatistic;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class e
{
  private static final String[] a = { "c++_shared", "freetypejni", "v8jni", "triton" };
  private static final String[] b = { "webAudio" };
  
  public static HashMap<String, Boolean> a(String paramString, ArrayList<NativeLibraryLoadStatistic> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      localHashMap.put(str, Boolean.valueOf(a(paramString, str, paramArrayList)));
      i += 1;
    }
    return localHashMap;
  }
  
  public static boolean a(String paramString1, String paramString2, ArrayList<NativeLibraryLoadStatistic> paramArrayList)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new File(paramString1);
        if ((paramString1 == null) || (!paramString1.exists())) {
          break label152;
        }
        localFile = new File(paramString1, "lib" + paramString2 + ".so");
        localObject1 = localFile;
        paramString1 = localFile;
      }
    }
    finally
    {
      try
      {
        File localFile;
        Object localObject1;
        while (localFile.exists())
        {
          paramString1 = localFile;
          localObject1 = localFile.getAbsolutePath();
          paramString1 = localFile;
          TTLog.c("SoLoader", "loadOptionalSo so [" + paramString2 + "] from " + (String)localObject1);
          paramString1 = localFile;
          System.load((String)localObject1);
          return true;
          paramString1 = null;
          continue;
          label152:
          localObject1 = null;
        }
        paramString1 = (String)localObject1;
        TTLog.c("SoLoader", "loadOptionalSo so [" + paramString2 + "] from apk libs");
        paramString1 = (String)localObject1;
        System.loadLibrary(paramString2);
        paramString1 = (String)localObject1;
        paramArrayList.add(new NativeLibraryLoadStatistic(true, paramString2, (File)localObject1, true, SystemClock.uptimeMillis() - l, null));
        return true;
      }
      finally
      {
        break label227;
      }
      localThrowable = finally;
      paramString1 = null;
    }
    label227:
    TTLog.a("SoLoader", "可选so加载失败了不中断主流程 loadOptionalSo error ", localThrowable);
    paramArrayList.add(new NativeLibraryLoadStatistic(false, paramString2, paramString1, true, SystemClock.uptimeMillis() - l, localThrowable));
    return false;
  }
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  public static void b(String paramString, ArrayList<NativeLibraryLoadStatistic> paramArrayList)
  {
    File localFile;
    if (!TextUtils.isEmpty(paramString)) {
      localFile = new File(paramString);
    }
    for (;;)
    {
      String[] arrayOfString = a;
      int j = arrayOfString.length;
      int i = 0;
      if (i >= j) {
        break label264;
      }
      String str2 = arrayOfString[i];
      str1 = null;
      Object localObject = null;
      long l = SystemClock.uptimeMillis();
      paramString = localObject;
      if (localFile != null) {
        paramString = localObject;
      }
      for (;;)
      {
        try
        {
          if (localFile.exists()) {
            paramString = new File(localFile, System.mapLibraryName(str2));
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
        {
          boolean bool;
          paramString = str1;
          continue;
          continue;
        }
        try
        {
          for (;;)
          {
            bool = paramString.exists();
            if (bool) {
              break label278;
            }
            paramString = null;
            if (paramString == null) {
              break;
            }
            try
            {
              str1 = paramString.getAbsolutePath();
              TTLog.c("SoLoader", "loadSo so [" + str2 + "] from " + str1);
              System.load(str1);
              paramArrayList.add(new NativeLibraryLoadStatistic(true, str2, paramString, false, SystemClock.uptimeMillis() - l, null));
              i += 1;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError1) {}
          }
          localFile = null;
          break;
          TTLog.c("SoLoader", "loadSo so [" + str2 + "] from apk libs");
          System.loadLibrary(str2);
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2) {}
      }
    }
    TTLog.b("SoLoader", "loadSo error ", localUnsatisfiedLinkError1);
    paramArrayList.add(new NativeLibraryLoadStatistic(false, str2, paramString, false, SystemClock.uptimeMillis() - l, localUnsatisfiedLinkError1));
    throw localUnsatisfiedLinkError1;
    label264:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.e
 * JD-Core Version:    0.7.0.1
 */