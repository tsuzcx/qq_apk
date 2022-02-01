import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class lll
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    llu.a(paramBaseArticleInfo, localJSONObject, true);
    llu.c(paramBaseArticleInfo, localJSONObject);
    llu.a(paramBaseArticleInfo, localJSONObject);
    llu.f(paramBaseArticleInfo, localJSONObject);
    llu.m(paramBaseArticleInfo, localJSONObject);
    llu.h(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    llu.a(localJSONObject, paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lll
 * JD-Core Version:    0.7.0.1
 */