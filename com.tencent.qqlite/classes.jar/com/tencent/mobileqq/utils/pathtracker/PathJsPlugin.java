package com.tencent.mobileqq.utils.pathtracker;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import org.json.JSONObject;

public class PathJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String a = "viewTracks";
  private static final String b = "push";
  private static final String c = "pop";
  private static final String d = "getTrackInfo";
  
  protected long getPluginBusiness()
  {
    return 2148007936L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals("viewTracks")) || (TextUtils.isEmpty(paramString3))) {
      bool1 = super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    label189:
    do
    {
      for (;;)
      {
        return bool1;
        if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
          break;
        }
        try
        {
          JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
          String str = localJSONObject.getString("callback");
          if (!paramString3.equals("push")) {
            break label189;
          }
          int i = localJSONObject.optInt("id", -2147483648);
          if (-2147483648 == i) {
            break;
          }
          int j = localJSONObject.optInt("isReport", 0);
          paramJsBridgeListener = new Bundle();
          paramJsBridgeListener.putInt("id", i);
          bool1 = bool2;
          if (j == 1) {
            bool1 = true;
          }
          paramJsBridgeListener.putBoolean("isReport", bool1);
          paramJsBridgeListener = DataFactory.makeIPCRequestPacket("pathPushFrame", str, this.mOnRemoteResp.key, paramJsBridgeListener);
          WebIPCOperator.getInstance().sendServiceIpcReq(paramJsBridgeListener);
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      break;
      if (paramString3.equals("pop"))
      {
        paramJsBridgeListener = DataFactory.makeIPCRequestPacket("pathPopFrame", localException, this.mOnRemoteResp.key, null);
        WebIPCOperator.getInstance().sendServiceIpcReq(paramJsBridgeListener);
        return true;
      }
    } while (!paramString3.equals("getTrackInfo"));
    paramJsBridgeListener = DataFactory.makeIPCRequestPacket("getPathInfo", localException, this.mOnRemoteResp.key, null);
    WebIPCOperator.getInstance().sendServiceIpcReq(paramJsBridgeListener);
    return true;
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    i = -1;
    String str;
    Object localObject;
    JSONObject localJSONObject;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      str = paramBundle.getString("cmd");
      localObject = paramBundle.getBundle("response");
      paramBundle = paramBundle.getString("callbackid");
      if ((str != null) && (localObject != null)) {
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        if ((!str.equals("pathPopFrame")) && (!str.equals("pathPushFrame"))) {
          continue;
        }
        if (((Bundle)localObject).getBoolean("ret")) {
          i = 0;
        }
        localJSONObject.put("result", i);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        i = 0;
        continue;
      }
      callJs(paramBundle, new String[] { localJSONObject.toString() });
      return;
      if (str.equals("getPathInfo"))
      {
        str = ((Bundle)localObject).getString("path");
        if (!TextUtils.isEmpty(str)) {
          continue;
        }
        localObject = new JSONObject();
        ((JSONObject)localObject).put("path", str);
        localJSONObject.put("data", localObject);
        localJSONObject.put("result", i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.pathtracker.PathJsPlugin
 * JD-Core Version:    0.7.0.1
 */