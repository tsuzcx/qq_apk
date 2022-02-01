import UserGrowth.stCollection;
import UserGrowth.stJumpInfo;
import UserGrowth.stNewIconStyle;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lvpj;>;
import java.util.Map;
import java.util.Set;

public class vsj
{
  private static final Set<String> a = new HashSet();
  
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    if (TextUtils.equals(paramString, "follow_tab"))
    {
      String str2 = vnd.a(10);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {}
    }
    for (String str1 = vnd.a(9);; str1 = vnd.a(voq.a(paramString))) {
      return new WSStatisticsReporter.Builder().setSceneFrom(b(paramString)).setSopName(a(paramString)).setTestId(str1).setPushId(vmm.a().a()).setFlush(true).setImmediatelyUpload(vnd.c());
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
    localMap.put("global_key", vkc.a().a(paramstJumpInfo.trace_id));
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
    localHashMap.put("cover_type", vnd.b(paramstSimpleMetaFeed, false));
    if (paramstSimpleMetaFeed.videoTag != null)
    {
      localObject = String.valueOf(paramstSimpleMetaFeed.videoTag.tagId);
      localHashMap.put("tag_id", localObject);
      if (!vmg.a(paramstSimpleMetaFeed.poster)) {
        break label278;
      }
    }
    label278:
    for (localObject = "1";; localObject = "0")
    {
      localHashMap.put("is_livenow", localObject);
      localObject = WSPublicAccReport.getInstance().getRecommendFullScreenInfo();
      if ((paramInt == 0) && (((vkb)localObject).a()))
      {
        localHashMap.put("is_cache_info", String.valueOf(((vkb)localObject).b()));
        localHashMap.put("is_cache_file", String.valueOf(((vkb)localObject).a()));
        localHashMap.put("exp_duration", String.valueOf(((vkb)localObject).a()));
      }
      a(paramString1, paramString2, str, paramstSimpleMetaFeed, "", localHashMap);
      return;
      localObject = "0";
      break;
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt, vgb paramvgb, boolean paramBoolean)
  {
    long l2 = 0L;
    if ((paramvgb == null) || (paramvgb.jdField_a_of_type_Vgi == null)) {}
    vgi localvgi;
    do
    {
      return;
      localvgi = paramvgb.jdField_a_of_type_Vgi;
    } while (voq.a(a, paramInt, localvgi));
    Object localObject = paramvgb.jdField_a_of_type_Vgh;
    long l1;
    HashMap localHashMap;
    if (localObject != null)
    {
      l1 = ((vgh)localObject).a();
      localHashMap = new HashMap();
      localHashMap.put("event_type", paramInt + "");
      localHashMap.put("feed_id", localvgi.a);
      localHashMap.put("owner_id", localvgi.jdField_e_of_type_JavaLangString);
      if (paramInt == 2) {
        if (localObject != null) {
          break label421;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("duration", String.valueOf(l2));
      localHashMap.put("last_location", String.valueOf(l1));
      localHashMap.put("video_length", String.valueOf(localvgi.jdField_c_of_type_Int));
      localHashMap.put("recommend_id", "");
      localHashMap.put("poolType", String.valueOf(localvgi.jdField_d_of_type_Int));
      localHashMap.put("global_key", vkc.a().a(localvgi.jdField_f_of_type_JavaLangString));
      localHashMap.put("feed_pass_key", localvgi.jdField_g_of_type_JavaLangString);
      vmp.e("WS_VIDEO_PLAY_TIME", "[WSVerticalBeaconReport.java][reportVerticalVideoPlay] title:" + localvgi.jdField_d_of_type_JavaLangString + ", map:" + localHashMap.toString());
      localObject = new HashMap();
      ((Map)localObject).put("type", String.valueOf(localvgi.jdField_e_of_type_Int));
      ((Map)localObject).put("cover_type", vnd.c(localvgi.jdField_c_of_type_JavaLangString));
      ((Map)localObject).put("material_type", String.valueOf(localvgi.jdField_f_of_type_Int));
      ((Map)localObject).put("play_scene", paramString2);
      ((Map)localObject).put("tag_id", String.valueOf(paramvgb.jdField_a_of_type_Vgi.jdField_g_of_type_Int));
      a(a(paramString1).addParams(localHashMap).addExtParams((Map)localObject).setOperationId(""), "gzh_video_play");
      return;
      l1 = 0L;
      break;
      label421:
      l2 = ((vgh)localObject).a(paramBoolean);
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
    paramString4 = a(paramString1).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString3, paramInt, paramstSimpleMetaFeed)).setOperationId(paramString4);
    paramString3 = paramMap;
    if (paramMap == null) {
      paramString3 = new HashMap();
    }
    paramString3.put("play_scene", paramString2);
    paramString1 = "0";
    if (paramstSimpleMetaFeed != null) {
      if (!vmg.a(paramstSimpleMetaFeed.poster)) {
        break label97;
      }
    }
    label97:
    for (paramString1 = "1";; paramString1 = "0")
    {
      paramString3.put("is_livenow", paramString1);
      paramString4.addExtParams(paramString3);
      a(paramString4, "gzh_click");
      return;
    }
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
  
  public static void a(String paramString1, String paramString2, vgb paramvgb)
  {
    a(paramString1, paramString2, 1, paramvgb, false);
  }
  
  public static void a(String paramString1, String paramString2, vgb paramvgb, boolean paramBoolean)
  {
    a(paramString1, paramString2, 2, paramvgb, paramBoolean);
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
  
  public static void a(List<vpj> paramList, int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("trigger_type", String.valueOf(paramInt1));
    if (paramBoolean) {}
    for (Object localObject = "true";; localObject = "false")
    {
      localHashMap.put("request_result", localObject);
      if (paramBoolean) {
        break;
      }
      localHashMap.put("failure_type", String.valueOf(paramInt2));
      a(paramString1, paramString2, "floating_layer_request", null, "", localHashMap);
      return;
    }
    if ((paramList != null) && (paramList.size() > 0) && ((((vpj)paramList.get(0)).a() instanceof stSimpleMetaFeed)))
    {
      localObject = (stSimpleMetaFeed)((vpj)paramList.get(0)).a();
      localStringBuilder = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        vpj localvpj = (vpj)localIterator.next();
        if (!TextUtils.isEmpty(((stSimpleMetaFeed)localvpj.a()).id))
        {
          localStringBuilder.append(((stSimpleMetaFeed)localvpj.a()).id);
          localStringBuilder.append("_");
        }
      }
      if (paramList.size() > 1) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      localHashMap.put("feedid_list", localStringBuilder.toString());
    }
    for (paramList = (List<vpj>)localObject;; paramList = localStringBuilder)
    {
      a(paramString1, paramString2, "floating_layer_request", paramList, "", localHashMap);
      return;
      localHashMap.put("feedid_list", "");
    }
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
    if (!zfn.a(BaseApplicationImpl.getApplication())) {}
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
 * Qualified Name:     vsj
 * JD-Core Version:    0.7.0.1
 */