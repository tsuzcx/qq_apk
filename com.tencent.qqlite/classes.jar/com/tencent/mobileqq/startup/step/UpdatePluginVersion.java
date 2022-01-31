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
import eei;
import java.io.File;

public class UpdatePluginVersion
  extends Step
{
  private static final String[] a = { "qlink_plugin.apk", "WeiyunPlugin.apk" };
  private static final String b = "update_plugin_version";
  private static final String c = "version";
  
  private void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpdatePluginVersion", 2, "clearOldPlugin : " + a.length);
    }
    int i = 0;
    while (i < a.length)
    {
      File localFile = PluginUtils.getInstallPath(paramContext, a[i]);
      Object localObject = localFile.getName();
      if (QLog.isColorLevel()) {
        QLog.d("UpdatePluginVersion", 2, "plugin : " + (String)localObject);
      }
      localObject = localFile.getParentFile().listFiles(new eei(this, (String)localObject));
      boolean bool;
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = localObject[0];
        if (((File)localObject).exists())
        {
          bool = ((File)localObject).delete();
          if (QLog.isColorLevel()) {
            QLog.d("UpdatePluginVersion", 2, "clear cfg file." + bool);
          }
        }
      }
      if (localFile.exists())
      {
        bool = localFile.delete();
        if (QLog.isColorLevel()) {
          QLog.d("UpdatePluginVersion", 2, "clear plugin file." + bool);
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