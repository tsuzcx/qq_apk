package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class BubbleUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "BubbleUiPlugin";
  Client.onRemoteRespObserver mOnRemoteResp = new BubbleUiPlugin.2(this);
  
  private void loadUrl()
  {
    String str = this.activity.getIntent().getStringExtra("pageUrl");
    if ((str != null) && (str.length() > 0)) {
      this.mRuntime.a().loadUrl(str);
    }
    new Handler().postDelayed(new BubbleUiPlugin.1(this), 1000L);
  }
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.activity.K = super.decodeUrl(this.activity.K, true);
    int i = this.activity.getIntent().getIntExtra("bubbleId", -1);
    if (i != -1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      QQBrowserActivity localQQBrowserActivity = this.activity;
      localQQBrowserActivity.K = (localQQBrowserActivity.K + "&cmdex=highlight&id=" + i);
    }
    WebIPCOperator.getInstance().registerObserver(this.mOnRemoteResp);
    if (WebIPCOperator.getInstance().isServiceClientBinded())
    {
      loadUrl();
      if (QLog.isColorLevel()) {
        QLog.i("BubbleUiPlugin", 2, "oncreate -> loading url");
      }
    }
    do
    {
      return;
      this.isHomePageWatingBind = true;
    } while (!QLog.isColorLevel());
    QLog.i("BubbleUiPlugin", 2, "oncreate -> loadurl waiting binding");
  }
  
  void OnActivityDestroy()
  {
    super.OnActivityDestroy();
    WebIPCOperator.getInstance().unRegisterObserver(this.mOnRemoteResp);
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
      this.mRuntime.a().loadUrl("javascript:window.qqJSBridge&&qqJSBridge.setMessage('" + localJSONObject.toString() + "');");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin
 * JD-Core Version:    0.7.0.1
 */