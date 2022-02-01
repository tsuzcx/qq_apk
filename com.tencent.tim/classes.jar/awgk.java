import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

class awgk
  implements awgj.a
{
  awgk(awgj paramawgj) {}
  
  public void e(JSONObject paramJSONObject, Bundle paramBundle)
    throws JSONException
  {
    paramJSONObject.put("recommend_on", paramBundle.getString("recommend_on"));
    paramJSONObject.put("recommendPush_on", paramBundle.getString("recommendPush_on"));
    paramJSONObject.put("recommendNotification_on", paramBundle.getString("recommendNotification_on"));
    paramJSONObject.put("recommendChatCachePhoto_on", paramBundle.getString("recommendChatCachePhoto_on"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgk
 * JD-Core Version:    0.7.0.1
 */