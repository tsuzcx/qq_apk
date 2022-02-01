import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class uvu
{
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = new WSStatisticsReporter.Builder().setSceneFrom("QQ_official_account").setSopName("chat_page").setTestId(uqt.a(2)).setPushId("").setFlush(true).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("content", paramInt, paramstSimpleMetaFeed)).setOperationId("").setImmediatelyUpload(uqt.c());
    HashMap localHashMap = new HashMap();
    localHashMap.put("qq_group_num", paramString);
    localHashMap.put("card_type", "1");
    paramstSimpleMetaFeed.addExtParams(localHashMap);
    a(paramstSimpleMetaFeed, "gzh_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvu
 * JD-Core Version:    0.7.0.1
 */