package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.observer.OpenIdInfoObserver;
import com.tencent.mobileqq.servlet.OpenIdInfoServlet;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QQPluginJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String OBJECT_NAME = "qw_qqplugin";
  public static final int REQUEST_CODE_PLUGIN_WIFI = 301;
  private static final String TAG = "QQPluginJsPlugin";
  private OpenIdInfoObserver mOpenIdInfoObserver = new QQPluginJsPlugin.1(this);
  
  protected long getPluginBusiness()
  {
    return 2147491840L;
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (9 == paramInt) {}
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"qw_qqplugin".equals(paramString2)) {}
    do
    {
      return false;
      if (TextUtils.isEmpty(paramString3))
      {
        paramJsBridgeListener.a("no such method");
        return true;
      }
      if (("queryPlugin".equals(paramString3)) || ("downloadPlugin".equals(paramString3)) || ("cancelDownloadPlugin".equals(paramString3)))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null)) {
          try
          {
            paramVarArgs = new JSONObject(paramVarArgs[0]).getString("pluginid");
            if (QLog.isColorLevel()) {
              QLog.i("QQPluginJsPlugin", 2, "qw_qqplugin:" + paramString3 + "--" + paramVarArgs);
            }
            paramString2 = new Bundle();
            paramString2.putString("pluginid", paramVarArgs);
            paramString2.putString("url", paramString1);
            paramString2.putLong("sn", paramJsBridgeListener.a);
            if ("queryPlugin".equals(paramString3)) {
              paramString1 = "queryPlugin";
            }
            for (;;)
            {
              paramString1 = DataFactory.makeIPCRequestPacket(paramString1, "", this.mOnRemoteResp.key, paramString2);
              WebIPCOperator.getInstance().sendServiceIpcReq(paramString1);
              break;
              if ("downloadPlugin".equals(paramString3)) {
                paramString1 = "downloadPlugin";
              } else {
                paramString1 = "cancelDownloadPlugin";
              }
            }
            paramJsBridgeListener.a("method args error");
          }
          catch (JSONException paramString1)
          {
            paramJsBridgeListener.a("JSONException:" + paramString1.getMessage());
            paramString1.printStackTrace();
          }
          catch (Exception paramString1)
          {
            paramJsBridgeListener.a("Exception:" + paramString1.getMessage());
            paramString1.printStackTrace();
          }
        }
        break;
      }
    } while (!"getOpenIdInfo".equals(paramString3));
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null)) {}
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramVarArgs[0]).getInt("appid");
        if (QLog.isColorLevel()) {
          QLog.i("QQPluginJsPlugin", 2, "qw_qqplugin:getOpenIdInfo--" + i);
        }
        paramString2 = new Bundle();
        paramString2.putString("url", paramString1);
        paramString2.putLong("sn", paramJsBridgeListener.a);
        this.mRuntime.a().registObserver(this.mOpenIdInfoObserver);
        OpenIdInfoServlet.a(this.mRuntime.a(), i, paramString2);
      }
      catch (JSONException paramString1)
      {
        paramJsBridgeListener.a("JSONException:" + paramString1.getMessage());
        paramString1.printStackTrace();
        continue;
      }
      catch (Exception paramString1)
      {
        paramJsBridgeListener.a("Exception:" + paramString1.getMessage());
        paramString1.printStackTrace();
        continue;
      }
      return true;
      paramJsBridgeListener.a("method args error");
    }
    return true;
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject2;
    Bundle localBundle;
    Object localObject1;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject2 = paramBundle.getString("cmd");
      localBundle = paramBundle.getBundle("response");
      localObject1 = localBundle.getString("url");
      long l = localBundle.getLong("sn", 0L);
      localObject1 = new JsBridgeListener(this.mRuntime.a(), l, (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("QQPluginJsPlugin", 2, "response:" + (String)localObject2);
      }
      if (localObject2 != null)
      {
        if (!"queryPlugin".equals(localObject2)) {
          break label197;
        }
        localObject2 = new JSONObject();
      }
    }
    label197:
    do
    {
      try
      {
        ((JSONObject)localObject2).put("erro", paramBundle.getBoolean("erro", false));
        ((JSONObject)localObject2).put("progress", (int)(localBundle.getFloat("progress", 0.0F) * 100.0F));
        ((JSONObject)localObject2).put("state", localBundle.getInt("state", 0));
        ((JsBridgeListener)localObject1).a(localObject2);
        return;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
      if ("downloadPlugin".equals(localObject2))
      {
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("installed", localBundle.getBoolean("installed", false));
          ((JsBridgeListener)localObject1).a(paramBundle);
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
    } while (!"cancelDownloadPlugin".equals(localObject2));
    ((JsBridgeListener)localObject1).a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQPluginJsPlugin
 * JD-Core Version:    0.7.0.1
 */