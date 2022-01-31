package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;

public class ContactConfig
{
  private static final String a = "fl_show_pc_icon";
  private static final String b = "fl_pre_get_last_login_info";
  private static final String c = "fl_get_last_login_info_time_period";
  private static final String d = "pref_req_self_level_time";
  private static final String e = "pref_req_x_man_prefix";
  private static final String f = "save_qqhead_to_app_storage";
  private static final String g = "_role";
  
  public static long a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQi", 0).getLong("pref_req_self_level_time" + paramString, 0L);
  }
  
  public static String a(String paramString)
  {
    return paramString + "_role";
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 60 * 1000;
    paramContext = paramContext.getSharedPreferences(paramString, 0).edit();
    paramContext.putLong("fl_pre_get_last_login_info", l1);
    paramContext.putLong("fl_get_last_login_info_time_period", l2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.U), 0).edit();
    paramContext.putInt(paramString, paramInt);
    if (paramInt == 6)
    {
      paramInt = i;
      if (paramBoolean) {
        paramInt = 1;
      }
      paramContext.putInt(a(paramString), paramInt);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("mobileQQi", 0).edit().putLong("pref_req_self_level_time" + paramString, System.currentTimeMillis()).commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences(paramString, 0).edit();
    paramContext.putBoolean("fl_show_pc_icon", paramBoolean);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("mobileQQi", 0).edit().putBoolean("save_qqhead_to_app_storage", paramBoolean).commit();
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("mobileQQi", 0).getBoolean("save_qqhead_to_app_storage", false);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0).getBoolean("fl_show_pc_icon", false);
  }
  
  public static long b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQi", 0).getLong("pref_req_x_man_prefix" + paramString, 0L);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences(String.valueOf(AppConstants.U), 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("mobileQQi", 0).edit().putLong("pref_req_x_man_prefix" + paramString, paramLong).commit();
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences(paramString, 0);
    long l1 = paramContext.getLong("fl_pre_get_last_login_info", 0L);
    long l2 = paramContext.getLong("fl_get_last_login_info_time_period", 0L);
    long l3 = System.currentTimeMillis();
    if ((l1 >= l3) || (l3 >= l1 + l2)) {
      bool = true;
    }
    return bool;
  }
  
  public static void c(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences(String.valueOf(AppConstants.U), 0).edit().putInt(paramString, paramInt).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ContactConfig
 * JD-Core Version:    0.7.0.1
 */