package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.service.a.a;
import com.tencent.token.global.RqdApplication;

public class ed
{
  private static SharedPreferences a()
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.l().getSharedPreferences("com.tencent.token.com", 0);
      return localSharedPreferences;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static a.a a(String paramString1, String paramString2)
  {
    a.a locala = new a.a();
    locala.a = "com.tencent.qqpimsecure";
    locala.c = paramString2;
    locala.d = (paramString2.hashCode() + paramString1 + ".apk");
    return locala;
  }
  
  public static void a(String paramString, int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(paramString, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static int b(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt(paramString, paramInt);
    }
    return -1;
  }
  
  public static long b(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong(paramString, paramLong);
    }
    return -1L;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static String c(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString1, paramString2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ed
 * JD-Core Version:    0.7.0.1
 */