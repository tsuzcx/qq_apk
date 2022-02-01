import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class kmo
{
  public static JSONObject a(JSONObject paramJSONObject, AdData paramAdData)
  {
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_pk_cell");
      if (paramAdData.mAdExtInfo != null) {
        knd.a(paramJSONObject, paramAdData.mAdvertisementExtInfo);
      }
      if (!TextUtils.isEmpty(paramAdData.title))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.title);
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
      if (!TextUtils.isEmpty(paramAdData.appName))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.appName);
        paramJSONObject.put("id_tv_author", localObject);
      }
    }
    catch (JSONException paramAdData)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInjoy_ad_banner_pk_cell", 2, "JSONException = " + paramAdData.getMessage());
    }
    return paramJSONObject;
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmo
 * JD-Core Version:    0.7.0.1
 */