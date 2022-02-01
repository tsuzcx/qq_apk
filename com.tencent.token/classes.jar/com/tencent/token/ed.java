package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.tencent.service.a.a;
import com.tencent.token.global.RqdApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ed
{
  public static a.a a(String paramString1, String paramString2)
  {
    a.a locala = new a.a();
    locala.a = "com.tencent.qqpimsecure";
    locala.c = paramString2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2.hashCode());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".apk");
    locala.d = localStringBuilder.toString();
    return locala;
  }
  
  public static void a(String paramString, int paramInt)
  {
    Object localObject = d();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(paramString, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    Object localObject = d();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    Object localObject;
    try
    {
      PackageInfo localPackageInfo = RqdApplication.l().getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      localObject = null;
    }
    if (localObject == null) {
      return false;
    }
    if (localObject.versionCode >= 1352) {
      bool = true;
    }
    return bool;
  }
  
  public static int b(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = d();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt(paramString, paramInt);
    }
    return -1;
  }
  
  public static long b(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = d();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong(paramString, paramLong);
    }
    return -1L;
  }
  
  public static void b()
  {
    b("user_launch_date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = d();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static String c(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = d();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString1, paramString2);
    }
    return null;
  }
  
  public static boolean c()
  {
    String str = c("user_launch_date", "");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
  }
  
  private static SharedPreferences d()
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.l().getSharedPreferences("com.tencent.token.com", 0);
      return localSharedPreferences;
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ed
 * JD-Core Version:    0.7.0.1
 */