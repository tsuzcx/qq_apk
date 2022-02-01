import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class onf
{
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSceneFrom("QQ_official_account").setSopName(paramString).setTestId(opn.getSceneTypeTestId(9)).setPushId(oox.a().getPushId()).setFlush(true);
  }
  
  private static void a(int paramInt, ole paramole, boolean paramBoolean)
  {
    if ((paramole == null) || (paramole.a == null)) {
      return;
    }
    oli localoli = paramole.a;
    paramole = paramole.c;
    long l;
    HashMap localHashMap;
    if (paramole != null)
    {
      l = paramole.getCurrentPosition();
      localHashMap = new HashMap();
      localHashMap.put("event_type", paramInt + "");
      localHashMap.put("feed_id", localoli.id);
      localHashMap.put("owner_id", localoli.aql);
      localHashMap.put("global_key", ohy.a().fv(localoli.traceId));
      localHashMap.put("feed_pass_key", localoli.aqm);
      if (paramInt == 2) {
        if (paramole != null) {
          break label242;
        }
      }
    }
    label242:
    for (paramole = "0";; paramole = String.valueOf(paramole.e(paramBoolean)))
    {
      localHashMap.put("duration", paramole);
      localHashMap.put("last_location", String.valueOf(l));
      localHashMap.put("video_length", String.valueOf(localoli.mDuration));
      localHashMap.put("recommend_id", "");
      localHashMap.put("poolType", String.valueOf(localoli.mVideoPoolType));
      a(a("focus").addParams(localHashMap), "gzh_video_play");
      return;
      l = 0L;
      break;
    }
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    ooz.d("WSFollowBeaconReport", paramString + ", " + paramBuilder.getSopName() + ": " + paramBuilder.getParams().toString());
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString, paramInt, null, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramInt, paramString2, null, paramstSimpleMetaFeed);
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
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(a("focus").addParams("position", "recommend_" + paramString1 + paramInt).addParams("owner_id", paramString2).addParams("action_id", paramString3), "gzh_click");
  }
  
  public static void h(ole paramole, boolean paramBoolean)
  {
    a(2, paramole, paramBoolean);
  }
  
  public static void o(ole paramole)
  {
    a(1, paramole, false);
  }
  
  public static void pP(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page_type", paramString);
    a(a("focus").addParams("position", "feeds_data").addParams("feed_id", "").addParams("owner_id", "").addExtParams(localHashMap), "gzh_exposure");
  }
  
  public static void t(String paramString1, int paramInt, String paramString2)
  {
    a(a("focus").addParams("position", "recommend_" + paramString1 + paramInt).addParams("owner_id", paramString2), "gzh_exposure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onf
 * JD-Core Version:    0.7.0.1
 */