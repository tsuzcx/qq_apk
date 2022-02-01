package com.huawei.hianalytics.ab.fg;

import android.content.Context;
import com.huawei.hianalytics.ab.bc.cd.ab.de;
import com.huawei.hianalytics.ab.bc.kl.cd;

public final class ab
{
  private static final String[] ab = { "ABTesting", "_default_config_tag", "_openness_config_tag", "_hms_config_tag" };
  private static ab bc = null;
  private static final Object cd = new Object();
  private Context de;
  
  public static ab ab()
  {
    if (bc == null) {
      cd();
    }
    return bc;
  }
  
  private static void cd()
  {
    try
    {
      if (bc == null) {
        bc = new ab();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ab(Context paramContext)
  {
    synchronized (cd)
    {
      if (this.de != null)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("HiAnalyticsDataManager", "DataManager already initialized.");
        return;
      }
      this.de = paramContext;
      com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd().ab(this.de);
      com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd().gh(paramContext.getPackageName());
      com.huawei.hianalytics.ab.cd.bc.ab.ab().ab(paramContext);
      return;
    }
  }
  
  public void ab(String paramString)
  {
    if (this.de == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("HiAnalyticsDataManager", "clearDataByTag() sdk is not init");
      return;
    }
    com.huawei.hianalytics.ab.bc.ef.ab.bc("HiAnalyticsDataManager", "HiAnalyticsDataManager.clearDataByTag(String appid) is execute.");
    com.huawei.hianalytics.ab.bc.ij.ab.cd(this.de, paramString);
  }
  
  public void bc()
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("HiAnalyticsDataManager", "clearCachedData() is execute.");
    if (this.de == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("HiAnalyticsDataManager", "clearCachedData() sdk is not init");
      return;
    }
    com.huawei.hianalytics.ab.bc.ef.ab.bc("HiAnalyticsDataManager", "HiAnalyticsDataManager.clearCachedData() is execute.");
    com.huawei.hianalytics.ab.bc.ij.ab.ab(this.de, "stat_v2_1", new String[0]);
    com.huawei.hianalytics.ab.bc.ij.ab.ab(this.de, "cached_v2_1", new String[0]);
  }
  
  public void bc(String paramString)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
    if (this.de == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "sdk is not init");
      return;
    }
    paramString = cd.ab("appID", paramString, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", this.de.getPackageName());
    com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd().hi(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.fg.ab
 * JD-Core Version:    0.7.0.1
 */