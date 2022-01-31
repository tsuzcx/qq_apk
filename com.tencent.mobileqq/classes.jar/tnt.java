import UserGrowth.stNewIconStyle;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;

public class tnt
{
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString;
  private static String b;
  
  private static WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setSceneFrom(jdField_a_of_type_JavaLangString).setSopName("fullscreen_videoplay").setTestId(tlv.a(jdField_a_of_type_Int)).setPushId(tll.a().a()).setFlush(true);
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaLangString = "";
    b = "";
  }
  
  public static void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    Object localObject1 = paramstSimpleMetaFeed.opVideo;
    Object localObject2 = paramstSimpleMetaFeed.poster;
    String str = "fullscreen_videoplay_video" + (paramInt + 1);
    if (localObject2 != null)
    {
      localObject2 = ((stSimpleMetaPerson)localObject2).id;
      localObject2 = new HashMap();
      ((Map)localObject2).put("poolType", String.valueOf(paramstSimpleMetaFeed.videoPoolType));
      ((Map)localObject2).put("type", String.valueOf(paramstSimpleMetaFeed.video_type));
      if (localObject1 == null) {
        break label144;
      }
    }
    label144:
    for (localObject1 = String.valueOf(((stOpVideo)localObject1).videoType);; localObject1 = "")
    {
      ((Map)localObject2).put("opvideo_type", localObject1);
      ((Map)localObject2).put("cover_type", tlv.b(paramstSimpleMetaFeed, false));
      a(str, paramstSimpleMetaFeed, "", (Map)localObject2);
      return;
      break;
    }
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
      localHashMap.put("feed_id", localthp.jdField_a_of_type_JavaLangString);
      localHashMap.put("owner_id", localthp.jdField_e_of_type_JavaLangString);
      if (paramInt == 2) {
        if (paramthl != null) {
          break label303;
        }
      }
    }
    label303:
    for (paramthl = "0";; paramthl = String.valueOf(paramthl.b(paramBoolean)))
    {
      localHashMap.put("duration", paramthl);
      localHashMap.put("last_location", String.valueOf(l));
      localHashMap.put("video_length", String.valueOf(localthp.jdField_c_of_type_Int));
      localHashMap.put("recommend_id", "");
      localHashMap.put("poolType", String.valueOf(localthp.d));
      localHashMap.put("global_key", tee.a().a(localthp.f));
      localHashMap.put("feed_pass_key", localthp.g);
      paramthl = new HashMap();
      paramthl.put("type", String.valueOf(localthp.jdField_e_of_type_Int));
      paramthl.put("cover_type", tlv.c(localthp.jdField_c_of_type_JavaLangString));
      paramthl.put("play_scene", b);
      a(a().addParams(localHashMap).addExtParams(paramthl).setOperationId(""), "gzh_video_play");
      return;
      l = 0L;
      break;
    }
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (stNewIconStyle localstNewIconStyle = paramstSimpleMetaFeed.new_icon; localstNewIconStyle == null; localstNewIconStyle = null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", localstNewIconStyle.tag_type + "");
    a("videoplay_tag", paramstSimpleMetaFeed, String.valueOf(localstNewIconStyle.id), localHashMap);
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString)
  {
    b(paramString);
    jdField_a_of_type_Int = tmo.a(paramString);
    if (jdField_a_of_type_Int == 2) {
      jdField_a_of_type_JavaLangString = "QQ_official_account";
    }
    while (jdField_a_of_type_Int != 6) {
      return;
    }
    jdField_a_of_type_JavaLangString = "weishi_share_trendstab";
  }
  
  private static void a(String paramString1, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString2, Map<String, String> paramMap)
  {
    paramstSimpleMetaFeed = a().addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString1, paramInt, paramstSimpleMetaFeed)).setOperationId(paramString2);
    paramString1 = paramMap;
    if (paramMap == null) {
      paramString1 = new HashMap();
    }
    paramString1.put("play_scene", b);
    paramstSimpleMetaFeed.addExtParams(paramString1);
    a(paramstSimpleMetaFeed, "gzh_click");
  }
  
  private static void a(String paramString1, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString2, Map<String, String> paramMap)
  {
    paramstSimpleMetaFeed = a().addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString1, 0, paramstSimpleMetaFeed)).setOperationId(paramString2);
    paramString1 = paramMap;
    if (paramMap == null) {
      paramString1 = new HashMap();
    }
    paramString1.put("play_scene", b);
    paramstSimpleMetaFeed.addExtParams(paramString1);
    a(paramstSimpleMetaFeed, "gzh_exposure");
  }
  
  public static void a(thl paramthl)
  {
    a(1, paramthl, false);
  }
  
  public static void a(thl paramthl, boolean paramBoolean)
  {
    a(2, paramthl, paramBoolean);
  }
  
  public static void a(boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramBoolean)
    {
      a("like", paramstSimpleMetaFeed, 1001001, "", null);
      return;
    }
    a("like", paramstSimpleMetaFeed, 1001002, "", null);
  }
  
  public static void b(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("forward", paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  public static void b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("like", paramstSimpleMetaFeed, 1001003, "", null);
  }
  
  private static void b(String paramString)
  {
    if (TextUtils.equals("recommend_tab", paramString)) {
      b = "feeds";
    }
    do
    {
      return;
      if (TextUtils.equals("mini_app_personal_main", paramString))
      {
        b = "homepage_main";
        return;
      }
      if (TextUtils.equals("mini_app_personal_guest", paramString))
      {
        b = "homepage_guest";
        return;
      }
    } while (!TextUtils.equals("follow_tab", paramString));
    b = "focus";
  }
  
  public static void c(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("profile", paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  public static void c(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("more_operations", paramstSimpleMetaFeed, 1000001, "", null);
  }
  
  public static void d(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (stNewIconStyle localstNewIconStyle = paramstSimpleMetaFeed.new_icon; localstNewIconStyle == null; localstNewIconStyle = null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", localstNewIconStyle.tag_type + "");
    a("videoplay_tag", paramstSimpleMetaFeed, paramInt, String.valueOf(localstNewIconStyle.id), localHashMap);
  }
  
  public static void d(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("follow", paramstSimpleMetaFeed, 1004001, "", null);
  }
  
  public static void e(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (!xoo.a(BaseApplicationImpl.getApplication())) {}
    for (int i = 1000002;; i = 1000003)
    {
      a("video_title", paramstSimpleMetaFeed, i, "", null);
      return;
    }
  }
  
  public static void f(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("comment_entry", paramstSimpleMetaFeed, 1000001, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnt
 * JD-Core Version:    0.7.0.1
 */