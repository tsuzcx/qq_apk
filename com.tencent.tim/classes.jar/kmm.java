import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class kmm
{
  public static JSONObject a(JSONObject paramJSONObject, AdData paramAdData)
  {
    try
    {
      if (paramAdData.a == null) {
        return paramJSONObject;
      }
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_game_cell");
      if (!TextUtils.isEmpty(paramAdData.alU)) {
        paramJSONObject.put("id_game_small_img", new JSONObject());
      }
      if (!TextUtils.isEmpty(paramAdData.appName))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.appName);
        paramJSONObject.put("id_tv_author", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.content))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.content);
        paramJSONObject.put("id_tv_title", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.imgUrl))
      {
        localObject = obs.a(paramAdData.imgUrl, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_ad_banner_bottom_imge", localJSONObject);
      }
      Object localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramAdData.alV))
      {
        ((JSONObject)localObject).put("text", paramAdData.alV);
        paramJSONObject.put("id_ad_dislike_button", localObject);
      }
      paramJSONObject.put("id_game_operate_area", new JSONObject());
      paramJSONObject.put("id_separator", new JSONObject());
      paramJSONObject.put("id_ad_title", new JSONObject());
      paramJSONObject.put("id_ad_title_rl", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("innerGameModel", paramAdData);
      paramJSONObject.put("id_view_AdDownloadView", localObject);
      return paramJSONObject;
    }
    catch (JSONException paramAdData)
    {
      paramAdData.printStackTrace();
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmm
 * JD-Core Version:    0.7.0.1
 */