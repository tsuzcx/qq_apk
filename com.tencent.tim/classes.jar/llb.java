import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class llb
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = localJSONObject2;
    if (paramBaseArticleInfo != null)
    {
      localJSONObject1 = localJSONObject2;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.smallGameData)) {
        localJSONObject1 = new JSONObject(paramBaseArticleInfo.smallGameData);
      }
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     llb
 * JD-Core Version:    0.7.0.1
 */