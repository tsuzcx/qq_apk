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

public class osv
{
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSceneFrom(fD(paramString)).setSopName(fE(paramString)).setTestId(opn.getSceneTypeTestId(oql.aX(paramString))).setPushId(oox.a().getPushId()).setFlush(true);
  }
  
  private static String a(stOpVideo paramstOpVideo)
  {
    if (paramstOpVideo != null) {
      return String.valueOf(paramstOpVideo.videoType);
    }
    return String.valueOf(0);
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
    localMap.put("global_key", ohy.a().fv(paramstJumpInfo.trace_id));
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
    stOpVideo localstOpVideo = paramstSimpleMetaFeed.opVideo;
    String str = "fullscreen_videoplay_video" + (paramInt + 1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("poolType", String.valueOf(paramstSimpleMetaFeed.videoPoolType));
    localHashMap.put("type", String.valueOf(paramstSimpleMetaFeed.video_type));
    localHashMap.put("opvideo_type", a(localstOpVideo));
    localHashMap.put("material_type", a(localstOpVideo));
    localHashMap.put("cover_type", opn.b(paramstSimpleMetaFeed, false));
    a(paramString1, paramString2, str, paramstSimpleMetaFeed, "", localHashMap);
  }
  
  private static void a(String paramString1, String paramString2, int paramInt, ole paramole, boolean paramBoolean)
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
      if (paramInt == 2) {
        if (paramole != null) {
          break label323;
        }
      }
    }
    label323:
    for (paramole = "0";; paramole = String.valueOf(paramole.e(paramBoolean)))
    {
      localHashMap.put("duration", paramole);
      localHashMap.put("last_location", String.valueOf(l));
      localHashMap.put("video_length", String.valueOf(localoli.mDuration));
      localHashMap.put("recommend_id", "");
      localHashMap.put("poolType", String.valueOf(localoli.mVideoPoolType));
      localHashMap.put("global_key", ohy.a().fv(localoli.traceId));
      localHashMap.put("feed_pass_key", localoli.aqm);
      paramole = new HashMap();
      paramole.put("type", String.valueOf(localoli.mVideoType));
      paramole.put("cover_type", opn.fB(localoli.mCoverUrl));
      paramole.put("material_type", String.valueOf(localoli.bfp));
      paramole.put("play_scene", paramString2);
      a(a(paramString1).addParams(localHashMap).addExtParams(paramole).setOperationId(""), "gzh_video_play");
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
  
  public static void a(String paramString1, String paramString2, ole paramole)
  {
    a(paramString1, paramString2, 1, paramole, false);
  }
  
  public static void a(String paramString1, String paramString2, ole paramole, boolean paramBoolean)
  {
    a(paramString1, paramString2, 2, paramole, paramBoolean);
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
    a(paramString1, paramString2, "follow", paramstSimpleMetaFeed, 1004001, "", null);
  }
  
  public static void f(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (!rpw.isWeishiInstalled(BaseApplicationImpl.getApplication())) {}
    for (int i = 1000002;; i = 1000003)
    {
      a(paramString1, paramString2, "video_title", paramstSimpleMetaFeed, i, "", null);
      return;
    }
  }
  
  private static String fD(String paramString)
  {
    if (TextUtils.equals(paramString, "trends")) {
      return "weishi_share_trendstab";
    }
    return "QQ_official_account";
  }
  
  public static String fE(String paramString)
  {
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return "second_fullscreen_videoPlay";
    }
    return "fullscreen_videoPlay";
  }
  
  public static void g(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "comment_entry", paramstSimpleMetaFeed, 1000001, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osv
 * JD-Core Version:    0.7.0.1
 */