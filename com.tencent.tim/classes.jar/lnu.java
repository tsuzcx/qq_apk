import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class lnu
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
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mKdLiveInfo == null)) {
      return new JSONObject();
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_live_video_cell");
    localJSONObject.put("avatar_uin", paramBaseArticleInfo.mSubscribeID);
    String str = " ";
    Object localObject = str;
    if (paramBaseArticleInfo.mSubscribeName != null)
    {
      localObject = str;
      if (paramBaseArticleInfo.mSubscribeName.length() > 0)
      {
        if (paramBaseArticleInfo.mSubscribeName.length() <= 10) {
          break label348;
        }
        localObject = paramBaseArticleInfo.mSubscribeName.substring(0, 10);
        localObject = (String)localObject + "...";
      }
    }
    localJSONObject.put("user_name_text", localObject);
    localJSONObject.put("user_info_text", paramBaseArticleInfo.mTitle);
    localJSONObject.put("article_large_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
    localJSONObject.put("play_icon_url", "rij_multi_video_column_play");
    localObject = paramBaseArticleInfo.mKdLiveInfo;
    localJSONObject.put("live_status_bg_url", ((mhl)localObject).agV);
    if (!TextUtils.isEmpty(((mhl)localObject).agW)) {
      localJSONObject.put("live_status_icon_url", ((mhl)localObject).agW);
    }
    localJSONObject.put("live_status_text", ((mhl)localObject).statusText);
    if (!TextUtils.isEmpty(((mhl)localObject).agX)) {
      localJSONObject.put("live_hot_icon_url", ((mhl)localObject).agX);
    }
    localJSONObject.put("live_hot_text", ((mhl)localObject).agY);
    switch (paramBaseArticleInfo.mKdLiveInfo.style)
    {
    default: 
      localJSONObject.put("video_info_visibility", "1");
    }
    for (;;)
    {
      localJSONObject.put("video_jump_url", paramBaseArticleInfo.mArticleContentUrl);
      localJSONObject.put("url", ((mhl)localObject).agZ);
      localJSONObject.put("jump_report_info", ((mhl)localObject).aha);
      localJSONObject.put("video_jump_report_info", paramBaseArticleInfo.mReportCommonData);
      QLog.d("LiveSingleVideoProteusItem", 1, localJSONObject.toString());
      return localJSONObject;
      label348:
      localObject = paramBaseArticleInfo.mSubscribeName;
      break;
      localJSONObject.put("avatar_info_visibility", "1");
      continue;
      localJSONObject.put("bottom_info_visibility", "1");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnu
 * JD-Core Version:    0.7.0.1
 */