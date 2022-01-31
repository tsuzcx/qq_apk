package cooperation.qzone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;
import common.qzone.component.util.SecurityUtil;

public class QZoneHelper$LocalConfig
{
  public static final String a = "QZ_setting";
  private static final String b = "preference";
  
  public static int a(String paramString, int paramInt)
  {
    return a("QZ_setting").getInt(paramString, paramInt);
  }
  
  public static int a(String paramString, int paramInt, long paramLong)
  {
    return a(paramLong).getInt(paramString, paramInt);
  }
  
  public static long a(String paramString, long paramLong)
  {
    return a("QZ_setting").getLong(paramString, paramLong);
  }
  
  private static SharedPreferences a(long paramLong)
  {
    if (paramLong == 0L) {
      return a("QZ_setting");
    }
    String str = SecurityUtil.a(String.valueOf(paramLong)) + "_" + "preference";
    return BaseApplication.getContext().getSharedPreferences(str, 0);
  }
  
  @SuppressLint({"InlinedApi"})
  private static SharedPreferences a(String paramString)
  {
    Context localContext = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0) {
      return localContext.getSharedPreferences(paramString, i);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a("QZ_setting").getString(paramString1, paramString2);
  }
  
  @SuppressLint({"NewApi"})
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = a("QZ_setting").edit();
    localEditor.putInt(paramString, paramInt);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = a(paramLong).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  @SuppressLint({"NewApi"})
  public static void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = a("QZ_setting").edit();
    localEditor.putLong(paramString, paramLong);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  @SuppressLint({"NewApi"})
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = a("QZ_setting").edit();
    localEditor.putString(paramString1, paramString2);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  @SuppressLint({"NewApi"})
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a("QZ_setting").edit();
    localEditor.putBoolean(paramString, paramBoolean);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a("QZ_setting").getBoolean(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.LocalConfig
 * JD-Core Version:    0.7.0.1
 */