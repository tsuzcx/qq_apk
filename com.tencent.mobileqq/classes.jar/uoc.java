import android.util.Log;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import org.json.JSONObject;

public class uoc
{
  private static uoc jdField_a_of_type_Uoc;
  public static boolean a;
  HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private uoc()
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = true;
    }
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2)
    {
      Log.w("weishi-beacon", "request is more than " + paramLong2);
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static uoc a()
  {
    try
    {
      if (jdField_a_of_type_Uoc == null) {
        jdField_a_of_type_Uoc = new uoc();
      }
      uoc localuoc = jdField_a_of_type_Uoc;
      return localuoc;
    }
    finally {}
  }
  
  private void b(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
    localHashMap.put("sopName", String.valueOf(paramString1));
    if ("fullscreen_videoplay".equals(paramString1))
    {
      localHashMap.put("actWsPageFrom", "" + paramString2);
      uqf.c("WsBeaconReportPresenter", "只在播放页上报actWsPageFrom");
    }
    localHashMap.put("type", "4");
    bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    uqf.d("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedUserUsageDuration", String.valueOf(paramLong1));
    localHashMap.put("actWsFeedListFirstReqDuration", String.valueOf(paramLong2));
    localHashMap.put("actWsFeedCoverExposureNum", String.valueOf(paramInt1));
    if (paramBoolean1)
    {
      localHashMap.put("actWsFeedIsJumpToPlayPage", "true");
      if (!paramBoolean2) {
        break label192;
      }
      localHashMap.put("actWsFeedIsJumpToWeiShi", "true");
    }
    for (;;)
    {
      if (paramInt2 == 2) {
        localHashMap.put("actWsRecommendPageType", "1");
      }
      bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhFeedUserConsumption", true, 0L, 0L, localHashMap, "");
      uqf.c("WsBeaconReportPresenter", "reportFallListExit{ stayTime:" + paramLong1 + ",loadTime:" + paramLong2 + ",exposeCount:" + paramInt1 + ",hasClickFuceng:" + paramBoolean1 + ",hasClickWeishi:" + paramBoolean2);
      uqh.jdField_a_of_type_Boolean = false;
      return;
      localHashMap.put("actWsFeedIsJumpToPlayPage", "false");
      break;
      label192:
      localHashMap.put("actWsFeedIsJumpToWeiShi", "false");
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("recommend_report_fail", new JSONObject(paramHashMap).toString());
    bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", true, 0L, 0L, (HashMap)localObject, "", true);
    localObject = new StringBuilder().append("reportRecommendReportFail：");
    if (paramHashMap != null) {}
    for (paramHashMap = paramHashMap.toString();; paramHashMap = "")
    {
      uqf.a("WsBeaconReportPresenter", paramHashMap);
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 5000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("actWsFeedPageLoadDuration", "" + paramLong);
    bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("WsBeaconReportPresenter", " actWsFeedPageLoadDuration=" + paramLong);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    paramLong1 = a(paramLong1, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedPicReqDuration", "" + paramLong1);
    localHashMap.put("actWsFeedPicBytes", "" + paramLong2);
    Log.i("actWsGzhFeedPerformance", "actWsFeedPicBytes=" + paramLong2);
    bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.i("WsBeaconReportPresenter", "actWsFeedPicReqDuration=" + paramLong1);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    paramLong1 = a(paramLong1, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsPicReqDuration", "" + paramLong1);
    localHashMap.put("actWsPicBytes", "" + paramLong2);
    localHashMap.put("sopName", "" + paramString2);
    localHashMap.put("actWsPicUrl", "" + paramString1);
    localHashMap.put("type", "3");
    bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    uqf.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString1, int paramInt, String paramString2, boolean paramBoolean2)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    localHashMap.put("actWsReqName", paramString1);
    localHashMap.put("actWsReqScene ", String.valueOf(paramInt));
    localHashMap.put("type", "2");
    Long localLong;
    if (paramBoolean2)
    {
      localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
      if (localLong != null) {
        break label175;
      }
    }
    for (;;)
    {
      localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
      b(true, paramLong, paramString2, paramString1);
      bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhPerformance", paramBoolean1, 0L, 0L, localHashMap, "");
      uqf.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
      return;
      label175:
      paramLong += localLong.longValue();
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    paramLong = a(paramLong, 5000L);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, Long.valueOf(paramLong));
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("actWsPageLoadDuration", String.valueOf(paramLong));
    localHashMap.put("sopName", String.valueOf(paramString1));
    localHashMap.put("actWsPageFrom", String.valueOf(paramString2));
    localHashMap.put("type", "1");
    bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    uqf.d("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsPlayPageLoadDuration", "" + paramLong);
    bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("WsBeaconReportPresenter", "actWsPlayPageLoadDuration=" + paramLong);
  }
  
  public void c(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSFeedListReqDuration", "" + paramLong);
    bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("WsBeaconReportPresenter", "actWSFeedListReqDuration=" + paramLong);
  }
  
  public void d(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedNotificationReqDuration", "" + paramLong);
    bdmc.a(BaseApplication.getContext()).a(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("WsBeaconReportPresenter", "actWsFeedNotificationReqDuration=" + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoc
 * JD-Core Version:    0.7.0.1
 */