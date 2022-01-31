package com.tencent.token.global;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class g
{
  public static int a()
  {
    try
    {
      int i = RqdApplication.i().getSharedPreferences("sp_name_global", 0).getInt("exchangeky_conf_ver", 0);
      return i;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return 0;
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("sp_name_global", 0).edit();
      if (paramInt == 0) {
        localEditor.putBoolean("scan_tip_next_show", paramBoolean);
      }
      for (;;)
      {
        localEditor.commit();
        return;
        localEditor.putBoolean("scan_tip_next_show_2", paramBoolean);
      }
      return;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    boolean bool = false;
    try
    {
      Object localObject = RqdApplication.i().getSharedPreferences("safe_conf_list", 0);
      if (localObject != null) {
        bool = true;
      }
      e.a(bool);
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
      e.c("getSharedPreferences error=" + paramString1.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.i().getSharedPreferences("sp_name_global", 0);
      if (paramInt == 0) {
        return localSharedPreferences.getBoolean("scan_tip_next_show", true);
      }
      boolean bool = localSharedPreferences.getBoolean("scan_tip_next_show_2", true);
      return bool;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return true;
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = RqdApplication.i().getSharedPreferences("sp_name_global", 0).getBoolean("utils_account_lock_tip", false);
      return bool;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.g
 * JD-Core Version:    0.7.0.1
 */