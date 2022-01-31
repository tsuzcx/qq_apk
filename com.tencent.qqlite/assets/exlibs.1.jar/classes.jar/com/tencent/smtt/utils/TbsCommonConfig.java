package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

public class TbsCommonConfig
{
  private static final String COMMON_CONFIG_FILE = "tbsnet.conf";
  private static final String FORMAL_PV_POST_URL = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private static final String FORMAL_TBSLOG_POST_URL = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private static final String FORMAL_TBS_CMD_POST_URL = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
  private static final String FORMAL_TBS_DOWNLOADER_POST_URL = "http://cfg.imtt.qq.com/tbs?mk=";
  private static final String FORMAL_TBS_DOWNLOADER_POST_URL_V2 = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
  private static final String FORMAL_TBS_DOWNLOAD_STAT_POST_URL = "http://log.tbs.qq.com/ajax?c=dl&k=";
  private static final String FORMAL_TIPS_URL = "http://mqqad.html5.qq.com/adjs";
  private static final String KEY_PV_POST_URL = "pv_post_url";
  private static final String KEY_TBS_CMD_POST_URL = "tbs_cmd_post_url";
  private static final String KEY_TBS_DOWNLOADER_POST_URL = "tbs_downloader_post_url";
  private static final String KEY_TBS_DOWNLOAD_STAT_POST_URL = "tbs_download_stat_post_url";
  private static final String KEY_TBS_LOG_POST_URL = "tbs_log_post_url";
  private static final String KEY_TIPS_URL = "tips_url";
  private static final String KEY_WUP_PROXY_DOMAIN = "wup_proxy_domain";
  private static final String LOGTAG = "TbsCommonConfig";
  private static final String TBS_FOLDER_NAME = "tbs";
  private static final String TEST_PV_POST_URL = "http://tr.cs0309.imtt.qq.com/ajax?c=pu&k=";
  private static final String TEST_TBSLOG_POST_URL = "http://tr.cs0309.imtt.qq.com/ajax?c=ul&k=";
  private static final String TEST_TBS_CMD_POST_URL = "http://tr.cs0309.imtt.qq.com/ajax?c=ucfu&k=";
  private static final String TEST_TBS_DOWNLOADER_POST_URL = "http://cfg.cs0309.imtt.qq.com/tbs?mk=";
  private static final String TEST_TBS_DOWNLOAD_STAT_POST_URL = "http://tr.cs0309.imtt.qq.com/ajax?c=dl&k=";
  private static final String TEST_TIPS_URL = "http://mqqad.cs0309.html5.qq.com/adjs";
  private static final String WUP_PROXY_DOMAIN = "http://wup.imtt.qq.com:8080";
  private static TbsCommonConfig mInstance = null;
  private Context mContext = null;
  private String mPvUploadPostUrl = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private String mTbsCmdPostUrl = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
  private File mTbsConfigDir = null;
  private String mTbsDownloadStatPostUrl = "http://log.tbs.qq.com/ajax?c=dl&k=";
  private String mTbsDownloaderPostUrl = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
  private String mTbsLogPostUrl = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private String mTipsUrl = "http://mqqad.html5.qq.com/adjs";
  private String mWupProxyDomain = "http://wup.imtt.qq.com:8080";
  
  @TargetApi(11)
  private TbsCommonConfig(Context paramContext)
  {
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.mContext = paramContext.getApplicationContext();
    loadProperties();
  }
  
  private File getConfigFile()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (this.mTbsConfigDir == null)
      {
        localObject1 = localObject2;
        this.mTbsConfigDir = new File(FileUtil.getTBSSdcardFilePath(this.mContext, 3));
        localObject1 = localObject2;
        if (this.mTbsConfigDir == null) {
          break label203;
        }
        localObject1 = localObject2;
        if (!this.mTbsConfigDir.isDirectory()) {
          break label203;
        }
      }
      localObject1 = localObject2;
      localObject3 = new File(this.mTbsConfigDir, "tbsnet.conf");
      localObject1 = localObject2;
      if (!((File)localObject3).exists())
      {
        localObject1 = localObject2;
        TbsLog.e("TbsCommonConfig", "Get file(" + ((File)localObject3).getCanonicalPath() + ") failed!");
        return null;
      }
      localObject2 = localObject3;
      localObject1 = localObject2;
      TbsLog.w("TbsCommonConfig", "pathc:" + ((File)localObject3).getCanonicalPath());
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject3 = new StringWriter();
        localThrowable.printStackTrace(new PrintWriter((Writer)localObject3));
        TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + ((StringWriter)localObject3).toString());
      }
    }
    return localObject1;
    label203:
    return null;
  }
  
  public static TbsCommonConfig getInstance()
  {
    try
    {
      TbsCommonConfig localTbsCommonConfig = mInstance;
      return localTbsCommonConfig;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsCommonConfig getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsCommonConfig(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  private void loadProperties()
  {
    for (;;)
    {
      try
      {
        localObject1 = getConfigFile();
        if (localObject1 != null) {
          continue;
        }
        TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        String str;
        Object localObject3 = new StringWriter();
        localThrowable.printStackTrace(new PrintWriter((Writer)localObject3));
        TbsLog.e("TbsCommonConfig", "exceptions occurred1:" + ((StringWriter)localObject3).toString());
        continue;
      }
      finally {}
      return;
      localObject1 = new FileInputStream((File)localObject1);
      localObject3 = new Properties();
      ((Properties)localObject3).load((InputStream)localObject1);
      str = ((Properties)localObject3).getProperty("pv_post_url", "");
      if (!"".equals(str)) {
        this.mPvUploadPostUrl = str;
      }
      str = ((Properties)localObject3).getProperty("wup_proxy_domain", "");
      if (!"".equals(str)) {
        this.mWupProxyDomain = str;
      }
      str = ((Properties)localObject3).getProperty("tbs_download_stat_post_url", "");
      if (!"".equals(str)) {
        this.mTbsDownloadStatPostUrl = str;
      }
      str = ((Properties)localObject3).getProperty("tbs_downloader_post_url", "");
      if (!"".equals(str)) {
        this.mTbsDownloaderPostUrl = str;
      }
      str = ((Properties)localObject3).getProperty("tbs_log_post_url", "");
      if (!"".equals(str)) {
        this.mTbsLogPostUrl = str;
      }
      str = ((Properties)localObject3).getProperty("tips_url", "");
      if (!"".equals(str)) {
        this.mTipsUrl = str;
      }
      localObject3 = ((Properties)localObject3).getProperty("tbs_cmd_post_url", "");
      if (!"".equals(localObject3)) {
        this.mTbsCmdPostUrl = ((String)localObject3);
      }
      ((FileInputStream)localObject1).close();
    }
  }
  
  public String getPvUploadPostUrl()
  {
    return this.mPvUploadPostUrl;
  }
  
  public String getTbsDownloadStatPostUrl()
  {
    return this.mTbsDownloadStatPostUrl;
  }
  
  public String getTbsDownloaderPostUrl()
  {
    return this.mTbsDownloaderPostUrl;
  }
  
  public String getTbsLogPostUrl()
  {
    return this.mTbsLogPostUrl;
  }
  
  public String getTipsUrl()
  {
    return this.mTipsUrl;
  }
  
  public String getWupProxyDomain()
  {
    return this.mWupProxyDomain;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsCommonConfig
 * JD-Core Version:    0.7.0.1
 */