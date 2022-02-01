import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import org.json.JSONException;
import org.json.JSONObject;

public class kmn
{
  public static JSONObject a(JSONObject paramJSONObject, AdData paramAdData)
  {
    int k = 1;
    for (;;)
    {
      try
      {
        if (paramAdData.a == null) {
          return paramJSONObject;
        }
        paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_game_cell");
        if (!TextUtils.isEmpty(paramAdData.a.gameIcon)) {
          paramJSONObject.put("id_inner_small_img", new JSONObject());
        }
        JSONObject localJSONObject;
        if (!TextUtils.isEmpty(paramAdData.a.gameName))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("text", paramAdData.a.gameName);
          paramJSONObject.put("id_inner_title", localJSONObject);
        }
        if ((!kmx.c(paramAdData)) && (!TextUtils.isEmpty(paramAdData.a.ZO)))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("text", paramAdData.a.ZO);
          paramJSONObject.put("id_inner_category", localJSONObject);
        }
        if (TextUtils.isEmpty(paramAdData.a.a.aag)) {
          break label424;
        }
        paramJSONObject.put("id_inner_game_img1", new JSONObject());
        paramJSONObject.put("id_game_img1_container1", new JSONObject());
        i = 1;
        j = 1;
        if (!TextUtils.isEmpty(paramAdData.a.a.aah))
        {
          paramJSONObject.put("id_inner_game_img2", new JSONObject());
          paramJSONObject.put("id_game_img2_container2", new JSONObject());
          i = 1;
          j = 1;
        }
        if (TextUtils.isEmpty(paramAdData.a.a.aai)) {
          break label421;
        }
        paramJSONObject.put("id_inner_game_img3", new JSONObject());
        paramJSONObject.put("id_game_img3_container3", new JSONObject());
        i = 0;
        j = 1;
        if (!TextUtils.isEmpty(paramAdData.a.a.giftDesc))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("text", paramAdData.a.a.giftDesc);
          paramJSONObject.put("id_inner_ad_name", localJSONObject);
          j = k;
          if (j != 0) {
            paramJSONObject.put("id_bottom_operation", new JSONObject());
          }
          if (i != 0) {
            paramJSONObject.put("id_game_img_right_space", new JSONObject());
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("innerGameModel", paramAdData);
          paramJSONObject.put("id_view_AdDownloadView", localJSONObject);
          return paramJSONObject;
        }
      }
      catch (JSONException paramAdData)
      {
        paramAdData.printStackTrace();
        return paramJSONObject;
      }
      continue;
      label421:
      continue;
      label424:
      int i = 0;
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmn
 * JD-Core Version:    0.7.0.1
 */