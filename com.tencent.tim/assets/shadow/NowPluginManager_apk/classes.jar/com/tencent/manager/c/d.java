package com.tencent.manager.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.manager.c;
import com.tencent.shadow.core.manager.installplugin.InstalledPlugin;

public class d
{
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences(paramContext.getPackageName(), 0).getInt("cur_now_plugin_frame_version", 0);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(paramContext.getPackageName(), 0).edit();
    paramContext.putInt("cur_now_plugin_frame_version", paramInt);
    paramContext.commit();
  }
  
  public static boolean a(c paramc)
  {
    return (paramc.k == 4) || (paramc.k == 5) || (paramc.k == 6);
  }
  
  public static boolean a(InstalledPlugin paramInstalledPlugin)
  {
    if (paramInstalledPlugin == null) {}
    while (paramInstalledPlugin.getPlugin("NowAV") == null) {
      return false;
    }
    return true;
  }
  
  public static boolean b(InstalledPlugin paramInstalledPlugin)
  {
    if (paramInstalledPlugin == null) {}
    while (paramInstalledPlugin.getPlugin("NowBiz") == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.c.d
 * JD-Core Version:    0.7.0.1
 */