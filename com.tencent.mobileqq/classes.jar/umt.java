import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class umt
{
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSceneFrom("QQ_official_account").setSopName(paramString).setTestId(ups.a(10003)).setPushId(upb.a().a()).setFlush(true).setImmediatelyUpload(ups.c());
  }
  
  public static String a(String paramString)
  {
    if ("fullscreen_videoplay".equals(paramString)) {
      return "comment_entry";
    }
    if ("focus".equals(paramString)) {
      return "dynamics_comment_entry";
    }
    if ("focus_fallback".equals(paramString)) {
      return "dynamics_comment_entry";
    }
    return "dynamics_comment_entry";
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("dynamics_comment_like" + paramInt1, paramString, paramInt2, null, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString2, paramString1, paramInt, null, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (TextUtils.equals(paramString1, "focus"))
    {
      str = "dynamics_comment_page_reply" + paramInt;
      if (!paramBoolean2) {
        break label100;
      }
    }
    label100:
    for (paramInt = 1002002;; paramInt = 1002003)
    {
      HashMap localHashMap = null;
      if (!TextUtils.equals(paramString1, "focus"))
      {
        localHashMap = new HashMap();
        localHashMap.put("play_scene", paramString2);
      }
      a(str, paramString1, paramInt, localHashMap, paramstSimpleMetaFeed);
      return;
      if (paramBoolean1) {}
      for (str = "comment_page_reply_explicit";; str = "comment_page_reply") {
        break;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString1 = a(paramString2).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString1, paramInt, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString1.addExtParams(paramMap);
    }
    a(paramString1, "gzh_click");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.equals(paramString1, "focus")) {
      localHashMap.put("play_scene", paramString2);
    }
    localHashMap.put("object", String.valueOf(paramInt2));
    a(paramString3, paramString1, paramInt1, localHashMap, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    HashMap localHashMap = null;
    if (!TextUtils.equals(paramString1, "focus"))
    {
      localHashMap = new HashMap();
      localHashMap.put("play_scene", paramString2);
    }
    a(paramString3, paramString1, paramInt, localHashMap, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    HashMap localHashMap = null;
    if (!TextUtils.equals(paramString1, "focus"))
    {
      localHashMap = new HashMap();
      localHashMap.put("play_scene", paramString2);
    }
    a(paramString3, paramString1, localHashMap, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString1, String paramString2, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString1 = a(paramString2).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString1, 0, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString1.addExtParams(paramMap);
    }
    a(paramString1, "gzh_exposure");
  }
  
  public static boolean a(String paramString)
  {
    return (TextUtils.equals(paramString, "fullscreen_videoplay")) || (TextUtils.equals(paramString, "second_fullscreen_videoplay")) || (TextUtils.equals(paramString, "feeds_fullscreen"));
  }
  
  public static String b(String paramString)
  {
    if (a(paramString)) {
      return "comment_page";
    }
    if ("focus".equals(paramString)) {
      return "dynamics_comment_page";
    }
    if ("focus_fallback".equals(paramString)) {
      return "dynamics_comment_page";
    }
    return "dynamics_comment_page";
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("dynamics_comment_entry_text" + paramInt1, paramString, paramInt2, null, paramstSimpleMetaFeed);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    HashMap localHashMap = null;
    if (!TextUtils.equals(paramString1, "focus"))
    {
      localHashMap = new HashMap();
      localHashMap.put("play_scene", paramString2);
    }
    a(paramString3, paramString1, localHashMap, paramstSimpleMetaFeed);
  }
  
  public static String c(String paramString)
  {
    if (a(paramString)) {
      return "comment_tag";
    }
    if ("focus".equals(paramString)) {
      return "dynamics_comment_tag";
    }
    if ("focus_fallback".equals(paramString)) {
      return "dynamics_comment_tag";
    }
    return "dynamics_comment_tag";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umt
 * JD-Core Version:    0.7.0.1
 */