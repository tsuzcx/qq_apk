import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aijs
  extends WebViewPlugin
{
  jol.a a = new aijt(this);
  String bOk;
  skj mClient;
  
  public aijs()
  {
    this.mPluginNameSpace = "push";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"push".equals(paramString2)) || (("addListener".equals(paramString3)) && (paramVarArgs.length > 0))) {}
    for (;;)
    {
      int i;
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        i = paramJsBridgeListener.optInt("appid");
        this.bOk = paramJsBridgeListener.optString("callback");
        this.mClient.a().a(i, this.a);
        if (QLog.isColorLevel()) {
          QLog.d("PushApiPlugin", 2, new Object[] { paramString2, ".", paramString3, " args:", paramJsBridgeListener.toString() });
        }
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PushApiPlugin", 2, new Object[] { "handleJsRequest pkgName:", paramString2, " method:", paramString3, " JSONException:", paramJsBridgeListener });
        }
        return false;
      }
      if (("removeListener".equals(paramString3)) && (paramVarArgs.length > 0)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          i = paramJsBridgeListener.optInt("appid");
          this.mClient.a().oa(i);
          if (QLog.isColorLevel()) {
            QLog.d("PushApiPlugin", 2, new Object[] { paramString2, ".", paramString3, " args:", paramJsBridgeListener.toString() });
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PushApiPlugin", 2, new Object[] { "handleJsRequest pkgName:", paramString2, " method:", paramString3, " JSONException:", paramJsBridgeListener });
          }
        }
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mClient == null)
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
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
 * Qualified Name:     aijs
 * JD-Core Version:    0.7.0.1
 */