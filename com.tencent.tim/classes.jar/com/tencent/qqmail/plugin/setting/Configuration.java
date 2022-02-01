package com.tencent.qqmail.plugin.setting;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;

public class Configuration
{
  public static final String PLUGIN_STORAGE_PATH = QMApplicationContext.sharedInstance().getFilesDir().getAbsolutePath() + File.separator + "plugin";
  public static final String TAG = "Configuration";
  private static SparseArray<PluginSetting> settings = new SparseArray();
  
  static
  {
    PluginSetting localPluginSetting = new PluginSetting();
    localPluginSetting.url = "https://rescdn.qqmail.com/weread/cover/imagescan_50301_1495685330304.zip";
    localPluginSetting.pluginFolder = "imageScan";
    localPluginSetting.zipFileExpectedMd5 = "88a0e44d46b87529c7cf6accd9489fd5";
    localPluginSetting.zipFileName = "imagescan_50301_1495685330304.zip";
    ensurePluginDir(localPluginSetting.pluginFolder);
    settings.put(1, localPluginSetting);
  }
  
  private static void ensureDir(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(paramString);
      if (localFile == null)
      {
        QMLog.log(5, "Configuration", "file is null.path = " + paramString);
        return;
      }
    } while (localFile.exists());
    localFile.mkdir();
  }
  
  private static void ensurePluginDir(String paramString)
  {
    ensureDir(PLUGIN_STORAGE_PATH);
    ensureDir(PLUGIN_STORAGE_PATH + File.separator + paramString);
  }
  
  public static PluginSetting inflate(int paramInt)
  {
    Log.i("Configuration", "setting = " + settings.size() + " " + settings.toString());
    return (PluginSetting)settings.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.plugin.setting.Configuration
 * JD-Core Version:    0.7.0.1
 */