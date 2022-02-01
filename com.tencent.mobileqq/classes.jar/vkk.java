import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.qphone.base.BaseConstants;
import java.util.HashMap;
import org.json.JSONObject;

public class vkk
{
  private static volatile vkk jdField_a_of_type_Vkk;
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
  
  private WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setSendWeSeeServer(false).setFlush(true);
  }
  
  /* Error */
  public static vkk a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 57	vkk:jdField_a_of_type_Vkk	Lvkk;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 57	vkk:jdField_a_of_type_Vkk	Lvkk;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	vkk
    //   21: dup
    //   22: invokespecial 58	vkk:<init>	()V
    //   25: putstatic 57	vkk:jdField_a_of_type_Vkk	Lvkk;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 57	vkk:jdField_a_of_type_Vkk	Lvkk;
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
    //   34	5	0	localvkk	vkk
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
  
  private void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  private void b(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
    localHashMap.put("sopName", String.valueOf(paramString1));
    if ("fullscreen_videoplay".equals(paramString1))
    {
      localHashMap.put("actWsPageFrom", "" + paramString2);
      vmp.c("WsBeaconReportPresenter", "只在播放页上报actWsPageFrom");
    }
    localHashMap.put("type", "4");
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    vmp.d("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
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
        break label188;
      }
      localHashMap.put("actWsFeedIsJumpToWeiShi", "true");
    }
    for (;;)
    {
      if (paramInt2 == 2) {
        localHashMap.put("actWsRecommendPageType", "1");
      }
      a(a().addParams(localHashMap), "actWsGzhFeedUserConsumption");
      vmp.c("WsBeaconReportPresenter", "reportFallListExit{ stayTime:" + paramLong1 + ",loadTime:" + paramLong2 + ",exposeCount:" + paramInt1 + ",hasClickFuceng:" + paramBoolean1 + ",hasClickWeishi:" + paramBoolean2);
      vmr.a = false;
      return;
      localHashMap.put("actWsFeedIsJumpToPlayPage", "false");
      break;
      label188:
      localHashMap.put("actWsFeedIsJumpToWeiShi", "false");
    }
  }
  
  public void a(long paramLong, vfo paramvfo, int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    String str;
    if (paramvfo != null)
    {
      str = paramvfo.d();
      localHashMap.put("actWsReqName", str);
      if (paramvfo == null) {
        break label210;
      }
      str = String.valueOf(paramvfo.b());
      label54:
      localHashMap.put("actWsReqScene", str);
      if (paramvfo == null) {
        break label217;
      }
      str = String.valueOf(paramvfo.d);
      label77:
      localHashMap.put("actWsReqRspSize", str);
      if (paramvfo == null) {
        break label224;
      }
    }
    label210:
    label217:
    label224:
    for (paramvfo = String.valueOf(paramvfo.c);; paramvfo = "")
    {
      localHashMap.put("actWsReqNetDuration", paramvfo);
      localHashMap.put("actWsReqErrorCode", String.valueOf(paramInt));
      localHashMap.put("actWsReqErrorMsg", paramString);
      localHashMap.put("type", "5");
      a(a().addParams(localHashMap), "actWsGzhPerformance");
      vmp.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
      return;
      str = "";
      break;
      str = "";
      break label54;
      str = "";
      break label77;
    }
  }
  
  public void a(long paramLong, vfo paramvfo, String paramString, boolean paramBoolean)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    Object localObject;
    if (paramvfo != null)
    {
      localObject = paramvfo.d();
      localHashMap.put("actWsReqName", localObject);
      if (paramvfo == null) {
        break label252;
      }
      localObject = String.valueOf(paramvfo.b());
      label63:
      localHashMap.put("actWsReqScene", localObject);
      if (paramvfo == null) {
        break label259;
      }
      localObject = String.valueOf(paramvfo.d);
      label86:
      localHashMap.put("actWsReqRspSize", localObject);
      if (paramvfo == null) {
        break label266;
      }
      localObject = String.valueOf(paramvfo.c);
      label109:
      localHashMap.put("actWsReqNetDuration", localObject);
      localHashMap.put("type", "2");
      if (paramBoolean)
      {
        localObject = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (localObject != null) {
          break label273;
        }
        label153:
        localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
        if (paramvfo == null) {
          break label284;
        }
      }
    }
    label259:
    label266:
    label273:
    label284:
    for (paramvfo = paramvfo.d();; paramvfo = "")
    {
      b(true, paramLong, paramString, paramvfo);
      a(a().addParams(localHashMap), "actWsGzhPerformance");
      vmp.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
      return;
      localObject = "";
      break;
      label252:
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
    a(a().addParams(localHashMap), "actWsGzhFeedPerformance");
    vmp.a("WsBeaconReportPresenter", "reportRecommendReportFail：" + paramHashMap.toString());
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 5000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("actWsFeedPageLoadDuration", "" + paramLong);
    a(a().addParams(localHashMap), "actWsGzhFeedPerformance");
    Log.w("WsBeaconReportPresenter", " actWsFeedPageLoadDuration=" + paramLong);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    paramLong1 = a(paramLong1, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedPicReqDuration", "" + paramLong1);
    localHashMap.put("actWsFeedPicBytes", "" + paramLong2);
    Log.i("actWsGzhFeedPerformance", "actWsFeedPicBytes=" + paramLong2);
    a(a().addParams(localHashMap), "actWsGzhFeedPerformance");
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
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    vmp.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
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
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    vmp.d("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsPlayPageLoadDuration", "" + paramLong);
    a(a().addParams(localHashMap), "actWsGzhFeedPerformance");
    Log.w("WsBeaconReportPresenter", "actWsPlayPageLoadDuration=" + paramLong);
  }
  
  public void c(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSFeedListReqDuration", "" + paramLong);
    a(a().addParams(localHashMap), "actWsGzhFeedPerformance");
    Log.w("WsBeaconReportPresenter", "actWSFeedListReqDuration=" + paramLong);
  }
  
  public void d(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedNotificationReqDuration", "" + paramLong);
    a(a().addParams(localHashMap), "actWsGzhFeedPerformance");
    Log.w("WsBeaconReportPresenter", "actWsFeedNotificationReqDuration=" + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkk
 * JD-Core Version:    0.7.0.1
 */