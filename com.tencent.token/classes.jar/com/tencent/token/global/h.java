package com.tencent.token.global;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class h
{
  public static void a() {}
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("sp_name_global", 0).edit();
      if (paramInt == 0) {
        localEditor.putBoolean("scan_tip_next_show", paramBoolean);
      } else {
        localEditor.putBoolean("scan_tip_next_show_2", paramBoolean);
      }
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = RqdApplication.l();
      boolean bool = false;
      localObject = ((Context)localObject).getSharedPreferences("safe_conf_list", 0);
      if (localObject != null) {
        bool = true;
      }
      g.a(bool);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("JSON_LIST");
      if ((paramString1 != null) && (paramString2 != null)) {
        ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      }
      ((SharedPreferences.Editor)localObject).putInt("conf_type", 2);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("getSharedPreferences error=");
      paramString2.append(paramString1.toString());
      g.c(paramString2.toString());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("sp_name_global", 0).edit();
      localEditor.putBoolean("utils_red_dot_show", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.l().getSharedPreferences("sp_name_global", 0);
      if (paramInt == 0) {
        return localSharedPreferences.getBoolean("scan_tip_next_show", true);
      }
      boolean bool = localSharedPreferences.getBoolean("scan_tip_next_show_2", true);
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
    return true;
  }
  
  public static void b() {}
  
  public static void b(int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("sp_name_global", 0).edit();
      localEditor.putInt("exchangeky_conf_ver", paramInt);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("sp_name_global", 0).edit();
      localEditor.putBoolean("utils_account_lock_tip", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
  }
  
  public static int c()
  {
    try
    {
      int i = RqdApplication.l().getSharedPreferences("sp_name_global", 0).getInt("exchangeky_conf_ver", 0);
      return i;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
    return 0;
  }
  
  public static boolean d()
  {
    try
    {
      boolean bool = RqdApplication.l().getSharedPreferences("sp_name_global", 0).getBoolean("utils_red_dot_show", false);
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean e()
  {
    try
    {
      boolean bool = RqdApplication.l().getSharedPreferences("sp_name_global", 0).getBoolean("utils_account_lock_tip", false);
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.h
 * JD-Core Version:    0.7.0.1
 */