import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class lkw
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramBaseArticleInfo.avatar)) {
      localJSONObject1.put("avator_url", "default_comment_avatar");
    }
    for (;;)
    {
      llu.r(paramBaseArticleInfo, localJSONObject1);
      llu.a(paramBaseArticleInfo, localJSONObject1, true);
      knd.b(paramBaseArticleInfo, localJSONObject1);
      knd.a(paramBaseArticleInfo, localJSONObject1);
      llu.m(paramBaseArticleInfo, localJSONObject1);
      llu.f(paramBaseArticleInfo, localJSONObject1);
      llu.h(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_ad_brand_optimization_cell");
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
      localJSONObject1.put("id_article_brand_optimization", localJSONObject2);
      localJSONObject1.put("id_info_operate_parent", new JSONObject());
      localJSONObject1.put("id_ad_brand_container", new JSONObject());
      return localJSONObject1;
      localJSONObject1.put("avator_url", paramBaseArticleInfo.avatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lkw
 * JD-Core Version:    0.7.0.1
 */