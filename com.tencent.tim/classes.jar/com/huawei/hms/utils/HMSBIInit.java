package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hianalytics.hms.HiAnalytics;
import com.huawei.hianalytics.hms.HiAnalyticsConf.Builder;

public class HMSBIInit
{
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    ResourceLoaderUtil.setmContext(paramContext.getApplicationContext());
    new HiAnalyticsConf.Builder(paramContext).setEnableImei(paramBoolean1).setEnableUDID(paramBoolean2).setEnableSN(paramBoolean3).setCollectURL(0, paramString).create();
  }
  
  public boolean isInit()
  {
    return HiAnalytics.getInitFlag();
  }
  
  public void refresh(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, boolean paramBoolean4)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    new HiAnalyticsConf.Builder(paramContext).setEnableImei(paramBoolean1).setEnableUDID(paramBoolean2).setEnableSN(paramBoolean3).setCollectURL(0, paramString).refresh(paramBoolean4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.utils.HMSBIInit
 * JD-Core Version:    0.7.0.1
 */