import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class nce
{
  private JSONObject al;
  
  public nce(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.al = new JSONObject();
        return;
      }
      this.al = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public nce(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.al = new JSONObject();
    kct.a(paramString1, paramString2, paramString3, paramString4, this.al);
  }
  
  public nce(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1);
    kct.a(paramString2, paramString3, paramString4, paramString5, this.al);
  }
  
  protected void put(String paramString, Object paramObject)
  {
    try
    {
      this.al.put(paramString, paramObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String toJsonString()
  {
    return this.al.toString();
  }
  
  public static final class a
  {
    private final nce a;
    
    public a(VideoInfo paramVideoInfo)
    {
      String str1;
      if (paramVideoInfo != null)
      {
        str1 = paramVideoInfo.hH;
        String str3 = paramVideoInfo.vid;
        String str2 = paramVideoInfo.Wz;
        localObject1 = localObject2;
        if (paramVideoInfo.busiType == 0)
        {
          localObject1 = localObject2;
          if (paramVideoInfo.a != null) {
            localObject1 = paramVideoInfo.a.getMd5();
          }
        }
        paramVideoInfo = str3;
        localObject2 = localObject1;
        localObject1 = str2;
      }
      for (;;)
      {
        this.a = new nce(localObject2, str1, paramVideoInfo, (String)localObject1);
        return;
        paramVideoInfo = null;
        str1 = null;
        localObject2 = null;
      }
    }
    
    public a(String paramString)
    {
      this.a = new nce(paramString);
    }
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.a = new nce(paramString1, paramString2, paramString3, paramString4);
    }
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
    {
      this.a = new nce(paramString1, paramString2, paramString3, paramString4);
      a(paramLong1).c(paramLong2);
    }
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.a = new nce(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
    
    public static int dx(int paramInt)
    {
      if (paramInt == 1004) {
        return 2;
      }
      if (awit.aMG()) {
        return 0;
      }
      return 1;
    }
    
    public a A(int paramInt)
    {
      this.a.put("actual_width", Integer.valueOf(paramInt));
      return this;
    }
    
    public a B(int paramInt)
    {
      this.a.put("actual_height", Integer.valueOf(paramInt));
      return this;
    }
    
    public a C(int paramInt)
    {
      this.a.put("issued_width", Integer.valueOf(paramInt));
      return this;
    }
    
    public a D(int paramInt)
    {
      this.a.put("issued_height", Integer.valueOf(paramInt));
      return this;
    }
    
    public a E(int paramInt)
    {
      if (paramInt != -1) {
        this.a.put("replay", Integer.valueOf(paramInt));
      }
      return this;
    }
    
    public a F(int paramInt)
    {
      this.a.put("first_video_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a G(int paramInt)
    {
      if (paramInt == 0) {
        paramInt = 302;
      }
      for (;;)
      {
        this.a.put("source", Integer.valueOf(paramInt));
        return this;
        if ((paramInt == 1) || (paramInt == 3)) {
          paramInt = 300;
        } else if ((paramInt == 2) || (paramInt == 6)) {
          paramInt = 301;
        } else {
          paramInt = 310;
        }
      }
    }
    
    public a H(int paramInt)
    {
      nce localnce = this.a;
      if (paramInt == 0) {}
      for (String str = "MP4";; str = "HLS")
      {
        localnce.put("video_format", str);
        return this;
      }
    }
    
    public a I(int paramInt)
    {
      this.a.put("video_chat_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a J(int paramInt)
    {
      this.a.put("video_kandian_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a K(int paramInt)
    {
      this.a.put("req_times", Integer.valueOf(paramInt));
      return this;
    }
    
    public a L(int paramInt)
    {
      this.a.put("first_video_channel_id", Integer.valueOf(paramInt));
      return this;
    }
    
    public a M(int paramInt)
    {
      this.a.put("first_video_short_video_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a N(int paramInt)
    {
      this.a.put("video_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a O(int paramInt)
    {
      this.a.put("entrance", Integer.valueOf(dx(paramInt)));
      return this;
    }
    
    public a P(int paramInt)
    {
      this.a.put("count", Integer.valueOf(paramInt));
      return this;
    }
    
    public a Q(int paramInt)
    {
      this.a.put("style", Integer.valueOf(paramInt));
      return this;
    }
    
    public a R(int paramInt)
    {
      this.a.put("click_area", Integer.valueOf(paramInt));
      return this;
    }
    
    public a S(int paramInt)
    {
      this.a.put("show_video_logo", Integer.valueOf(paramInt));
      return this;
    }
    
    public a T(int paramInt)
    {
      this.a.put("trigger_src", Integer.valueOf(paramInt));
      return this;
    }
    
    public a U(int paramInt)
    {
      this.a.put("diandianfeeds_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a V(int paramInt)
    {
      this.a.put("entrance_show_jump_icon", Integer.valueOf(paramInt));
      return this;
    }
    
    public a W(int paramInt)
    {
      this.a.put("feeds_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a X(int paramInt)
    {
      this.a.put("from_feedstype", Integer.valueOf(paramInt));
      return this;
    }
    
    public a Y(int paramInt)
    {
      this.a.put("cardbottom_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a Z(int paramInt)
    {
      this.a.put("topguide_bar", Integer.valueOf(paramInt));
      return this;
    }
    
    public a a(float paramFloat)
    {
      this.a.put("video_speed", Float.valueOf(paramFloat));
      return this;
    }
    
    public a a(int paramInt)
    {
      this.a.put("channel_id", Integer.valueOf(paramInt));
      return this;
    }
    
    public a a(long paramLong)
    {
      this.a.put("current_duration", Long.valueOf(paramLong));
      return this;
    }
    
    public a a(VideoInfo paramVideoInfo)
    {
      int j = 1;
      nce localnce = this.a;
      if (paramVideoInfo.adL)
      {
        i = 1;
        localnce.put("is_redpack", Integer.valueOf(i));
        this.a.put("redpack_style", Integer.valueOf(paramVideoInfo.aHh));
        localnce = this.a;
        if (!paramVideoInfo.adK) {
          break label77;
        }
      }
      label77:
      for (int i = j;; i = 0)
      {
        localnce.put("is_tips", Integer.valueOf(i));
        return this;
        i = 0;
        break;
      }
    }
    
    public a a(BaseArticleInfo paramBaseArticleInfo)
    {
      nce localnce = this.a;
      if (paramBaseArticleInfo.isShowGif) {}
      for (int i = 1;; i = 0)
      {
        localnce.put("gif", Integer.valueOf(i));
        return this;
      }
    }
    
    public a a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
    {
      if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mVideoColumnInfo != null) && (paramBaseArticleInfo.mChannelID == 56L))
      {
        if (!paramBoolean) {
          break label58;
        }
        paramBaseArticleInfo = paramBaseArticleInfo.mVideoColumnInfo.h;
        if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.WT == null)) {
          break label69;
        }
      }
      label58:
      label69:
      for (paramBaseArticleInfo = paramBaseArticleInfo.WT;; paramBaseArticleInfo = "")
      {
        r(paramBaseArticleInfo);
        return this;
        paramBaseArticleInfo = paramBaseArticleInfo.mVideoColumnInfo.j;
        break;
      }
    }
    
    public a a(VideoColumnInfo paramVideoColumnInfo)
    {
      int i = 1;
      if ((paramVideoColumnInfo != null) && (paramVideoColumnInfo.aTm == 1))
      {
        this.a.put("is_column", Integer.valueOf(1));
        this.a.put("column_id", Integer.valueOf(paramVideoColumnInfo.aHc));
        nce localnce = this.a;
        if (paramVideoColumnInfo.amw) {}
        for (;;)
        {
          localnce.put("subscribe_flag", Integer.valueOf(i));
          return this;
          i = 0;
        }
      }
      this.a.put("is_column", Integer.valueOf(0));
      return this;
    }
    
    public a a(Boolean paramBoolean)
    {
      if (paramBoolean.booleanValue()) {
        this.a.put("is_ugc_as_pgc", Integer.valueOf(1));
      }
      return this;
    }
    
    public a a(String paramString)
    {
      nce localnce = this.a;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localnce.put("video_report_info", str);
      return this;
    }
    
    public a a(String paramString, Object paramObject)
    {
      this.a.put(paramString, paramObject);
      return this;
    }
    
    public a a(ArrayList<DislikeInfo> paramArrayList)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        int j;
        for (int i = 1; paramArrayList.hasNext(); i = j)
        {
          DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.next();
          j = i;
          if (localDislikeInfo != null)
          {
            if (i == 0) {
              localStringBuilder.append("|");
            }
            j = 0;
            localStringBuilder.append(localDislikeInfo.agQ);
          }
        }
      }
      return k(localStringBuilder.toString());
    }
    
    public a a(myp parammyp)
    {
      a locala = this;
      if (parammyp != null) {
        locala = d(parammyp.qi());
      }
      return locala;
    }
    
    public a a(myp parammyp, long paramLong)
    {
      a locala = this;
      if (parammyp != null) {
        locala = c(parammyp.aR(paramLong));
      }
      return locala;
    }
    
    public a a(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        localnce.put("download", Integer.valueOf(i));
        return this;
      }
    }
    
    public nce a()
    {
      return this.a;
    }
    
    public a aa(int paramInt)
    {
      this.a.put("column_id", Integer.valueOf(paramInt));
      return this;
    }
    
    public a ab(int paramInt)
    {
      this.a.put("double_videocard_pos", Integer.valueOf(paramInt));
      return this;
    }
    
    public a ac(int paramInt)
    {
      this.a.put("video_autoplay", Integer.valueOf(paramInt));
      return this;
    }
    
    public a ad(int paramInt)
    {
      this.a.put("return_sence", Integer.valueOf(paramInt));
      return this;
    }
    
    public a b(int paramInt)
    {
      this.a.put("card_jump_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a b(long paramLong)
    {
      this.a.put("stay_duration", Long.valueOf(paramLong));
      return this;
    }
    
    public a b(BaseArticleInfo paramBaseArticleInfo)
    {
      if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoLogoUrl)) && (muj.Es()))
      {
        this.a.put("show_video_logo", Integer.valueOf(1));
        return this;
      }
      this.a.put("show_video_logo", Integer.valueOf(0));
      return this;
    }
    
    public a b(VideoColumnInfo paramVideoColumnInfo)
    {
      a locala = this;
      if (paramVideoColumnInfo != null) {
        locala = aa(paramVideoColumnInfo.aHc);
      }
      return locala;
    }
    
    public a b(String paramString)
    {
      this.a.put("session_id", paramString);
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localnce.put("interact_button_style", Integer.valueOf(i));
        return this;
      }
    }
    
    public a c(int paramInt)
    {
      this.a.put("strategy_id", Integer.valueOf(paramInt));
      return this;
    }
    
    public a c(long paramLong)
    {
      this.a.put("video_duration", Long.valueOf(paramLong));
      return this;
    }
    
    public a c(BaseArticleInfo paramBaseArticleInfo)
    {
      a locala = this;
      if (paramBaseArticleInfo != null)
      {
        locala = this;
        if (paramBaseArticleInfo.mChannelID == 56L)
        {
          locala = this;
          if (paramBaseArticleInfo.mVideoColumnInfo != null) {
            locala = b(paramBaseArticleInfo.mVideoColumnInfo);
          }
        }
      }
      return locala;
    }
    
    public a c(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.a.put("video_session_id", paramString);
      }
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      this.a.put("video_inserted", Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public a d(int paramInt)
    {
      this.a.put("video_strategyid", Integer.valueOf(paramInt));
      return this;
    }
    
    public a d(long paramLong)
    {
      this.a.put("watch_duration", Long.valueOf(paramLong));
      return this;
    }
    
    public a d(BaseArticleInfo paramBaseArticleInfo)
    {
      int j = 1;
      int i = j;
      if (paramBaseArticleInfo != null)
      {
        i = j;
        if (paramBaseArticleInfo.mChannelID == 56L)
        {
          i = j;
          if (awit.aMC())
          {
            i = j;
            if (paramBaseArticleInfo.mVideoColumnInfo != null) {
              i = 2;
            }
          }
        }
      }
      this.a.put("video_feeds_type", Integer.valueOf(i));
      return this;
    }
    
    public a d(String paramString)
    {
      this.a.put("puin", paramString);
      return this;
    }
    
    public a d(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (String str = "1";; str = "0")
      {
        localnce.put("fans", str);
        return this;
      }
    }
    
    public a e(int paramInt)
    {
      this.a.put("play_index", Integer.valueOf(paramInt));
      return this;
    }
    
    public a e(long paramLong)
    {
      this.a.put("algorithm_id", Long.valueOf(paramLong));
      return this;
    }
    
    public a e(BaseArticleInfo paramBaseArticleInfo)
    {
      this.a.put("account_expose_card", Integer.valueOf(kxm.c(paramBaseArticleInfo)));
      return this;
    }
    
    public a e(String paramString)
    {
      this.a.put("vid", paramString);
      return this;
    }
    
    public a e(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localnce.put("is_ads", Integer.valueOf(i));
        return this;
      }
    }
    
    public a f(int paramInt)
    {
      this.a.put("video_play_length", Integer.valueOf(paramInt));
      return this;
    }
    
    public a f(long paramLong)
    {
      this.a.put("video_play_duration", Long.valueOf(paramLong));
      return this;
    }
    
    public a f(BaseArticleInfo paramBaseArticleInfo)
    {
      if (mgk.a().a(paramBaseArticleInfo, false, mgk.aRi)) {
        this.a.put("jump_src", Integer.valueOf(mgn.j(paramBaseArticleInfo)));
      }
      return this;
    }
    
    public a f(String paramString)
    {
      this.a.put("aid", paramString);
      return this;
    }
    
    public a f(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (String str = "H265";; str = "H264")
      {
        localnce.put("video_code_format", str);
        return this;
      }
    }
    
    public a g(int paramInt)
    {
      this.a.put("from", Integer.valueOf(paramInt));
      return this;
    }
    
    public a g(long paramLong)
    {
      this.a.put("first_frame_time", Long.valueOf(paramLong));
      return this;
    }
    
    public a g(String paramString)
    {
      this.a.put("first_video_rowkey", paramString);
      return this;
    }
    
    public a g(boolean paramBoolean)
    {
      JSONObject localJSONObject = nce.a(this.a);
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        kct.a(localJSONObject, i);
        return this;
      }
    }
    
    public a h(int paramInt)
    {
      this.a.put("jump_to_channel", Integer.valueOf(paramInt));
      return this;
    }
    
    public a h(long paramLong)
    {
      this.a.put("first_video_algorithm_id", Long.valueOf(paramLong));
      return this;
    }
    
    public a h(String paramString)
    {
      this.a.put("rowkey", paramString);
      return this;
    }
    
    public a h(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localnce.put("action_type", Integer.valueOf(i));
        return this;
      }
    }
    
    public a i(int paramInt)
    {
      this.a.put("oper_time", Long.valueOf(System.currentTimeMillis()));
      this.a.put("company_id", Integer.valueOf(paramInt));
      return this;
    }
    
    public a i(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.a.put("error_code", paramString);
      }
      return this;
    }
    
    public a i(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        localnce.put("outcome", Integer.valueOf(i));
        return this;
      }
    }
    
    public a j(int paramInt)
    {
      this.a.put("ads_jump", Integer.valueOf(paramInt));
      return this;
    }
    
    public a j(String paramString)
    {
      this.a.put("video_to_uin", paramString);
      return this;
    }
    
    public a j(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localnce.put("loophole", Integer.valueOf(i));
        return this;
      }
    }
    
    public a k(int paramInt)
    {
      this.a.put("ads_source", Integer.valueOf(paramInt));
      return this;
    }
    
    public a k(String paramString)
    {
      this.a.put("neg_reason", paramString);
      return this;
    }
    
    public a k(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localnce.put("is_insertion", Integer.valueOf(i));
        return this;
      }
    }
    
    public a l(int paramInt)
    {
      this.a.put("video_index", Integer.valueOf(paramInt));
      return this;
    }
    
    public a l(String paramString)
    {
      this.a.put("uin", paramString);
      return this;
    }
    
    public a l(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localnce.put("ad_guide_area", Integer.valueOf(i));
        return this;
      }
    }
    
    public a m(int paramInt)
    {
      this.a.put("transverse_index", Integer.valueOf(paramInt));
      return this;
    }
    
    public a m(String paramString)
    {
      this.a.put("trigger_rowkey", paramString);
      return this;
    }
    
    public a m(boolean paramBoolean)
    {
      nce localnce = this.a;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localnce.put("video_speed_icon", Integer.valueOf(i));
        return this;
      }
    }
    
    public a n(int paramInt)
    {
      this.a.put("content_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a n(String paramString)
    {
      this.a.put("from_rk", paramString);
      return this;
    }
    
    public a o(int paramInt)
    {
      this.a.put("slide_exit", Integer.valueOf(paramInt));
      return this;
    }
    
    public a o(String paramString)
    {
      this.a.put("cardbottom_video_report_info", paramString);
      return this;
    }
    
    public a p(int paramInt)
    {
      this.a.put("kandian_mode_new", Integer.valueOf(paramInt));
      return this;
    }
    
    public a p(String paramString)
    {
      this.a.put("topguide_bar_video_report_info", paramString);
      return this;
    }
    
    public a q(int paramInt)
    {
      this.a.put("kandian_mode", Integer.valueOf(paramInt));
      return this;
    }
    
    public a q(String paramString)
    {
      this.a.put("ad_guide_area_video_report_info", paramString);
      return this;
    }
    
    public a r(int paramInt)
    {
      this.a.put("item_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a r(String paramString)
    {
      this.a.put("jump_report_info", paramString);
      return this;
    }
    
    public a s(int paramInt)
    {
      this.a.put("play_num", Integer.valueOf(paramInt));
      return this;
    }
    
    public a s(String paramString)
    {
      this.a.put("double_videocard_jump_page", paramString);
      return this;
    }
    
    public a t(int paramInt)
    {
      this.a.put("topic_id", Integer.valueOf(paramInt));
      return this;
    }
    
    public a t(String paramString)
    {
      this.a.put("double_videocard_jump_src", paramString);
      return this;
    }
    
    public a u(int paramInt)
    {
      this.a.put("jump_to", Integer.valueOf(paramInt));
      return this;
    }
    
    public a u(String paramString)
    {
      this.a.put("subscript", paramString);
      return this;
    }
    
    public a v(int paramInt)
    {
      this.a.put("video_from_type", Integer.valueOf(paramInt));
      return this;
    }
    
    public a w(int paramInt)
    {
      if (paramInt != -1) {
        this.a.put("source", Integer.valueOf(paramInt));
      }
      return this;
    }
    
    public a x(int paramInt)
    {
      this.a.put("card_pos", Integer.valueOf(paramInt));
      return this;
    }
    
    public a y(int paramInt)
    {
      this.a.put("is_loop", Integer.valueOf(paramInt));
      return this;
    }
    
    public a z(int paramInt)
    {
      this.a.put("loop_times", Integer.valueOf(paramInt));
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nce
 * JD-Core Version:    0.7.0.1
 */