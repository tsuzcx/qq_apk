import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aikm
  implements skj.a
{
  public aikm(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("sayhiinfo");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (TextUtils.isEmpty(paramBundle)) {
        localJSONObject.put("result", "fail");
      }
      for (;;)
      {
        paramBundle = localJSONObject.toString();
        QLog.i("UiApiPlugin", 1, "getTribeSayHelloRedInfo callback result = " + paramBundle);
        this.this$0.callJs(this.val$callback, new String[] { paramBundle });
        return;
        localJSONObject.put("result", "success");
        localJSONObject.put("data", new JSONObject(paramBundle));
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.e("UiApiPlugin", 1, "getTribeSayHelloRedInfo callback Exception:", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikm
 * JD-Core Version:    0.7.0.1
 */