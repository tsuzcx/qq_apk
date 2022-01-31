package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class BubbleJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String BUSINESS_NAME = "bubble";
  private static final String OBJECT_NAME = "bubble";
  public static final String TAG = "BubbleJsPlugin";
  private Bundle mReqBundle;
  
  protected long getPluginBusiness()
  {
    return 2147483712L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"bubble".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        i = paramString1.indexOf("=");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          throw new Exception("illegal json");
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BubbleJsPlugin", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
      paramJsBridgeListener = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
      paramString1 = paramJsBridgeListener.getString("callback");
      if (paramString1 == null) {
        throw new Exception("need callbackId");
      }
      if ("queryInfo".equals(paramString3))
      {
        queryInfo(paramJsBridgeListener, paramString1);
      }
      else if ("queryLocal".equals(paramString3))
      {
        queryLocal(paramJsBridgeListener, paramString1);
      }
      else if ("setup".equals(paramString3))
      {
        setup(paramJsBridgeListener, paramString1);
      }
      else if ("startDownload".equals(paramString3))
      {
        startDownload(paramJsBridgeListener, paramString1);
      }
      else
      {
        if (!"stopDownload".equals(paramString3)) {
          break;
        }
        stopDownload(paramJsBridgeListener, paramString1);
      }
    }
    throw new Exception(" unsupport method name " + paramString3);
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return handleThemeAndBubbleSchemaRequest(paramString1, paramString2, "bubble");
  }
  
  protected void onCreate()
  {
    this.mReqBundle = new Bundle();
    super.onCreate();
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "onPushMsg=" + paramBundle);
    }
    int i = paramBundle.getInt("srcType");
    int j;
    JSONObject localJSONObject;
    if ((i != 0) && (i == 3))
    {
      i = paramBundle.getInt("id");
      j = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("callbackId");
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("id", i);
      localJSONObject.put("result", j);
      label95:
      callJs(paramBundle + "(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException localJSONException)
    {
      break label95;
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject;
    String str;
    Bundle localBundle;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      localBundle = paramBundle.getBundle("response");
      if (QLog.isColorLevel()) {
        QLog.i("BubbleJsPlugin", 2, "response:" + (String)localObject);
      }
      if ((localObject != null) && (!"setup".equals(localObject))) {
        break label152;
      }
    }
    for (;;)
    {
      label152:
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("result", 0);
        paramBundle.put("message", "ok");
        callJs(str + "(" + paramBundle.toString() + ");");
        return;
      }
      catch (JSONException paramBundle) {}
      if ("queryLocal".equals(localObject))
      {
        if (localBundle == null) {
          continue;
        }
        int i = localBundle.getInt("id");
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("message", "ok");
          localObject = new JSONObject();
          ((JSONObject)localObject).put("currentId", i);
          paramBundle.put("data", localObject);
          paramBundle.put("result", 0);
          callJs(str + "(" + paramBundle.toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          return;
        }
      }
      if ("queryBubbleInfo".equals(localObject))
      {
        if (localBundle == null) {
          continue;
        }
        paramBundle = localBundle.getString("result");
        try
        {
          paramBundle = new JSONObject(paramBundle);
          callJs(str + "(" + paramBundle.toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          return;
        }
      }
      if ("bubble_StopDownLoad".equals(localObject))
      {
        if (localBundle == null) {
          continue;
        }
        paramBundle = localBundle.getString("result");
        try
        {
          paramBundle = new JSONObject(paramBundle);
          callJs(str + "(" + paramBundle.toString() + ");");
          return;
        }
        catch (JSONException paramBundle)
        {
          return;
        }
      }
      super.onResponse(paramBundle);
      return;
    }
  }
  
  public void queryInfo(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "queryInfo " + paramJSONObject.toString());
    }
    int i = paramJSONObject.getInt("id");
    if (i == 0)
    {
      paramJSONObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", 3);
      localJSONObject.put("progress", 100);
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", "本地已存在");
      callJs(paramString + "(" + paramJSONObject.toString() + ");");
      return;
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("queryBubbleInfo", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "queryLocal " + paramJSONObject.toString());
    }
    sendRemoteReq(DataFactory.makeIPCRequestPacket("queryLocal", paramString, this.mOnRemoteResp.key, new Bundle()), false, false);
  }
  
  public void setup(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "setup " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("setup", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  protected boolean shouldGetBusiness()
  {
    return false;
  }
  
  public void startDownload(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "startDownload " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("bubble_startDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void stopDownload(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleJsPlugin", 2, "stopDownload " + paramJSONObject.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("bubble_StopDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin
 * JD-Core Version:    0.7.0.1
 */