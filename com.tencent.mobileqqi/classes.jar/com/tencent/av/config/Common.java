package com.tencent.av.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Common
{
  public static final int a = 101;
  public static final String a = "V2.9.0304.001";
  public static final String b = "android_4.3.x";
  public static final String c = "VideoConfigInfo";
  public static final String d = "ConfigInfo";
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      j = 0;
      return j;
    }
    int j = 1;
    int i = paramInt2;
    paramInt2 = j;
    for (;;)
    {
      j = paramInt2;
      if (i <= 0) {
        break;
      }
      paramInt2 *= paramInt1;
      i -= 1;
    }
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return "android_4.3.x";
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.versionName.trim())))
        {
          paramContext = "android_" + paramContext.versionName.trim();
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "android_4.3.x";
  }
  
  public static void a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramContext = paramContext.openFileOutput(paramString, 0);
      paramContext.write(paramArrayOfByte);
      paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static byte[] a(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      paramString = paramContext.openFileInput(paramString);
      localObject1 = localObject2;
      int i = paramString.available();
      if (i <= 0) {
        return null;
      }
      localObject1 = localObject2;
      paramContext = new byte[i];
      localObject1 = paramContext;
      paramString.read(paramContext);
      localObject1 = paramContext;
      paramString.close();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.Common
 * JD-Core Version:    0.7.0.1
 */