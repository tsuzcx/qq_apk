package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class TbsDownloadConfig
{
  public static final int CMD_ID_DOWNLOAD_FILE = 101;
  public static final int CMD_ID_FILE_UPLOAD = 100;
  private static final int DEFAULT_DOWNLOAD_FAILED_MAX_RETRYTIMES = 100;
  private static final int DEFAULT_DOWNLOAD_MAX_FLOW = 20;
  private static final int DEFAULT_DOWNLOAD_MIN_FREE_SPACE = 70;
  private static final long DEFAULT_DOWNLOAD_SINGLE_TIMEOUT = 1200000L;
  private static final int DEFAULT_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = 3;
  public static final int ERROR_DOWNLOAD = 2;
  public static final int ERROR_INSTALL = 5;
  public static final int ERROR_LOAD = 6;
  public static final int ERROR_NONE = 1;
  public static final int ERROR_REPORTED = 0;
  public static final int ERROR_UNZIP = 4;
  public static final int ERROR_VERIFY = 3;
  private static final String TBS_CFG_FILE = "tbs_download_config";
  public static final long TBS_CONFIG_CHECK_PERIOD = 86400000L;
  private static TbsDownloadConfig mInstance;
  SharedPreferences mPreferences;
  Map<String, Object> mSyncMap = new HashMap();
  
  private TbsDownloadConfig(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_config", 4);
  }
  
  public static TbsDownloadConfig getInstance()
  {
    try
    {
      TbsDownloadConfig localTbsDownloadConfig = mInstance;
      return localTbsDownloadConfig;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadConfig getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsDownloadConfig(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      this.mSyncMap.clear();
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void commit()
  {
    for (;;)
    {
      String str;
      Object localObject2;
      try
      {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        Iterator localIterator = this.mSyncMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label203;
        }
        str = (String)localIterator.next();
        localObject2 = this.mSyncMap.get(str);
        if ((localObject2 instanceof String))
        {
          localEditor.putString(str, (String)localObject2);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
        if ((localObject2 instanceof Boolean))
        {
          localException.putBoolean(str, ((Boolean)localObject2).booleanValue());
          continue;
        }
      }
      finally {}
      if ((localObject2 instanceof Long))
      {
        localObject1.putLong(str, ((Long)localObject2).longValue());
      }
      else if ((localObject2 instanceof Integer))
      {
        localObject1.putInt(str, ((Integer)localObject2).intValue());
      }
      else if ((localObject2 instanceof Float))
      {
        localObject1.putFloat(str, ((Float)localObject2).floatValue());
        continue;
        label203:
        localObject1.commit();
        this.mSyncMap.clear();
      }
    }
  }
  
  public int getDownloadFailedMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_failed_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 100;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getDownloadMaxflow()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_maxflow", 0);
      int j = i;
      if (i == 0) {
        j = 20;
      }
      long l = j * 1024;
      return l * 1024L;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getDownloadMinFreeSpace()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_min_free_space", 0);
      int j = i;
      if (i == 0) {
        j = 70;
      }
      long l = j * 1024;
      return l * 1024L;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getDownloadSingleTimeout()
  {
    try
    {
      long l1 = this.mPreferences.getLong("tbs_single_timeout", 0L);
      long l2 = l1;
      if (l1 == 0L) {
        l2 = 1200000L;
      }
      return l2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getDownloadSuccessMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_success_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 3;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static abstract interface TbsConfigKey
  {
    public static final String KEY_APP_METADATA = "app_metadata";
    public static final String KEY_APP_VERSIONCODE = "app_versioncode";
    public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
    public static final String KEY_APP_VERSIONNAME = "app_versionname";
    public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
    public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
    public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
    public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
    public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
    public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
    public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
    public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
    public static final String KEY_LAST_CHECK = "last_check";
    public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
    public static final String KEY_RESPONSECODE = "tbs_responsecode";
    public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
    public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
    public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
    public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
    public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
    public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloadConfig
 * JD-Core Version:    0.7.0.1
 */