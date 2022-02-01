package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class rg
{
  static String[] a = { "ro.vendor.build.fingerprint", "ro.vendor.build.display.full_id", "ro.serialno", "gsm.version.baseband" };
  
  private static String a(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        for (paramString = Integer.toHexString(localObject[i] & 0xFF); paramString.length() < 2; paramString = "0".concat(String.valueOf(paramString))) {}
        localStringBuilder.append(paramString);
        i += 1;
      }
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  @SuppressLint({"PrivateApi"})
  public static void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("qtk_rpc2", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      paramContext = a;
      if (i >= paramContext.length) {
        break;
      }
      String str = a(paramContext[i]);
      paramContext = System.getProperty(a[i], null);
      if (paramContext == null) {}
      try
      {
        localObject = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
        ((Method)localObject).setAccessible(true);
        localObject = (String)((Method)localObject).invoke(null, new Object[] { a[i] });
        paramContext = (Context)localObject;
        if (localObject == null) {}
      }
      catch (Exception localException)
      {
        Object localObject;
        label132:
        break label137;
      }
      try
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject);
        paramContext.append("$1");
        paramContext = paramContext.toString();
      }
      catch (Exception paramContext)
      {
        break label132;
      }
      paramContext = (Context)localObject;
      break label166;
      label137:
      break label166;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("$0");
      paramContext = ((StringBuilder)localObject).toString();
      label166:
      if (!localSharedPreferences.contains(str))
      {
        if (Build.VERSION.SDK_INT >= 9) {
          localSharedPreferences.edit().putString(str, paramContext).apply();
        }
      }
      else
      {
        localObject = localSharedPreferences.getString(str, null);
        if (((localObject != null) && (!((String)localObject).equals(paramContext))) || ((localObject == null) && (paramContext != null)))
        {
          localStringBuilder.append(a[i]);
          localStringBuilder.append("#");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("|");
          localStringBuilder.append(paramContext);
          localStringBuilder.append(";");
          if (Build.VERSION.SDK_INT >= 9) {
            localSharedPreferences.edit().putString(str, paramContext).apply();
          }
        }
      }
      i += 1;
    }
    if (localStringBuilder.length() > 0)
    {
      localStringBuilder.append(rf.a().b());
      rf.a().a(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rg
 * JD-Core Version:    0.7.0.1
 */