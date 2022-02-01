package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.landing_page_collect_data.LandingPageCollectData;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.version.AdVersion;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;

public class a
{
  public static final int ACTION_LANDINGPAGE_APP_DATA_FAILED = 37;
  public static final int ACTION_LANDINGPAGE_APP_DATA_SUCCESS = 36;
  public static final int ACTION_MOBILEAPP_AD_APP_DOWN_PAUSED = 238;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_ALREADY_DOWNLOAD = 270;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_AUTO_CREATE_DOWNLOAD = 269;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_CONTINUE_DOWNLOAD = 271;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_FINISH_DOWNLOAD = 274;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_MATCH = 275;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_NOT_MATCH = 276;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_UNKNOWN_MATCH = 284;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_MANUAL_CREATE_DOWNLOAD = 268;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_NEW_DOWNLOAD = 272;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_PAUSE_DOWNLOAD = 273;
  private static final String TAG = "AdReportForAction";
  
  public static void report(a parama)
  {
    if ((parama == null) || (!parama.isValid()))
    {
      AdLog.e("AdReportForAction", "report error");
      return;
    }
    Object localObject1 = parama.ad.getUrlForAction();
    try
    {
      Object localObject2 = ((String)localObject1).replace("__TRACE_ID__", URLEncoder.encode(parama.ad.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(parama.data.landing_page_action_type));
      localObject1 = localObject2;
      if (parama.data.latency_ms != -2147483648L) {
        localObject1 = ((String)localObject2).replace("__PAGE_TIME__", String.valueOf(parama.data.latency_ms));
      }
      localObject2 = localObject1;
      if (parama.data.landing_error_code != -2147483648) {
        localObject2 = ((String)localObject1).replace("__LANDING_ERROR_CODE__", String.valueOf(parama.data.landing_error_code));
      }
      parama = ((String)localObject2).replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(AdVersion.getAppVersion(), "utf-8"));
      AdLog.i("AdReportForAction", "GdtActionReporter report url = " + parama);
      AdThreadManager.INSTANCE.post(new a.1(parama), 4);
      return;
    }
    catch (UnsupportedEncodingException parama)
    {
      AdLog.e("AdReportForAction", "report error", parama);
    }
  }
  
  public static class a
  {
    public Ad ad;
    public WeakReference<Context> context;
    public landing_page_collect_data.LandingPageCollectData data = new landing_page_collect_data.LandingPageCollectData();
    
    public boolean isValid()
    {
      return (this.ad != null) && (this.context != null) && (this.context.get() != null) && (!TextUtils.isEmpty(this.ad.getUrlForAction())) && (!TextUtils.isEmpty(this.ad.getTraceId())) && (this.data != null) && (this.data.landing_page_action_type != 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.a
 * JD-Core Version:    0.7.0.1
 */