import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.AwesomeCommentInfo;

public class mgt
{
  public static int aRv = ((Integer)awit.f(agK, Integer.valueOf(0))).intValue();
  public static String agK = "ReadInJoy_Awesome_comment_plan";
  public static String agL = "ReadInJoy_Awesome_comment_max_lines";
  public String avatar;
  public String comment_id;
  public String content;
  public BaseArticleInfo d;
  public int icon_height;
  public String icon_url;
  public int icon_with;
  public String jump_url;
  public String nick_name;
  public String rawkey;
  public long uin;
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, articlesummary.AwesomeCommentInfo paramAwesomeCommentInfo)
  {
    if (paramBaseArticleInfo == null) {
      QLog.d("AwesomeCommentInfo", 2, "articleinfo == null");
    }
    do
    {
      return;
      if (paramAwesomeCommentInfo.rowkey.has()) {
        paramBaseArticleInfo.rawkey = paramAwesomeCommentInfo.rowkey.get().toStringUtf8();
      }
      if (paramAwesomeCommentInfo.icon_url.has()) {
        paramBaseArticleInfo.icon_url = paramAwesomeCommentInfo.icon_url.get().toStringUtf8();
      }
      if (paramAwesomeCommentInfo.icon_with.has()) {
        paramBaseArticleInfo.icon_with = paramAwesomeCommentInfo.icon_with.get();
      }
      if (paramAwesomeCommentInfo.icon_height.has()) {
        paramBaseArticleInfo.icon_height = paramAwesomeCommentInfo.icon_height.get();
      }
      if (paramAwesomeCommentInfo.jump_url.has()) {
        paramBaseArticleInfo.jump_url = paramAwesomeCommentInfo.jump_url.get().toStringUtf8();
      }
      if (paramAwesomeCommentInfo.uin.has()) {
        paramBaseArticleInfo.uin = paramAwesomeCommentInfo.uin.get();
      }
      if (paramAwesomeCommentInfo.nick_name.has()) {
        paramBaseArticleInfo.nick_name = paramAwesomeCommentInfo.nick_name.get().toStringUtf8();
      }
      if (paramAwesomeCommentInfo.avatar.has()) {
        paramBaseArticleInfo.avatar = paramAwesomeCommentInfo.avatar.get().toStringUtf8();
      }
      if (paramAwesomeCommentInfo.comment_id.has()) {
        paramBaseArticleInfo.comment_id = paramAwesomeCommentInfo.comment_id.get().toStringUtf8();
      }
    } while (!paramAwesomeCommentInfo.content.has());
    paramBaseArticleInfo.content = paramAwesomeCommentInfo.content.get().toStringUtf8();
  }
  
  public static void aPc()
  {
    aRv = ((Integer)awit.f(agK, Integer.valueOf(0))).intValue();
    NativeAwesomeCommentView.maxLines = ((Integer)awit.f(agL, Integer.valueOf(1))).intValue();
  }
  
  public static void d(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo != null) {}
    try
    {
      if ((paramBaseArticleInfo.mResolvedFeedType == 0) && ((paramBaseArticleInfo instanceof ArticleInfo))) {
        paramBaseArticleInfo.mResolvedFeedType = ndi.b((ArticleInfo)paramBaseArticleInfo, 0);
      }
      localJSONObject.put("entry", k(paramBaseArticleInfo));
      localJSONObject.put("comment_id", paramBaseArticleInfo.comment_id);
      localJSONObject.put("limit", NativeAwesomeCommentView.maxLines);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    if (paramBaseArticleInfo != null) {
      kbp.a(null, "", paramString, paramString, 0, 0, paramBaseArticleInfo.mArticleID + "", paramBaseArticleInfo.mStrategyId + "", paramBaseArticleInfo.rawkey, localJSONObject.toString(), false);
    }
  }
  
  private static int k(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mResolvedFeedType == 5) || (paramBaseArticleInfo.mResolvedFeedType == 19) || (paramBaseArticleInfo.mResolvedFeedType == 14) || (paramBaseArticleInfo.mResolvedFeedType == 4) || (paramBaseArticleInfo.mResolvedFeedType == 66) || (paramBaseArticleInfo.mResolvedFeedType == 115) || (paramBaseArticleInfo.mResolvedFeedType == 6)) {
      return 2;
    }
    if ((paramBaseArticleInfo.mResolvedFeedType == 60) || (paramBaseArticleInfo.mResolvedFeedType == 61)) {
      return 3;
    }
    if (paramBaseArticleInfo.mResolvedFeedType == 0) {
      return 1;
    }
    return 0;
  }
  
  public String toString()
  {
    return "AwesomeCommentInfo{rawkey='" + this.rawkey + '\'' + ", icon_url='" + this.icon_url + '\'' + ", icon_with=" + this.icon_with + ", icon_height=" + this.icon_height + ", jump_url='" + this.jump_url + '\'' + ", uin=" + this.uin + ", nick_name='" + this.nick_name + '\'' + ", avatar='" + this.avatar + '\'' + ", comment_id='" + this.comment_id + '\'' + ", content='" + this.content + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgt
 * JD-Core Version:    0.7.0.1
 */