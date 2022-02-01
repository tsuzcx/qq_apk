import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class kmp
{
  public static JSONObject a(JSONObject paramJSONObject, AdData paramAdData)
  {
    try
    {
      if (paramAdData.a == null) {
        return paramJSONObject;
      }
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_triple_pic_game_cell");
      if (!TextUtils.isEmpty(paramAdData.alU)) {
        paramJSONObject.put("id_game_small_img", new JSONObject());
      }
      if (!TextUtils.isEmpty(paramAdData.appName))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("text", paramAdData.appName);
        paramJSONObject.put("id_tv_author", localObject1);
      }
      if (!TextUtils.isEmpty(paramAdData.content))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("text", paramAdData.content);
        paramJSONObject.put("id_tv_title", localObject1);
      }
      if ((paramAdData.lH != null) && (paramAdData.lH.size() > 2))
      {
        Object localObject3 = obs.a((String)paramAdData.lH.get(0), 4);
        Object localObject2 = obs.a((String)paramAdData.lH.get(1), 4);
        localObject1 = obs.a((String)paramAdData.lH.get(2), 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("multi_img_url1", ((URL)localObject3).toString());
        paramJSONObject.put("id_multi_img_1", localJSONObject);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("multi_img_url2", ((URL)localObject2).toString());
        paramJSONObject.put("id_multi_img_2", localObject3);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("multi_img_url3", ((URL)localObject1).toString());
        paramJSONObject.put("id_multi_img_3", localObject2);
      }
      paramJSONObject.put("id_ad_triple_imge_container", new JSONObject());
      Object localObject1 = new JSONObject();
      if (!TextUtils.isEmpty(paramAdData.alV))
      {
        ((JSONObject)localObject1).put("text", paramAdData.alV);
        paramJSONObject.put("id_ad_dislike_button", localObject1);
      }
      paramJSONObject.put("id_game_operate_area", new JSONObject());
      paramJSONObject.put("id_separator", new JSONObject());
      paramJSONObject.put("id_ad_title", new JSONObject());
      paramJSONObject.put("id_ad_title_rl", new JSONObject());
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("innerGameModel", paramAdData);
      paramJSONObject.put("id_view_AdDownloadView", localObject1);
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
 * Qualified Name:     kmp
 * JD-Core Version:    0.7.0.1
 */