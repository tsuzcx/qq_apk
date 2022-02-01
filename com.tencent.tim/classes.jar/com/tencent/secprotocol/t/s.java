package com.tencent.secprotocol.t;

import a.a.a.b.c;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

public class s
{
  public static volatile int QSEC_FRAMEWORK_NATIVER_VER = -1;
  
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = b(paramContext).split("\\.");
      int i;
      if (paramContext.length == 2)
      {
        i = Integer.parseInt(paramContext[0]);
        return Integer.parseInt(paramContext[1]) << 8 | i << 16 | 0x0;
      }
      if (paramContext.length == 3)
      {
        i = Integer.parseInt(paramContext[0]);
        int j = Integer.parseInt(paramContext[1]);
        int k = Integer.parseInt(paramContext[2]);
        return k << 8 | i << 24 | 0x0 | j << 16;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static String b(Context paramContext)
  {
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      return paramContext.versionName;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = localObject;
      }
    }
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageName();
      boolean bool = TextUtils.isEmpty(paramContext);
      if (!bool) {
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String d(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64);
      int i = paramContext.signatures.length;
      if (i <= 0) {
        return "";
      }
      Signature localSignature = paramContext.signatures[0];
      try
      {
        paramContext = MessageDigest.getInstance("MD5");
        return c.a(paramContext.digest(localSignature.toByteArray()));
      }
      catch (NoSuchAlgorithmException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static int e(Context paramContext)
  {
    int i = 0;
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      paramContext = paramContext.getApplicationInfo();
      if (paramContext.packageName.equals(str)) {
        i = Integer.valueOf((int)new File(paramContext.publicSourceDir).length()).intValue();
      }
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static String getProcessName(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String md5sum(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
      while (i < j)
      {
        int k = localObject[i];
        paramString.append(String.format("%02x", new Object[] { Integer.valueOf(k & 0xFF) }));
        i += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.secprotocol.t.s
 * JD-Core Version:    0.7.0.1
 */