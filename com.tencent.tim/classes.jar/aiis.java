import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aiis
  extends WebViewPlugin
{
  skj mClient;
  
  public aiis()
  {
    this.mPluginNameSpace = "connect";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if (("connect".equals(paramString2)) && ("exchangeID".equals(paramString3)) && (paramVarArgs.length > 0)) {}
    try
    {
      paramString3 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString3.optString("appid");
      paramString1 = paramString3.optString("openid");
      paramString2 = paramString3.optString("troopuin");
      paramString3 = paramString3.optString("callback");
      if (this.mClient == null)
      {
        this.mClient = skj.a();
        this.mClient.bzj();
      }
      this.mClient.c(paramJsBridgeListener, paramString1, paramString2, new aiit(this, paramString3));
      bool = true;
    }
    catch (JSONException paramJsBridgeListener)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ConnectApiPlugin", 2, "handleJsRequest JSONException:" + paramJsBridgeListener);
    }
    return bool;
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mClient != null) {
      this.mClient.bzk();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiis
 * JD-Core Version:    0.7.0.1
 */