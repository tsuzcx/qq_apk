import android.util.Log;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import org.json.JSONObject;

public class uvw
{
  private static volatile uvw jdField_a_of_type_Uvw;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private long a(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2)
    {
      Log.w("weishi-beacon", "request is more than " + paramLong2);
      return paramLong2;
    }
    return paramLong1;
  }
  
  /* Error */
  public static uvw a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 46	uvw:jdField_a_of_type_Uvw	Luvw;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 46	uvw:jdField_a_of_type_Uvw	Luvw;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	uvw
    //   21: dup
    //   22: invokespecial 47	uvw:<init>	()V
    //   25: putstatic 46	uvw:jdField_a_of_type_Uvw	Luvw;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 46	uvw:jdField_a_of_type_Uvw	Luvw;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localuvw	uvw
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private void b(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
    localHashMap.put("sopName", String.valueOf(paramString1));
    if ("fullscreen_videoplay".equals(paramString1))
    {
      localHashMap.put("actWsPageFrom", "" + paramString2);
      uya.c("WsBeaconReportPresenter", "只在播放页上报actWsPageFrom");
    }
    localHashMap.put("type", "4");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    uya.d("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
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
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedUserConsumption", true, 0L, 0L, localHashMap, "");
      uya.c("WsBeaconReportPresenter", "reportFallListExit{ stayTime:" + paramLong1 + ",loadTime:" + paramLong2 + ",exposeCount:" + paramInt1 + ",hasClickFuceng:" + paramBoolean1 + ",hasClickWeishi:" + paramBoolean2);
      uyc.a = false;
      return;
      localHashMap.put("actWsFeedIsJumpToPlayPage", "false");
      break;
      label192:
      localHashMap.put("actWsFeedIsJumpToWeiShi", "false");
    }
  }
  
  public void a(long paramLong, urg paramurg, int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    String str;
    if (paramurg != null)
    {
      str = paramurg.d();
      localHashMap.put("actWsReqName", str);
      if (paramurg == null) {
        break label214;
      }
      str = String.valueOf(paramurg.b());
      label54:
      localHashMap.put("actWsReqScene", str);
      if (paramurg == null) {
        break label221;
      }
      str = String.valueOf(paramurg.d);
      label77:
      localHashMap.put("actWsReqRspSize", str);
      if (paramurg == null) {
        break label228;
      }
    }
    label214:
    label221:
    label228:
    for (paramurg = String.valueOf(paramurg.c);; paramurg = "")
    {
      localHashMap.put("actWsReqNetDuration", paramurg);
      localHashMap.put("actWsReqErrorCode", String.valueOf(paramInt));
      localHashMap.put("actWsReqErrorMsg", paramString);
      localHashMap.put("type", "5");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhPerformance", true, 0L, 0L, localHashMap, "");
      uya.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
      return;
      str = "";
      break;
      str = "";
      break label54;
      str = "";
      break label77;
    }
  }
  
  public void a(long paramLong, urg paramurg, String paramString, boolean paramBoolean)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    Object localObject;
    if (paramurg != null)
    {
      localObject = paramurg.d();
      localHashMap.put("actWsReqName", localObject);
      if (paramurg == null) {
        break label256;
      }
      localObject = String.valueOf(paramurg.b());
      label63:
      localHashMap.put("actWsReqScene", localObject);
      if (paramurg == null) {
        break label263;
      }
      localObject = String.valueOf(paramurg.d);
      label86:
      localHashMap.put("actWsReqRspSize", localObject);
      if (paramurg == null) {
        break label270;
      }
      localObject = String.valueOf(paramurg.c);
      label109:
      localHashMap.put("actWsReqNetDuration", localObject);
      localHashMap.put("type", "2");
      if (paramBoolean)
      {
        localObject = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (localObject != null) {
          break label277;
        }
        label153:
        localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
        if (paramurg == null) {
          break label288;
        }
      }
    }
    label256:
    label263:
    label270:
    label277:
    label288:
    for (paramurg = paramurg.d();; paramurg = "")
    {
      b(true, paramLong, paramString, paramurg);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhPerformance", true, 0L, 0L, localHashMap, "");
      uya.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
      return;
      localObject = "";
      break;
      localObject = "";
      break label63;
      localObject = "";
      break label86;
      localObject = "";
      break label109;
      paramLong += ((Long)localObject).longValue();
      break label153;
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("recommend_report_fail", new JSONObject(paramHashMap).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", true, 0L, 0L, localHashMap, "", true);
    uya.a("WsBeaconReportPresenter", "reportRecommendReportFail：" + paramHashMap.toString());
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 5000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("actWsFeedPageLoadDuration", "" + paramLong);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("WsBeaconReportPresenter", " actWsFeedPageLoadDuration=" + paramLong);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    paramLong1 = a(paramLong1, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedPicReqDuration", "" + paramLong1);
    localHashMap.put("actWsFeedPicBytes", "" + paramLong2);
    Log.i("actWsGzhFeedPerformance", "actWsFeedPicBytes=" + paramLong2);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
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
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    uya.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
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
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    uya.d("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsPlayPageLoadDuration", "" + paramLong);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("WsBeaconReportPresenter", "actWsPlayPageLoadDuration=" + paramLong);
  }
  
  public void c(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSFeedListReqDuration", "" + paramLong);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("WsBeaconReportPresenter", "actWSFeedListReqDuration=" + paramLong);
  }
  
  public void d(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedNotificationReqDuration", "" + paramLong);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWsGzhFeedPerformance", paramBoolean, 0L, 0L, localHashMap, "");
    Log.w("WsBeaconReportPresenter", "actWsFeedNotificationReqDuration=" + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvw
 * JD-Core Version:    0.7.0.1
 */