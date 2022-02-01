package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aqzd;
import avoq;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WeizhengquanJsPlugin
  extends aqzd
{
  private final String aHA = "pushMusicInfo";
  private final String aHz = "getPayAdInfo";
  Activity activity;
  String callback = "";
  
  private void a(JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeizhengquanJsPlugin", 2, "prosGetPayAdInfo...");
    }
    if (!(this.mRuntime.a() instanceof avoq)) {
      QLog.i("WeizhengquanJsPlugin", 2, "activity error : " + this.activity);
    }
    do
    {
      return;
      i = ((avoq)this.mRuntime.a()).dD();
      QLog.i("WeizhengquanJsPlugin", 2, "bzCode = " + i);
    } while (1 != i);
    paramVarArgs = (Bundle)((avoq)this.mRuntime.a()).t();
    if (paramVarArgs == null)
    {
      QLog.i("WeizhengquanJsPlugin", 2, "error bundle is null...");
      return;
    }
    paramJsBridgeListener = paramVarArgs.getString("paySuccJsonData");
    int i = paramVarArgs.getInt("ScreenHeight");
    int j = paramVarArgs.getInt("PayHeight");
    int k = paramVarArgs.getInt("ADHeight");
    QLog.i("WeizhengquanJsPlugin", 2, "data = " + paramJsBridgeListener + " sh = " + i + " ph = " + j + " ah = " + k);
    try
    {
      paramVarArgs = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ScreenHeight", i);
      localJSONObject.put("PayHeight", j);
      localJSONObject.put("ADHeight", k);
      paramVarArgs.put("display", localJSONObject);
      paramVarArgs.put("paySuccJsonData", paramJsBridgeListener);
      QLog.i("WeizhengquanJsPlugin", 2, this.callback + " => " + paramVarArgs);
      callJs(this.callback, new String[] { paramVarArgs.toString() });
      return;
    }
    catch (JSONException paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
    }
  }
  
  private String b(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || (TextUtils.isEmpty(paramVarArgs[0])))
    {
      QLog.i("WeizhengquanJsPlugin", 2, "parameter error..." + paramVarArgs);
      return null;
    }
    QLog.i("WeizhengquanJsPlugin", 2, "arg[0] = " + paramVarArgs[0]);
    try
    {
      this.callback = new JSONObject(paramVarArgs[0]).optString("callback");
      QLog.i("WeizhengquanJsPlugin", 2, "parameter callback = " + this.callback);
      return this.callback;
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private void b(JsBridgeListener paramJsBridgeListener, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeizhengquanJsPlugin", 2, "prosPushMusicInfo...");
    }
    if (paramVarArgs.length <= 0)
    {
      QLog.i("WeizhengquanJsPlugin", 2, "error, parameters empty...");
      return;
    }
    try
    {
      paramJsBridgeListener = new JSONObject();
      paramJsBridgeListener.put("ret_code", "0");
      paramJsBridgeListener.put("ret_msg", "success");
      callJs(this.callback, new String[] { paramJsBridgeListener.toString() });
      paramJsBridgeListener = new Intent();
      paramJsBridgeListener.putExtra("h5arg", paramVarArgs[0]);
      this.activity.setResult(-1, paramJsBridgeListener);
      this.activity.finish();
      return;
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
      }
    }
  }
  
  public String getNameSpace()
  {
    return "qw";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    QLog.d("WeizhengquanJsPlugin", 2, "handleJsRequest url = " + paramString1 + " pkgName = " + paramString2 + " methodName = " + paramString3 + " arg.length = " + paramVarArgs.length);
    if (!getNameSpace().equals(paramString2)) {}
    do
    {
      return false;
      this.callback = b(paramVarArgs);
      if (TextUtils.isEmpty(this.callback))
      {
        QLog.d("WeizhengquanJsPlugin", 2, "function name is null...");
        return true;
      }
      if ("getPayAdInfo".equals(paramString3))
      {
        a(paramJsBridgeListener, paramVarArgs);
        return true;
      }
    } while (!"pushMusicInfo".equals(paramString3));
    b(paramJsBridgeListener, paramVarArgs);
    return true;
  }
  
  public void onCreate()
  {
    this.activity = this.mRuntime.getActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WeizhengquanJsPlugin
 * JD-Core Version:    0.7.0.1
 */