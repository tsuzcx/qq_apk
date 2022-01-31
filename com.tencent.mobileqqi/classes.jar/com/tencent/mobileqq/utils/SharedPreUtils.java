package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class SharedPreUtils
{
  public static int a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("splash_version_code", 0);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "pushbanner_ad_version_code", 0);
  }
  
  public static String a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("last_loginuin_for_birthday_uin", "");
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, paramString3);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "pushbanner_ad_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("splash_version_code", paramInt);
    paramContext.putString("splash_effectivetime", paramString1);
    paramContext.putString("splash_md5value", paramString2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("last_loginuin_for_birthday_uin", paramString);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("keyword_and_remark_version_code" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("LabaSetting_" + paramString2, 0).edit();
    paramContext.putInt(paramString1, 1);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre uin is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre auto =" + paramBoolean);
      }
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putBoolean("login_auto" + paramString, paramBoolean);
      paramBoolean = paramContext.commit();
    } while (!QLog.isColorLevel());
    QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre isOK =" + paramBoolean);
  }
  
  public static void a(Context paramContext, ArrayList paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramContext == null)) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("LabaSetting_" + paramString, 0).edit();
    paramContext.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      paramContext.putInt((String)paramArrayList.next(), 1);
    }
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool1;
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR getAutoLoginSharePre uin is null");
      }
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("login_auto" + paramString, true);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SharedPreUtils", 2, "CNR getAutoLoginSharePre auto =" + bool2);
    return bool2;
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramContext == null)) {}
    while (paramInt <= PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("acount_uin_first_use_app" + paramString, 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      bool = false;
    }
    while (paramContext.getSharedPreferences("LabaSetting_" + paramString2, 0).getInt(paramString1, 0) == 1) {
      return bool;
    }
    return false;
  }
  
  public static int b(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null) {
        i = paramContext.versionCode;
      }
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "birthday_splash_version_code", 0);
  }
  
  public static String b(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("birthday_user", "");
  }
  
  public static void b(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString2 + "_" + "birthday_splash_version_code", paramInt);
    paramContext.putString("birthday_splash_md5value", paramString1);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("birthday_user", paramString);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramContext == null)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("acount_uin_first_use_app" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      return;
    }
    paramContext.getSharedPreferences("LabaSetting_" + paramString2, 0).edit().remove(paramString1).commit();
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("acount_first_login_app" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("acount_first_login_app" + paramString, true);
  }
  
  public static int c(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("keyword_and_remark_version_code" + paramString, 0);
  }
  
  public static String c(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("splash_md5value", "");
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("translate_bubble_first_time", false);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("login_save_psw_no_auto" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("translate_bubble_first_time", true);
  }
  
  public static String d(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("splash_effectivetime", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SharedPreUtils
 * JD-Core Version:    0.7.0.1
 */