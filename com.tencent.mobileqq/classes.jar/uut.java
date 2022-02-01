import UserGrowth.stCollection;
import UserGrowth.stJumpInfo;
import UserGrowth.stNewIconStyle;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;

public class uut
{
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    if (TextUtils.equals(paramString, "follow_tab"))
    {
      String str2 = ups.a(10);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {}
    }
    for (String str1 = ups.a(9);; str1 = ups.a(urc.a(paramString))) {
      return new WSStatisticsReporter.Builder().setSceneFrom(b(paramString)).setSopName(a(paramString)).setTestId(str1).setPushId(upb.a().a()).setFlush(true).setImmediatelyUpload(ups.c());
    }
  }
  
  private static String a(stOpVideo paramstOpVideo)
  {
    if (paramstOpVideo != null) {
      return String.valueOf(paramstOpVideo.videoType);
    }
    return String.valueOf(0);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return "feeds_fullscreen";
    }
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return "second_fullscreen_videoplay";
    }
    return "fullscreen_videoplay";
  }
  
  public static void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "gamevideo.save", paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "gamevideo.save", paramstSimpleMetaFeed, "", null);
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stJumpInfo paramstJumpInfo)
  {
    if (paramstJumpInfo == null) {
      return;
    }
    Map localMap = WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("blockpage", paramInt);
    localMap.put("global_key", ugb.a().a(paramstJumpInfo.trace_id));
    HashMap localHashMap = new HashMap();
    localHashMap.put("play_scene", paramString2);
    if (paramstJumpInfo.mapExt != null) {
      localHashMap.putAll(paramstJumpInfo.mapExt);
    }
    a(a(paramString1).addParams(localMap).addExtParams(localHashMap).setOperationId(String.valueOf(paramstJumpInfo.id)), "gzh_click");
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    Object localObject = paramstSimpleMetaFeed.opVideo;
    String str = "fullscreen_videoplay_video" + (paramInt + 1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("poolType", String.valueOf(paramstSimpleMetaFeed.videoPoolType));
    localHashMap.put("type", String.valueOf(paramstSimpleMetaFeed.video_type));
    localHashMap.put("opvideo_type", a((stOpVideo)localObject));
    localHashMap.put("material_type", a((stOpVideo)localObject));
    localHashMap.put("cover_type", ups.b(paramstSimpleMetaFeed, false));
    localObject = WSPublicAccReport.getInstance().getRecommendFullScreenInfo();
    if ((paramInt == 0) && (((umv)localObject).a()))
    {
      localHashMap.put("is_cache_info", String.valueOf(((umv)localObject).b()));
      localHashMap.put("is_cache_file", String.valueOf(((umv)localObject).a()));
      localHashMap.put("exp_duration", String.valueOf(((umv)localObject).a()));
    }
    a(paramString1, paramString2, str, paramstSimpleMetaFeed, "", localHashMap);
  }
  
  private static void a(String paramString1, String paramString2, int paramInt, ukb paramukb, boolean paramBoolean)
  {
    if ((paramukb == null) || (paramukb.jdField_a_of_type_Ukf == null)) {
      return;
    }
    ukf localukf = paramukb.jdField_a_of_type_Ukf;
    paramukb = paramukb.jdField_a_of_type_Uke;
    long l;
    HashMap localHashMap;
    if (paramukb != null)
    {
      l = paramukb.a();
      localHashMap = new HashMap();
      localHashMap.put("event_type", paramInt + "");
      localHashMap.put("feed_id", localukf.a);
      localHashMap.put("owner_id", localukf.jdField_e_of_type_JavaLangString);
      if (paramInt == 2) {
        if (paramukb != null) {
          break label332;
        }
      }
    }
    label332:
    for (paramukb = "0";; paramukb = String.valueOf(paramukb.b(paramBoolean)))
    {
      localHashMap.put("duration", paramukb);
      localHashMap.put("last_location", String.valueOf(l));
      localHashMap.put("video_length", String.valueOf(localukf.jdField_c_of_type_Int));
      localHashMap.put("recommend_id", "");
      localHashMap.put("poolType", String.valueOf(localukf.d));
      localHashMap.put("global_key", ugb.a().a(localukf.jdField_f_of_type_JavaLangString));
      localHashMap.put("feed_pass_key", localukf.g);
      paramukb = new HashMap();
      paramukb.put("type", String.valueOf(localukf.jdField_e_of_type_Int));
      paramukb.put("cover_type", ups.c(localukf.jdField_c_of_type_JavaLangString));
      paramukb.put("material_type", String.valueOf(localukf.jdField_f_of_type_Int));
      paramukb.put("play_scene", paramString2);
      a(a(paramString1).addParams(localHashMap).addExtParams(paramukb).setOperationId(""), "gzh_video_play");
      return;
      l = 0L;
      break;
    }
  }
  
  public static void a(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (stNewIconStyle localstNewIconStyle = paramstSimpleMetaFeed.new_icon; localstNewIconStyle == null; localstNewIconStyle = null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", localstNewIconStyle.tag_type + "");
    a(paramString1, paramString2, "videoplay_tag", paramstSimpleMetaFeed, String.valueOf(localstNewIconStyle.id), localHashMap);
  }
  
  public static void a(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (stCollection localstCollection = paramstSimpleMetaFeed.collection; (localstCollection == null) || (TextUtils.isEmpty(localstCollection.cid)); localstCollection = null) {
      return;
    }
    a(paramString1, paramString2, "function_entrance", paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, paramString3, paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString4, Map<String, String> paramMap)
  {
    paramString3 = a(paramString1).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString3, paramInt, paramstSimpleMetaFeed)).setOperationId(paramString4);
    paramString1 = paramMap;
    if (paramMap == null) {
      paramString1 = new HashMap();
    }
    paramString1.put("play_scene", paramString2);
    paramString3.addExtParams(paramString1);
    a(paramString3, "gzh_click");
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString4, Map<String, String> paramMap)
  {
    paramString3 = a(paramString1).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString3, 0, paramstSimpleMetaFeed)).setOperationId(paramString4);
    paramString1 = paramMap;
    if (paramMap == null) {
      paramString1 = new HashMap();
    }
    paramString1.put("play_scene", paramString2);
    paramString3.addExtParams(paramString1);
    a(paramString3, "gzh_exposure");
  }
  
  public static void a(String paramString1, String paramString2, ukb paramukb)
  {
    a(paramString1, paramString2, 1, paramukb, false);
  }
  
  public static void a(String paramString1, String paramString2, ukb paramukb, boolean paramBoolean)
  {
    a(paramString1, paramString2, 2, paramukb, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramBoolean)
    {
      a(paramString1, paramString2, "like", paramstSimpleMetaFeed, 1001001, "", null);
      return;
    }
    a(paramString1, paramString2, "like", paramstSimpleMetaFeed, 1001002, "", null);
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.equals(paramString, "trends")) {
      return "weishi_share_trendstab";
    }
    return "QQ_official_account";
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "forward", paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  public static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (TextUtils.equals(paramString1, "vertical_layer_collection")) {}
    for (;;)
    {
      return;
      if (paramstSimpleMetaFeed != null) {}
      for (stCollection localstCollection = paramstSimpleMetaFeed.collection; (localstCollection != null) && (!TextUtils.isEmpty(localstCollection.cid)); localstCollection = null)
      {
        a(paramString1, paramString2, "function_entrance", paramstSimpleMetaFeed, "", null);
        return;
      }
    }
  }
  
  public static void c(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "profile", paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  public static void c(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "like", paramstSimpleMetaFeed, 1001003, "", null);
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (stNewIconStyle localstNewIconStyle = paramstSimpleMetaFeed.new_icon; localstNewIconStyle == null; localstNewIconStyle = null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", localstNewIconStyle.tag_type + "");
    a(paramString1, paramString2, "videoplay_tag", paramstSimpleMetaFeed, paramInt, String.valueOf(localstNewIconStyle.id), localHashMap);
  }
  
  public static void d(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    HashMap localHashMap = new HashMap();
    if (paramstSimpleMetaFeed != null) {}
    for (String str = a(paramstSimpleMetaFeed.opVideo);; str = "0")
    {
      localHashMap.put("material_type", str);
      a(paramString1, paramString2, "more_operations", paramstSimpleMetaFeed, 1000001, "", localHashMap);
      return;
    }
  }
  
  public static void e(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "home_icon", paramstSimpleMetaFeed, 1000001, "", null);
  }
  
  public static void f(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "follow", paramstSimpleMetaFeed, 1004001, "", null);
  }
  
  public static void g(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (!zmi.a(BaseApplicationImpl.getApplication())) {}
    for (int i = 1000002;; i = 1000003)
    {
      a(paramString1, paramString2, "video_title", paramstSimpleMetaFeed, i, "", null);
      return;
    }
  }
  
  public static void h(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "comment_entry", paramstSimpleMetaFeed, 1000001, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uut
 * JD-Core Version:    0.7.0.1
 */