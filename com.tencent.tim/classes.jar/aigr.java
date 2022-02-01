import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aigr
  extends aidi
  implements skj.a
{
  private String aEt;
  
  public aigr()
  {
    this.mPluginNameSpace = "odapp";
  }
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    while ((!"onOpenRoomResult".equals(paramBundle.getString("method"))) || (this.aEt == null)) {
      return;
    }
    int i = paramBundle.getInt("code", 0);
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("code", i);
      callJs(this.aEt, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"odapp".equals(paramString2)) {}
    label129:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("XProxy|ODAppJSPlugin", 2, "handleJsRequest: url = " + paramString1 + ", pkgName = " + paramString2 + ", method = " + paramString3 + ", args = " + paramVarArgs);
      }
      if ((TextUtils.equals(paramString3, "open")) || (TextUtils.equals(paramString3, "cancelPage")))
      {
        super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
        return false;
      }
      paramString2 = "";
      paramString1 = "";
      paramJsBridgeListener = null;
      try
      {
        localObject = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = (JsBridgeListener)localObject;
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        break label129;
        int j = 0;
        int i = 0;
        paramJsBridgeListener = paramString2;
        continue;
      }
      if (paramJsBridgeListener == null) {
        break;
      }
      localObject = paramJsBridgeListener.optString("callback");
      i = paramJsBridgeListener.optInt("roomid");
      paramString2 = paramJsBridgeListener.optString("vasname");
      paramString1 = paramJsBridgeListener.optString("userdata");
      j = paramJsBridgeListener.optInt("fromid");
      this.aEt = ((String)localObject);
      paramJsBridgeListener = paramString2;
    } while ((!"odOpenRoom".equals(paramString3)) || (paramVarArgs.length != 1));
    this.mClient.a(0, i, paramJsBridgeListener, paramString1, j);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigr
 * JD-Core Version:    0.7.0.1
 */