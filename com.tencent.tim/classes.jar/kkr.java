import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class kkr
{
  public String aae;
  public String aaf;
  public String aag;
  public String aah;
  public String aai;
  public String aaj;
  public String giftDesc;
  public int giftId;
  public String giftName;
  
  public static kkr a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new kkr();
      try
      {
        paramString.giftId = localJSONObject.optInt("gift_id", 0);
        paramString.giftName = localJSONObject.optString("gift_name", "");
        paramString.aae = localJSONObject.optString("activity_id", "");
        paramString.aaf = localJSONObject.optString("gift_icon", "");
        paramString.giftDesc = localJSONObject.optString("gift_desc", "");
        paramString.aag = localJSONObject.optString("bag_item_icon_1", "");
        paramString.aah = localJSONObject.optString("bag_item_icon_2", "");
        paramString.aai = localJSONObject.optString("bag_item_icon_3", "");
        paramString.aaj = localJSONObject.optString("need_role", "");
        return paramString;
      }
      catch (JSONException localJSONException1) {}
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        paramString = null;
      }
    }
    localJSONException1.printStackTrace();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkr
 * JD-Core Version:    0.7.0.1
 */