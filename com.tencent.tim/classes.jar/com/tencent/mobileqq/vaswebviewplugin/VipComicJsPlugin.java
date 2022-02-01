package com.tencent.mobileqq.vaswebviewplugin;

import affz;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class VipComicJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String NAMESPACE = "ppreloader";
  public static final String TAG = "Plugin Preloader";
  
  public VipComicJsPlugin()
  {
    this.mPluginNameSpace = "ppreloader";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Plugin Preloader", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"ppreloader".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString1.optString("callback", "");
      boolean bool = "preloadProcess".equals(paramString3);
      if (bool) {
        try
        {
          paramString2 = new Bundle();
          paramString2.putString("processId", paramString1.optString("processId"));
          sendRemoteReq(affz.a("ipc_preload_plugin_process", paramJsBridgeListener, this.mOnRemoteResp.key, paramString2), false, false);
          return true;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          try
          {
            paramString1 = new JSONObject();
            paramString1.put("code", -1);
            paramString1.put("message", "feature not support.");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
      }
      return false;
    }
    catch (Exception paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
      localObject = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
    } while (!"ipc_preload_plugin_process".equals(localObject));
    int i = paramBundle.getInt("code", -1);
    Object localObject = paramBundle.getString("message");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "feature not support";
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("code", i);
      ((JSONObject)localObject).put("message", paramBundle);
      callJs(str, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VipComicJsPlugin
 * JD-Core Version:    0.7.0.1
 */