package com.tencent.biz.eqq;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class EqqWebviewPlugin
  extends WebViewPlugin
{
  public static final String a = "EqqWebviewPlugin";
  public static final String b = "eqq";
  protected Activity a;
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        paramString = new JSONObject(paramString).getString("uin");
        Intent localIntent = new Intent(this.a, EnterpriseDetailActivity.class);
        localIntent.putExtra("uin", paramString);
        this.a.startActivity(localIntent);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("EqqWebviewPlugin", 2, "showEqq json error!");
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"eqq".equals(paramString2)) {}
    while (!"showEQQ".equals(paramString3)) {
      return false;
    }
    if (paramVarArgs.length > 0) {
      a(paramVarArgs[0]);
    }
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.eqq.EqqWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */