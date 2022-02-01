import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class uvk
{
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSceneFrom("QQ_official_account").setSopName(paramString).setTestId("").setPushId("").setFlush(true).setImmediatelyUpload(true);
  }
  
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", "10");
    localHashMap.put("operation_or_not", String.valueOf(paramInt));
    a(a("").addParams(localHashMap), "gzh_action");
  }
  
  public static void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    Map localMap = WSPublicAccReport.getInstance().getFeedsBaseParams("opcard_new", paramInt, paramstSimpleMetaFeed);
    Object localObject3 = null;
    HashMap localHashMap = new HashMap();
    Object localObject2 = localHashMap;
    Object localObject1 = localObject3;
    if (paramstSimpleMetaFeed != null)
    {
      localObject2 = localHashMap;
      localObject1 = localObject3;
      if (paramstSimpleMetaFeed.h5_op_info != null)
      {
        localObject1 = paramstSimpleMetaFeed.h5_op_info;
        localObject2 = ((stH5OpInfo)localObject1).exp;
      }
    }
    localObject2 = a("feeds").addParams(localMap).addExtParams((Map)localObject2);
    if (localObject1 != null) {}
    for (paramstSimpleMetaFeed = String.valueOf(((stH5OpInfo)localObject1).id);; paramstSimpleMetaFeed = "")
    {
      a(((WSStatisticsReporter.Builder)localObject2).setOperationId(paramstSimpleMetaFeed), "gzh_exposure");
      return;
    }
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(a("feeds").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("feeds_data_new", 0, paramstSimpleMetaFeed)).addExtParams(paramMap), "gzh_exposure");
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvk
 * JD-Core Version:    0.7.0.1
 */