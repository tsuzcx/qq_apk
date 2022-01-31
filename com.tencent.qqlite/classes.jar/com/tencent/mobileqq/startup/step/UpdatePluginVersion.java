package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UpdatePluginVersion
  extends Step
{
  private static final String[] a = { "qlink_plugin.apk", "WeiyunPlugin.apk" };
  private static final String b = "update_plugin_version";
  private static final String c = "version";
  
  private void a(Context paramContext)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("UpdatePluginVersion", 2, "clearOldPlugin : " + a.length);
    }
    File localFile1 = PluginUtils.getPluginInstallDir(paramContext);
    paramContext = paramContext.getDir("plugin_info", 0);
    while (i < a.length)
    {
      Object localObject = a[i];
      File localFile2 = new File(localFile1, (String)localObject + ".cfg");
      boolean bool;
      if (localFile2.exists())
      {
        bool = localFile2.delete();
        if (QLog.isColorLevel()) {
          QLog.d("UpdatePluginVersion", 2, "clear cfg file." + bool);
        }
      }
      localFile2 = new File(localFile1, (String)localObject);
      if (localFile2.exists())
      {
        bool = localFile2.delete();
        if (QLog.isColorLevel()) {
          QLog.d("UpdatePluginVersion", 2, "clear plugin file." + bool);
        }
      }
      localObject = new File(paramContext, (String)localObject + ".cfg");
      if (((File)localObject).exists())
      {
        bool = ((File)localObject).delete();
        if (QLog.isColorLevel()) {
          QLog.d("UpdatePluginVersion", 2, "clear update cfg file." + bool);
        }
      }
      i += 1;
    }
  }
  
  protected boolean a()
  {
    int i = 0;
    Context localContext = BaseApplicationImpl.a.getApplicationContext();
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("update_plugin_version", 0);
    int k = localSharedPreferences.getInt("version", 0);
    try
    {
      int j = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label51:
      break label51;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpdatePluginVersion", 2, "version, currentVersion :" + k + ", " + i);
    }
    if (k < i)
    {
      a(localContext);
      localSharedPreferences.edit().putInt("version", i).commit();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdatePluginVersion
 * JD-Core Version:    0.7.0.1
 */