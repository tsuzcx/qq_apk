import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class aoyf
  implements skj.a
{
  aoyf(aoye paramaoye, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    long l = paramBundle.getLong("lastMsgTime");
    paramBundle = paramBundle.getString("lastMsgContent");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("lastMsgTime", l);
      localJSONObject.put("lastMsgContent", paramBundle);
      if (!TextUtils.isEmpty(paramBundle))
      {
        localJSONObject.put("ret", 0);
        localJSONObject.put("errorMsg", "");
      }
      for (;;)
      {
        this.this$0.callJs(this.val$callback, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("ret", -1);
        localJSONObject.put("errorMsg", "lastSpeakMsg is empty");
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyf
 * JD-Core Version:    0.7.0.1
 */