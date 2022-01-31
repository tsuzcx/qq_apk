package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.observer.OpenIdInfoObserver;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class QQPluginJsPlugin$1
  extends OpenIdInfoObserver
{
  QQPluginJsPlugin$1(QQPluginJsPlugin paramQQPluginJsPlugin) {}
  
  protected void onOpenIdInfoReceive(boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPluginJsPlugin", 2, "mOpenIdInfoObserver: isSuccess" + paramBoolean);
    }
    Object localObject;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("url");
      long l = paramBundle.getLong("sn");
      paramBundle = new JsBridgeListener(this.this$0.mRuntime.a(), l, (String)localObject);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("openid", paramString1);
      ((JSONObject)localObject).put("openkey", paramString2);
      paramBundle.a(localObject);
      this.this$0.mRuntime.a().unRegistObserver(QQPluginJsPlugin.access$000(this.this$0));
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQPluginJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */