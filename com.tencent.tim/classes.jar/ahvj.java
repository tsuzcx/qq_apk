import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ahvj
  extends WebViewPlugin
{
  public static String PLUGIN_NAMESPACE = "qqgame_api";
  
  public ahvj()
  {
    this.mPluginNameSpace = PLUGIN_NAMESPACE;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    super.handleEvent(paramString, paramLong, paramMap);
    if (paramLong == 8589934621L)
    {
      paramString = new JSONObject();
      if (paramMap != null) {}
      try
      {
        paramString.put("action", paramMap.get("action"));
        if (paramMap.containsKey("height")) {
          paramString.put("height", paramMap.get("height"));
        }
        if (paramMap.containsKey("index")) {
          paramString.put("index", paramMap.get("index"));
        }
        if (paramMap.containsKey("gameData")) {
          paramString.put("gameData", paramMap.get("gameData"));
        }
      }
      catch (ClassCastException paramMap)
      {
        for (;;)
        {
          paramMap.printStackTrace();
        }
      }
      catch (JSONException paramMap)
      {
        for (;;)
        {
          paramMap.printStackTrace();
        }
      }
      dispatchJsEvent("gameFeedsEvent", paramString, null);
      return true;
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (PLUGIN_NAMESPACE.equals(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameWebViewJsPlugin", 1, "pkgName:" + paramString2 + " method:" + paramString3);
      }
      if ("notifyWebLoaded".equals(paramString3))
      {
        paramJsBridgeListener = new Intent("action_qgame_jaspi_webloaded");
        paramJsBridgeListener.setPackage(BaseApplicationImpl.getApplication().getPackageName());
        BaseApplicationImpl.getApplication().sendBroadcast(paramJsBridgeListener);
        return true;
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvj
 * JD-Core Version:    0.7.0.1
 */