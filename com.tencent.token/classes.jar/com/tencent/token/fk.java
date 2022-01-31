package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.tencent.service.d;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.GuideQQPimSecureDialog;
import com.tmsdk.TMSDKContext;
import com.tmsdk.base.conch.ConchServiceProxy;
import java.util.ArrayList;
import java.util.List;

public class fk
{
  public static void a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(6275));
    localArrayList.add(Integer.valueOf(6277));
    localArrayList.add(Integer.valueOf(6296));
    ConchServiceProxy.getInstance().registerConchPush(localArrayList, new fl());
    ConchServiceProxy.getInstance().pullConch(6275);
    ConchServiceProxy.getInstance().pullConch(6277);
    ConchServiceProxy.getInstance().pullConch(6296);
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
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = d();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (b("guide_qqpimsecure_dialog_ison", -1) < 0) {}
    do
    {
      return false;
      long l = b("guide_qqpimsecure_dialog_last_show_time", -1L);
      int i = b("guide_qqpimsecure_dialog_limit_hour", -1);
      if ((l > 0L) && (i > 0) && (System.currentTimeMillis() - l < i * 3600 * 1000L))
      {
        Log.i("SecureGuideUtil", "not show guide dialog because time limit");
        return false;
      }
    } while (b());
    paramContext = new GuideQQPimSecureDialog(paramContext, c());
    try
    {
      paramContext.show();
      a("guide_qqpimsecure_dialog_last_show_time", System.currentTimeMillis());
      TMSDKContext.saveActionData(1150101);
      return true;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (b("guide_qqpimsecure_tips_ison", -1) < 0) {}
    do
    {
      return false;
      long l = b(paramString, -1L);
      int i = b("guide_qqpimsecure_tips_limit_hour", -1);
      if ((l > 0L) && (i > 0) && (System.currentTimeMillis() - l < i * 3600 * 1000L))
      {
        Log.i("SecureGuideUtil", "not show guide tips because time limit");
        return false;
      }
    } while (b());
    return true;
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
  
  public static d b(String paramString)
  {
    d locald = new d();
    locald.a = "com.tencent.qqpimsecure";
    locald.c = paramString;
    locald.d = (paramString.hashCode() + "qqsecure.apk");
    return locald;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = d();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString1, paramString2);
    }
    return null;
  }
  
  public static boolean b()
  {
    try
    {
      PackageInfo localPackageInfo = RqdApplication.l().getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      if (localPackageInfo == null) {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject;
      do
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
          localObject = null;
        }
      } while (localObject.versionCode < 1352);
    }
    return true;
  }
  
  public static ArrayList c()
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = b("guide_qqpimsecure_dialog_line1", "重要通知QQ安全中心");
    String str2 = b("guide_qqpimsecure_dialog_line2", "核心功能已搬家到手机管家");
    String str3 = b("guide_qqpimsecure_dialog_line3", "QQ安全中心的常用功能已全面升级");
    String str4 = b("guide_qqpimsecure_dialog_line4", "前往设置");
    localArrayList.add(str1);
    localArrayList.add(str2);
    localArrayList.add(str3);
    localArrayList.add(str4);
    return localArrayList;
  }
  
  private static SharedPreferences d()
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.l().getSharedPreferences("com.tencent.token.com", 0);
      return localSharedPreferences;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fk
 * JD-Core Version:    0.7.0.1
 */