import UserGrowth.stFriendLikes;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class uvm
{
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    return new WSStatisticsReporter.Builder().setSceneFrom("QQ_official_account").setSopName(paramString).setTestId(uyo.a(9)).setPushId(uxx.a().a()).setFlush(true).setImmediatelyUpload(uyo.c());
  }
  
  public static void a()
  {
    a("friend_info", 1000001, null, null);
  }
  
  public static void a(int paramInt)
  {
    WSStatisticsReporter.Builder localBuilder = a("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("focus_recommend_gap", 0));
    HashMap localHashMap = new HashMap();
    localHashMap.put("gap_type", String.valueOf(paramInt));
    localBuilder.addExtParams(localHashMap);
    a(localBuilder, "gzh_exposure");
  }
  
  public static void a(int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      if (!uxr.a(paramstSimpleMetaFeed.poster.followStatus)) {
        break label133;
      }
      str = "1";
      localHashMap.put("is_focus", str);
      if (paramInt3 <= 1) {
        break label140;
      }
      str = "1";
      label59:
      localHashMap.put("is_fold", str);
      localHashMap.put("fold_num", String.valueOf(paramInt3));
      if (!paramBoolean) {
        break label147;
      }
    }
    label133:
    label140:
    label147:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_unread", str);
      a("friend_video" + paramInt1, paramInt2, localHashMap, paramstSimpleMetaFeed);
      return;
      str = "0";
      break;
      str = "0";
      break label59;
    }
  }
  
  public static void a(int paramInt1, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      if (!uxr.a(paramstSimpleMetaFeed.poster.followStatus)) {
        break label130;
      }
      str = "1";
      localHashMap.put("is_focus", str);
      if (paramInt2 <= 1) {
        break label137;
      }
      str = "1";
      label58:
      localHashMap.put("is_fold", str);
      localHashMap.put("fold_num", String.valueOf(paramInt2));
      if (!paramBoolean) {
        break label144;
      }
    }
    label130:
    label137:
    label144:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_unread", str);
      a("friend_video" + paramInt1, localHashMap, paramstSimpleMetaFeed);
      return;
      str = "0";
      break;
      str = "0";
      break label58;
    }
  }
  
  public static void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, ArrayList<uxh> paramArrayList, ArrayList<uxg> paramArrayList1)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("index", String.valueOf(paramInt));
    localHashMap.put("position_profile", "dynamics_nickname" + paramInt);
    localHashMap.put("position_nickname", "dynamics_nickname" + paramInt);
    localHashMap.put("position_content", "dynamics_content" + paramInt);
    localHashMap.put("position_video", "dynamics_video" + paramInt);
    localHashMap.put("position_more_operations", "dynamics_more_operations" + paramInt);
    if (paramBoolean1)
    {
      localHashMap.put("position_close", "dynamics_close" + paramInt);
      localHashMap.put("position_follow", "dynamics_follow" + paramInt);
    }
    if (paramBoolean2) {
      localHashMap.put("position_label_music", "dynamics_bottom_label_music" + paramInt);
    }
    if (paramBoolean3) {
      localHashMap.put("position_label_magic", "dynamics_bottom_label_magic" + paramInt);
    }
    if (paramBoolean4) {
      localHashMap.put("position_label_location", "dynamics_bottom_label_location" + paramInt);
    }
    if (paramBoolean5) {
      localHashMap.put("position_qqgroup", "dynamics_qqgroup" + paramInt);
    }
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.friendLikes != null) && (paramstSimpleMetaFeed.friendLikes.likeFriends != null) && (paramstSimpleMetaFeed.friendLikes.likeFriends.size() > 0)) {
      localHashMap.put("position_friend", "dynamics_friend" + paramInt);
    }
    int i;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append("dynamics_user_at").append(paramInt).append(":").append(((uxh)paramArrayList.get(i)).a);
        if (i != paramArrayList.size() - 1) {
          localStringBuilder.append("#");
        }
        i += 1;
      }
      localHashMap.put("position_at", localStringBuilder.toString());
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      paramArrayList = new StringBuilder();
      i = 0;
      while (i < paramArrayList1.size())
      {
        paramArrayList.append("dynamics_topic").append(paramInt).append(":").append(((uxg)paramArrayList1.get(i)).a);
        if (i != paramArrayList1.size() - 1) {
          paramArrayList.append("#");
        }
        i += 1;
      }
      localHashMap.put("position_topic", paramArrayList.toString());
    }
    a(a("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("dynamics_feed", 0, paramstSimpleMetaFeed)).addExtParams(localHashMap), "gzh_exposure");
  }
  
  public static void a(int paramInt, stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("index", String.valueOf(paramInt));
    localHashMap.put("position_profile", "recommend_profile" + paramInt);
    localHashMap.put("position_nickname", "recommend_nickname" + paramInt);
    localHashMap.put("position_close", "recommend_close" + paramInt);
    if ((paramstSimpleMetaPerson != null) && (!uxr.a(paramstSimpleMetaPerson.followStatus))) {
      localHashMap.put("position_follow", "recommend_follow" + paramInt);
    }
    WSStatisticsReporter.Builder localBuilder = a("focus").addParams("position", "recommend_profile_card");
    if (paramstSimpleMetaPerson != null) {}
    for (paramstSimpleMetaPerson = paramstSimpleMetaPerson.id;; paramstSimpleMetaPerson = "")
    {
      a(localBuilder.addParams("owner_id", paramstSimpleMetaPerson).addExtParams(localHashMap), "gzh_exposure");
      return;
    }
  }
  
  private static void a(int paramInt, urt paramurt, boolean paramBoolean)
  {
    if ((paramurt == null) || (paramurt.jdField_a_of_type_Urx == null)) {}
    label296:
    label304:
    for (;;)
    {
      return;
      urx localurx = paramurt.jdField_a_of_type_Urx;
      paramurt = paramurt.jdField_a_of_type_Urw;
      long l1;
      HashMap localHashMap;
      if (paramurt != null)
      {
        l1 = paramurt.a();
        localHashMap = new HashMap();
        localHashMap.put("event_type", paramInt + "");
        localHashMap.put("feed_id", localurx.a);
        localHashMap.put("owner_id", localurx.e);
        localHashMap.put("global_key", uvo.a().a(localurx.f));
        localHashMap.put("feed_pass_key", localurx.g);
        if (paramInt == 2) {
          if (paramurt != null) {
            break label296;
          }
        }
      }
      for (long l2 = 0L;; l2 = paramurt.a(paramBoolean))
      {
        if (l2 <= 0L) {
          break label304;
        }
        localHashMap.put("duration", String.valueOf(l2));
        localHashMap.put("last_location", String.valueOf(l1));
        localHashMap.put("video_length", String.valueOf(localurx.c));
        localHashMap.put("recommend_id", "");
        localHashMap.put("poolType", String.valueOf(localurx.d));
        uya.e("WS_VIDEO_PLAY_TIME", "[WSFollowBeaconReport.java][reportVerticalVideoPlay] map:" + localHashMap.toString());
        a(a("focus").addParams(localHashMap), "gzh_video_play");
        return;
        l1 = 0L;
        break;
      }
    }
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    uya.b("WSFollowBeaconReport", paramString + ", " + paramBuilder.getSopName() + ": " + paramBuilder.getParams().toString());
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page_type", paramString);
    a(a("backstage").addParams("position", "focus_pullout").addParams("feed_id", "").addParams("owner_id", "").addExtParams(localHashMap), "gzh_exposure");
  }
  
  public static void a(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    b(paramString, paramInt, null, paramstSimpleMetaFeed);
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
    a("dynamics_" + paramString1 + paramInt, Integer.valueOf(paramString2).intValue(), paramMap, paramstSimpleMetaFeed);
  }
  
  public static void a(String paramString, int paramInt, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString = a("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString, paramInt, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString.addExtParams(paramMap);
    }
    a(paramString, "gzh_click");
  }
  
  public static void a(String paramString, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramString = a("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString, 0, paramstSimpleMetaFeed));
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramString.addExtParams(paramMap);
    }
    a(paramString, "gzh_exposure");
  }
  
  public static void a(urt paramurt)
  {
    a(1, paramurt, false);
  }
  
  public static void a(urt paramurt, boolean paramBoolean)
  {
    a(2, paramurt, paramBoolean);
  }
  
  public static void b()
  {
    a("friend_all", 1000001, null, null);
  }
  
  public static void b(int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      if (!uxr.a(paramstSimpleMetaFeed.poster.followStatus)) {
        break label134;
      }
      str = "1";
      localHashMap.put("is_focus", str);
      if (paramInt3 <= 1) {
        break label141;
      }
      str = "1";
      label59:
      localHashMap.put("is_fold", str);
      localHashMap.put("fold_num", String.valueOf(paramInt3));
      if (!paramBoolean) {
        break label148;
      }
    }
    label134:
    label141:
    label148:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_unread", str);
      a("friend_focus" + paramInt1, paramInt2, localHashMap, paramstSimpleMetaFeed);
      return;
      str = "0";
      break;
      str = "0";
      break label59;
    }
  }
  
  public static void b(String paramString, int paramInt, Map<String, String> paramMap, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a("dynamics_" + paramString + paramInt, paramMap, paramstSimpleMetaFeed);
  }
  
  public static void c()
  {
    a("friend_info_float", 1000001, null, null);
  }
  
  public static void d()
  {
    a("friend_info_float", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvm
 * JD-Core Version:    0.7.0.1
 */