import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class llr
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    llu.w(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("id_content_wrapper", new JSONObject());
    localJSONObject.put("id_article_wrapper", new JSONObject());
    localJSONObject.put("id_summary_wrapper", new JSONObject());
    localJSONObject.put("id_info_wrapper", new JSONObject());
    llu.a(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("id_multi_image", new JSONObject());
    localJSONObject.put("id_summary", new JSONObject());
    llu.a(paramBaseArticleInfo, localJSONObject, true);
    llu.f(paramBaseArticleInfo, localJSONObject);
    llu.m(paramBaseArticleInfo, localJSONObject);
    llu.C(paramBaseArticleInfo, localJSONObject);
    llu.D(paramBaseArticleInfo, localJSONObject);
    llu.Y(localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_topic_recommend_pgc_multi_cell");
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     llr
 * JD-Core Version:    0.7.0.1
 */