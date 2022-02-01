import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class lln
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    if ((paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.size() != 0))
    {
      localObject = (mih.b)paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.get(0);
      BaseApplicationImpl.getApplication().getResources();
    }
    for (Object localObject = ((mih.b)localObject).picUrl;; localObject = null)
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("participant_title_text", null);
      localJSONObject1.put("id_participant_title", localJSONObject2);
      llu.a(paramBaseArticleInfo, localJSONObject1, false);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("participant_pic_url", localObject);
      localJSONObject1.put("id_participant_imge", localJSONObject2);
      localJSONObject1.put("id_view_cover", new JSONObject());
      llu.a(paramBaseArticleInfo, localJSONObject1);
      llu.m(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_single_topic_cell");
      llu.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lln
 * JD-Core Version:    0.7.0.1
 */