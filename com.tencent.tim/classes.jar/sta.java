import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class sta
  implements skj.a
{
  sta(ssx paramssx, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    Object localObject = null;
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getString("content");
      paramBundle = paramBundle.getString("url");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("content", str);
      localJSONObject.put("url", paramBundle);
      paramBundle = localJSONObject.toString();
      this.this$0.callJs(this.val$callback, new String[] { paramBundle });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramBundle = localObject;
        if (QLog.isColorLevel())
        {
          QLog.i("HotchatPlugin", 2, localJSONException.getMessage());
          paramBundle = localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sta
 * JD-Core Version:    0.7.0.1
 */