import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class lnt
  implements lpi
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mKdLiveInfo == null) || (paramBaseArticleInfo.mSubArtilceList == null) || (paramBaseArticleInfo.mSubArtilceList.get(0) == null) || (((ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0)).mKdLiveInfo == null)) {
      return new JSONObject();
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_live_double_video_cell");
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    mhl localmhl2 = paramBaseArticleInfo.mKdLiveInfo;
    mhl localmhl1 = localBaseArticleInfo.mKdLiveInfo;
    String str2 = " ";
    String str1 = str2;
    if (paramBaseArticleInfo.mSubscribeName != null)
    {
      str1 = str2;
      if (paramBaseArticleInfo.mSubscribeName.length() > 0)
      {
        if (paramBaseArticleInfo.mSubscribeName.length() <= 10) {
          break label555;
        }
        str1 = paramBaseArticleInfo.mSubscribeName.substring(0, 10);
        str1 = str1 + "...";
      }
    }
    localJSONObject.put("left_user_name_text", str1);
    localJSONObject.put("left_video_title_text", paramBaseArticleInfo.mTitle);
    localJSONObject.put("left_video_bg_url", paramBaseArticleInfo.mFirstPagePicUrl);
    localJSONObject.put("left_jump_url", paramBaseArticleInfo.mArticleContentUrl);
    localJSONObject.put("left_live_status_bg_url", localmhl2.agV);
    if (!TextUtils.isEmpty(localmhl2.agW)) {
      localJSONObject.put("left_live_status_icon_url", localmhl2.agW);
    }
    localJSONObject.put("left_live_status_text", localmhl2.statusText);
    if (!TextUtils.isEmpty(localmhl2.agX)) {
      localJSONObject.put("left_live_hot_icon_url", localmhl2.agX);
    }
    localJSONObject.put("left_live_hot_text", localmhl2.agY);
    str2 = " ";
    str1 = str2;
    if (localBaseArticleInfo.mSubscribeName != null)
    {
      str1 = str2;
      if (localBaseArticleInfo.mSubscribeName.length() > 0)
      {
        if (localBaseArticleInfo.mSubscribeName.length() <= 10) {
          break label563;
        }
        str1 = localBaseArticleInfo.mSubscribeName.substring(0, 10);
      }
    }
    label555:
    label563:
    for (str1 = str1 + "...";; str1 = localBaseArticleInfo.mSubscribeName)
    {
      localJSONObject.put("right_user_name_text", str1);
      localJSONObject.put("right_video_title_text", localBaseArticleInfo.mTitle);
      localJSONObject.put("right_video_bg_url", localBaseArticleInfo.mFirstPagePicUrl);
      localJSONObject.put("right_jump_url", localBaseArticleInfo.mArticleContentUrl);
      localJSONObject.put("right_live_status_bg_url", localmhl1.agV);
      if (!TextUtils.isEmpty(localmhl1.agW)) {
        localJSONObject.put("right_live_status_icon_url", localmhl1.agW);
      }
      localJSONObject.put("right_live_status_text", localmhl1.statusText);
      if (!TextUtils.isEmpty(localmhl1.agX)) {
        localJSONObject.put("right_live_hot_icon_url", localmhl1.agX);
      }
      localJSONObject.put("right_live_hot_text", localmhl1.agY);
      localJSONObject.put("left_jump_report_info", paramBaseArticleInfo.mReportCommonData);
      localJSONObject.put("right_jump_report_info", localBaseArticleInfo.mReportCommonData);
      QLog.d("LiveDoubleVideoProteusItem", 1, localJSONObject.toString());
      return localJSONObject;
      str1 = paramBaseArticleInfo.mSubscribeName;
      break;
    }
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnt
 * JD-Core Version:    0.7.0.1
 */