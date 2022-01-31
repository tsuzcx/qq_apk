package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class WebViewPlugin
{
  public static final int EVENT_ACTIVITY_CREATE = 3;
  public static final int EVENT_ACTIVITY_DESTROY = 4;
  public static final int EVENT_ACTIVITY_ONRESULT = 9;
  public static final int EVENT_ACTIVITY_PAUSE = 6;
  public static final int EVENT_ACTIVITY_RESUME = 5;
  public static final int EVENT_AFTER_ACTIVITY_FINISH = 8;
  public static final int EVENT_AVATAR_PENDANT_HOME_ONNEWINTENT = 20;
  public static final int EVENT_BEFORE_ACTIVITY_FINISH = 7;
  public static int EVENT_BEFORE_LOAD = 21;
  public static final int EVENT_DEMOJI_ACTIVITYRESULT_REMAKE = 15;
  public static final int EVENT_FORWARD = 13;
  public static final int EVENT_GO_BACK = 12;
  public static final int EVENT_LOAD_ERROR = 2;
  public static final int EVENT_LOAD_FINISH = 1;
  public static final int EVENT_LOAD_RESOURCE = 11;
  public static final int EVENT_LOAD_START = 0;
  public static final int EVENT_OFFLINE_UPDATE = 10;
  public static final int EVENT_SWITCH_URL = 14;
  public static final int EVENT_THEME_POSTCHANGED = 17;
  public static final String KEY_ERROR_CODE = "errorCode";
  protected final String TAG = getClass().getSimpleName();
  private AtomicBoolean inited = new AtomicBoolean(false);
  protected boolean isDestroy = false;
  public WebViewPlugin.PluginRuntime mRuntime;
  
  @Deprecated
  public void callJs(String paramString)
  {
    if (this.isDestroy) {
      return;
    }
    QQBrowserActivity.c(this.mRuntime.a(), paramString);
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (this.isDestroy) {
      return;
    }
    this.mRuntime.a();
    QQBrowserActivity.a(this.mRuntime.a(), paramString, paramVarArgs);
  }
  
  public void dispatchJsEvent(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    callJs("window.mqq && mqq.execEventCallback && mqq.execEventCallback(" + Util.b(paramString) + "," + String.valueOf(paramJSONObject1) + "," + String.valueOf(paramJSONObject2) + ");");
  }
  
  public int getRequestCode(byte paramByte)
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity instanceof WebViewPluginContainer)) {
      return ((WebViewPluginContainer)localActivity).a(this, paramByte);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
    }
    return -1;
  }
  
  protected Object handleEvent(String paramString, int paramInt)
  {
    return null;
  }
  
  public boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return false;
  }
  
  final void initRuntime(WebView paramWebView, Activity paramActivity, AppInterface paramAppInterface)
  {
    if (this.inited.compareAndSet(false, true)) {
      this.mRuntime = new WebViewPlugin.PluginRuntime(paramWebView, paramActivity, paramAppInterface);
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt) {}
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    this.isDestroy = true;
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity instanceof WebViewPluginContainer)) {
      ((WebViewPluginContainer)localActivity).a(this, paramIntent, paramByte);
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d(this.TAG, 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewPlugin
 * JD-Core Version:    0.7.0.1
 */