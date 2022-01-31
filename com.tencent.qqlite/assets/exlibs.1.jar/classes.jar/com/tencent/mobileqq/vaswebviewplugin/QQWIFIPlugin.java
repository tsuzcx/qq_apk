package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQWIFIPlugin
  extends VasWebviewJsPlugin
{
  private static final String KEY_FROM = "webfrom";
  private static final String KEY_SID = "sid";
  private static final String tag = "QQWIFIPlugin";
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWIFIPlugin", 2, "url=" + paramString1);
    }
    if ((TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith("qqwifi"))) {
      return false;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      paramJsBridgeListener.a("method empty");
      return true;
    }
    try
    {
      if ("start".equals(paramString3))
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        paramString1 = paramString2.getString("webfrom");
        paramString2 = paramString2.getString("sid");
        paramString3 = new Intent("com.tencent.mobileqq.action.QQWiFi");
        paramString3.putExtra("webfrom", paramString1);
        paramString3.putExtra("sid", paramString2);
        paramString3.setClass(this.mRuntime.a(), JumpActivity.class);
        this.mRuntime.a().startActivity(paramString3);
        return true;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramJsBridgeListener.a("Exception:" + paramString1.getMessage());
      return true;
    }
    paramJsBridgeListener.a("no such method");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQWIFIPlugin
 * JD-Core Version:    0.7.0.1
 */