import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class tjt
{
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSceneFrom("QQ_official_account").setSopName(paramString).setTestId(tlv.a(9)).setPushId(tll.a().a()).setFlush(true);
  }
  
  private static void a(int paramInt, thl paramthl, boolean paramBoolean)
  {
    if ((paramthl == null) || (paramthl.jdField_a_of_type_Thp == null)) {
      return;
    }
    thp localthp = paramthl.jdField_a_of_type_Thp;
    paramthl = paramthl.jdField_a_of_type_Tho;
    long l;
    HashMap localHashMap;
    if (paramthl != null)
    {
      l = paramthl.a();
      localHashMap = new HashMap();
      localHashMap.put("event_type", paramInt + "");
      localHashMap.put("feed_id", localthp.a);
      localHashMap.put("owner_id", localthp.e);
      localHashMap.put("global_key", tee.a().a(localthp.f));
      localHashMap.put("feed_pass_key", localthp.g);
      if (paramInt == 2) {
        if (paramthl != null) {
          break label242;
        }
      }
    }
    label242:
    for (paramthl = "0";; paramthl = String.valueOf(paramthl.b(paramBoolean)))
    {
      localHashMap.put("duration", paramthl);
      localHashMap.put("last_location", String.valueOf(l));
      localHashMap.put("video_length", String.valueOf(localthp.c));
      localHashMap.put("recommend_id", "");
      localHashMap.put("poolType", String.valueOf(localthp.d));
      a(a("focus").addParams(localHashMap), "gzh_video_play");
      return;
      l = 0L;
      break;
    }
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    tlo.b("WSFollowBeaconReport", paramString + ", " + paramBuilder.getSopName() + ": " + paramBuilder.getParams().toString());
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page_type", paramString);
    a(a("focus").addParams("position", "feeds_data").addParams("feed_id", "").addParams("owner_id", "").addExtParams(localHashMap), "gzh_exposure");
  }
  
  public static void a(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString, paramInt, null, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    a(a("focus").addParams("position", "recommend_" + paramString1 + paramInt).addParams("owner_id", paramString2), "gzh_exposure");
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramInt, paramString2, null, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(a("focus").addParams("position", "recommend_" + paramString1 + paramInt).addParams("owner_id", paramString2).addParams("action_id", paramString3), "gzh_click");
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString1 = a("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("dynamics_" + paramString1 + paramInt, Integer.valueOf(paramString2).intValue(), paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString1.addExtParams(paramMap);
    }
    a(paramString1, "gzh_click");
  }
  
  public static void a(String paramString, int paramInt, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString = a("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("dynamics_" + paramString + paramInt, 0, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString.addExtParams(paramMap);
    }
    a(paramString, "gzh_exposure");
  }
  
  public static void a(thl paramthl)
  {
    a(1, paramthl, false);
  }
  
  public static void a(thl paramthl, boolean paramBoolean)
  {
    a(2, paramthl, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tjt
 * JD-Core Version:    0.7.0.1
 */