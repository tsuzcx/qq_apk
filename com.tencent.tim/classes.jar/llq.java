import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class llq
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    llu.w(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_content_wrapper", new JSONObject());
    localJSONObject1.put("id_article_wrapper", new JSONObject());
    localJSONObject1.put("id_summary_wrapper", new JSONObject());
    localJSONObject1.put("id_info_wrapper", new JSONObject());
    llu.a(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("id_summary", new JSONObject());
    localJSONObject1.put("id_image_content", new JSONObject());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_small_imge_url", paramBaseArticleInfo.mSinglePicture.getFile());
    localJSONObject1.put("id_article_small_imge", localJSONObject2);
    llu.a(paramBaseArticleInfo, localJSONObject1, true);
    llu.f(paramBaseArticleInfo, localJSONObject1);
    llu.m(paramBaseArticleInfo, localJSONObject1);
    llu.C(paramBaseArticleInfo, localJSONObject1);
    llu.D(paramBaseArticleInfo, localJSONObject1);
    llu.Y(localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_topic_recommend_pgc_big_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     llq
 * JD-Core Version:    0.7.0.1
 */