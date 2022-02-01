import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class lle
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    llu.a(paramBaseArticleInfo, localJSONObject1, true);
    knd.b(paramBaseArticleInfo, localJSONObject1);
    knd.a(paramBaseArticleInfo, localJSONObject1);
    llu.m(paramBaseArticleInfo, localJSONObject1);
    llu.f(paramBaseArticleInfo, localJSONObject1);
    llu.h(paramBaseArticleInfo, localJSONObject1);
    llu.aa(paramBaseArticleInfo, localJSONObject1);
    localJSONObject1.put("style_ID", "ReadInjoy_ad_triple_img_interact_cell");
    llu.a(localJSONObject1, paramBaseArticleInfo);
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      llu.e(paramBaseArticleInfo, localJSONObject1);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("article_model", paramBaseArticleInfo);
      localJSONObject1.put("id_view_AdBanner", localJSONObject2);
    }
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("article_model", paramBaseArticleInfo);
    localJSONObject1.put("id_article_triple_image_interact", localJSONObject2);
    localJSONObject1.put("id_info_operate_parent", new JSONObject());
    localJSONObject1.put("id_ad_triple_container", new JSONObject());
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lle
 * JD-Core Version:    0.7.0.1
 */