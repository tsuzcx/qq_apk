import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ljs
  implements skj.a
{
  ljs(ljr paramljr, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    QLog.d("ReadInJoyWebviewPlugin", 4, "receive readSkinAndSound callback resp:" + paramBundle.toString());
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramBundle = localJSONObject.put("retCode", paramBundle.getInt("retCode")).put("skinId", paramBundle.getString("skinId")).put("volumeIsOn", paramBundle.getInt("volumeIsOn"));
      this.a.callJs(this.afp, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.w("ReadInJoyWebviewPlugin", 1, "readSkinAndSound error " + paramBundle.toString());
      this.a.callJs(this.afp, new String[] { "{\"retCode\":-1}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljs
 * JD-Core Version:    0.7.0.1
 */