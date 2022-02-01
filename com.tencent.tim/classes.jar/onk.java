import android.util.Log;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class onk
{
  private static onk a;
  public static boolean isInit;
  HashMap<String, Long> eN = new HashMap();
  
  private onk()
  {
    if (!isInit) {
      isInit = true;
    }
  }
  
  public static onk a()
  {
    try
    {
      if (a == null) {
        a = new onk();
      }
      onk localonk = a;
      return localonk;
    }
    finally {}
  }
  
  private void b(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
    localHashMap.put("sopName", String.valueOf(paramString1));
    if ("fullscreen_videoPlay".equals(paramString1))
    {
      localHashMap.put("actWsPageFrom", "" + paramString2);
      ooz.w("weishi-beacon", "只在播放页上报actWsPageFrom");
    }
    localHashMap.put("type", "4");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWsGzhPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    ooz.e("weishi-beacon", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
  }
  
  private long d(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2)
    {
      Log.w("weishi-beacon", "request is more than " + paramLong2);
      return paramLong2;
    }
    return paramLong1;
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedUserUsageDuration", String.valueOf(paramLong1));
    localHashMap.put("actWsFeedListFirstReqDuration", String.valueOf(paramLong2));
    localHashMap.put("actWsFeedCoverExposureNum", String.valueOf(paramInt));
    if (paramBoolean1)
    {
      localHashMap.put("actWsFeedIsJumpToPlayPage", "true");
      if (!paramBoolean2) {
        break label177;
      }
      localHashMap.put("actWsFeedIsJumpToWeiShi", "true");
    }
    for (;;)
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedUserConsumption", true, 0L, 0L, localHashMap, "");
      Log.w("weishi-beacon", "reportFallListExit{ stayTime:" + paramLong1 + ",loadTime:" + paramLong2 + ",exposeCount:" + paramInt + ",hasClickFuceng:" + paramBoolean1 + ",hasClickWeishi:" + paramBoolean2);
      opb.axV = false;
      return;
      localHashMap.put("actWsFeedIsJumpToPlayPage", "false");
      break;
      label177:
      localHashMap.put("actWsFeedIsJumpToWeiShi", "false");
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    paramLong1 = d(paramLong1, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedPicReqDuration", "" + paramLong1);
    localHashMap.put("actWsFeedPicBytes", "" + paramLong2);
    Log.i("actWsGzhFeedPerformance", "actWsFeedPicBytes=" + paramLong2);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.i("weishi-beacon", "actWsFeedPicReqDuration=" + paramLong1);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    paramLong1 = d(paramLong1, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsPicReqDuration", "" + paramLong1);
    localHashMap.put("actWsPicBytes", "" + paramLong2);
    localHashMap.put("sopName", "" + paramString2);
    localHashMap.put("actWsPicUrl", "" + paramString1);
    localHashMap.put("type", "3");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWsGzhPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    ooz.w("weishi-beacon", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString1, int paramInt, String paramString2, boolean paramBoolean2)
  {
    paramLong = d(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    localHashMap.put("actWsReqName", paramString1);
    localHashMap.put("actWsReqScene ", String.valueOf(paramInt));
    localHashMap.put("type", "2");
    Long localLong;
    if (paramBoolean2)
    {
      localLong = (Long)this.eN.get(paramString2);
      if (localLong != null) {
        break label175;
      }
    }
    for (;;)
    {
      localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
      b(true, paramLong, paramString2, paramString1);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWsGzhPerformance", paramBoolean1, 0L, 0L, localHashMap, "");
      ooz.w("weishi-beacon", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
      return;
      label175:
      paramLong += localLong.longValue();
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    paramLong = d(paramLong, 5000L);
    this.eN.put(paramString1, Long.valueOf(paramLong));
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("actWsPageLoadDuration", String.valueOf(paramLong));
    localHashMap.put("sopName", String.valueOf(paramString1));
    localHashMap.put("actWsPageFrom", String.valueOf(paramString2));
    localHashMap.put("type", "1");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWsGzhPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    ooz.e("weishi-beacon", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
  }
  
  public void reportVideoPluginInit(boolean paramBoolean, long paramLong)
  {
    paramLong = d(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsPlayPageLoadDuration", "" + paramLong);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("weishi-beacon", "actWsPlayPageLoadDuration=" + paramLong);
  }
  
  public void s(boolean paramBoolean, long paramLong)
  {
    paramLong = d(paramLong, 5000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("actWsFeedPageLoadDuration", "" + paramLong);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("weishi-beacon", " actWsFeedPageLoadDuration=" + paramLong);
  }
  
  public void t(boolean paramBoolean, long paramLong)
  {
    paramLong = d(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSFeedListReqDuration", "" + paramLong);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("weishi-beacon", "actWSFeedListReqDuration=" + paramLong);
  }
  
  public void u(boolean paramBoolean, long paramLong)
  {
    paramLong = d(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedNotificationReqDuration", "" + paramLong);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("weishi-beacon", "actWsFeedNotificationReqDuration=" + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onk
 * JD-Core Version:    0.7.0.1
 */