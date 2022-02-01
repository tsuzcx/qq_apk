import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ljv
  implements skj.a
{
  ljv(ljr paramljr, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("ReadInJoyWebviewPlugin", 4, "receive setSkinAndSound callback resp:" + paramBundle.toString());
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramBundle = localJSONObject.put("retCode", paramBundle.getInt("retCode")).put("skinId", "" + paramBundle.getString("skinId"));
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
 * Qualified Name:     ljv
 * JD-Core Version:    0.7.0.1
 */