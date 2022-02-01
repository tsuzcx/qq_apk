import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class llc
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    String str;
    if (paramBaseArticleInfo.mSinglePicture != null)
    {
      str = paramBaseArticleInfo.mSinglePicture.getFile();
      localJSONObject2.put("article_small_imge_url", str);
      localJSONObject1.put("id_article_small_imge", localJSONObject2);
      llu.a(paramBaseArticleInfo, localJSONObject1, true);
      knd.b(paramBaseArticleInfo, localJSONObject1);
      llu.a(paramBaseArticleInfo, localJSONObject1);
      llu.f(paramBaseArticleInfo, localJSONObject1);
      llu.m(paramBaseArticleInfo, localJSONObject1);
      llu.h(paramBaseArticleInfo, localJSONObject1);
      llu.aa(paramBaseArticleInfo, localJSONObject1);
      if (!jzk.a(paramBaseArticleInfo)) {
        break label125;
      }
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_location_cell");
    }
    for (;;)
    {
      localJSONObject1.put("id_small_cell_container", new JSONObject());
      llu.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      str = null;
      break;
      label125:
      localJSONObject1.put("style_ID", "ReadInjoy_ad_small_cell");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     llc
 * JD-Core Version:    0.7.0.1
 */