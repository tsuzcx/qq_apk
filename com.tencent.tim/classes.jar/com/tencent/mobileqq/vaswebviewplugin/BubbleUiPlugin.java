package com.tencent.mobileqq.vaswebviewplugin;

import afjy;
import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class BubbleUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "BubbleUiPlugin";
  Client.b mOnRemoteResp = new BubbleUiPlugin.2(this);
  
  void OnActivityDestroy()
  {
    super.OnActivityDestroy();
    afjy.a().b(this.mOnRemoteResp);
  }
  
  void OnActivityResume()
  {
    super.OnActivityResume();
    afjy.a().a(this.mOnRemoteResp);
    if (afjy.a().ajq())
    {
      reportBubbleSetting();
      if (QLog.isColorLevel()) {
        QLog.i("BubbleUiPlugin", 2, "OnActivityResume -> loading url");
      }
    }
    do
    {
      return;
      this.isHomePageWatingBind = true;
    } while (!QLog.isColorLevel());
    QLog.i("BubbleUiPlugin", 2, "OnActivityResume -> loadurl waiting binding");
  }
  
  protected long getPluginBusiness()
  {
    return 64L;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleUiPlugin", 2, "BaseWebActivity onActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return false;
    }
    try
    {
      String str = paramIntent.getStringExtra("callbackSn");
      paramIntent = paramIntent.getStringExtra("result");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("responseId", str);
      localJSONObject.put("responseData", new JSONObject(paramIntent));
      if (QLog.isColorLevel()) {
        QLog.i("BubbleUiPlugin", 2, "BaseWebActivity loadUrl setMessage =" + localJSONObject.toString());
      }
      this.mRuntime.getWebView().loadUrl("javascript:window.qqJSBridge&&qqJSBridge.setMessage('" + localJSONObject.toString() + "');");
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
    return true;
  }
  
  public void reportBubbleSetting()
  {
    new Handler().postDelayed(new BubbleUiPlugin.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin
 * JD-Core Version:    0.7.0.1
 */