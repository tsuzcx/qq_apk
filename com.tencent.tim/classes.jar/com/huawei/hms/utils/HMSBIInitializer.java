package com.huawei.hms.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.hms.HiAnalytics;
import com.huawei.hianalytics.hms.HiAnalyticsConf.Builder;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;

public class HMSBIInitializer
{
  private static final Object a = new Object();
  private static final Object b = new Object();
  private static HMSBIInitializer c;
  private final Context d;
  private HiAnalyticsConf.Builder e;
  
  private HMSBIInitializer(Context paramContext)
  {
    this.d = paramContext;
    this.e = new HiAnalyticsConf.Builder(this.d);
  }
  
  public static HMSBIInitializer getInstance(Context paramContext)
  {
    synchronized (a)
    {
      if (c == null) {
        c = new HMSBIInitializer(paramContext.getApplicationContext());
      }
      return c;
    }
  }
  
  public void initBI()
  {
    synchronized (b)
    {
      boolean bool = HiAnalytics.getInitFlag();
      HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + bool);
      if (bool) {
        return;
      }
      bool = Util.getBiSetting(this.d);
      HMSLog.i("HMSBIInitializer", "Builder->biSetting :" + bool);
      if (bool) {
        return;
      }
    }
    String str = new a(this.d, false).a();
    if (TextUtils.isEmpty(str)) {}
    for (str = "CN"; "UNKNOWN".equalsIgnoreCase(str); str = str.toUpperCase(Locale.ENGLISH))
    {
      HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
      return;
    }
    GrsBaseInfo localGrsBaseInfo = new GrsBaseInfo();
    localGrsBaseInfo.setIssueCountry(str);
    new GrsClient(this.d, localGrsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOT", new HMSBIInitializer.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.utils.HMSBIInitializer
 * JD-Core Version:    0.7.0.1
 */