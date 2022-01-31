package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import fzs;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventApiPlugin
  extends WebViewPlugin
{
  static final String jdField_a_of_type_JavaLangString = "com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public String b;
  
  public EventApiPlugin()
  {
    this.a = new fzs(this);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("event".equals(paramString2)) {
      if ((!"dispatchEvent".equals(paramString3)) || (paramVarArgs.length != 1)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        paramString3 = this.mRuntime.a();
        if (paramString3 == null) {
          return true;
        }
        paramString2 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString2.optString("event");
        if (TextUtils.isEmpty(paramJsBridgeListener))
        {
          if (!QLog.isColorLevel()) {
            break label388;
          }
          QLog.w(this.TAG, 2, "param event is requested");
          break label388;
        }
        paramString1 = paramString2.optJSONObject("data");
        paramVarArgs = paramString2.optJSONObject("options");
        int m = 1;
        int k = 1;
        paramString2 = new ArrayList();
        paramString3 = paramString3.getUrl();
        if (paramVarArgs != null)
        {
          boolean bool1 = paramVarArgs.optBoolean("echo", true);
          boolean bool2 = paramVarArgs.optBoolean("broadcast", true);
          paramVarArgs = paramVarArgs.optJSONArray("domains");
          k = bool2;
          m = bool1;
          if (paramVarArgs != null)
          {
            i = 0;
            int j = paramVarArgs.length();
            k = bool2;
            m = bool1;
            if (i < j)
            {
              String str = paramVarArgs.optString(i);
              if (TextUtils.isEmpty(str)) {
                break label390;
              }
              paramString2.add(str);
              break label390;
            }
          }
        }
        paramVarArgs = new JSONObject();
        paramVarArgs.put("url", paramString3);
        if (k != 0)
        {
          if ((paramString2.size() == 0) && (paramString3 != null))
          {
            paramString3 = Uri.parse(paramString3);
            if (paramString3.isHierarchical()) {
              paramString2.add(paramString3.getHost());
            }
          }
          paramString3 = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
          paramString3.putExtra("unique", this.b);
          paramString3.putExtra("event", paramJsBridgeListener);
          if (paramString1 != null) {
            paramString3.putExtra("data", paramString1.toString());
          }
          paramString3.putStringArrayListExtra("domains", paramString2);
          paramString3.putExtra("source", paramVarArgs.toString());
          BaseApplicationImpl.getContext().sendBroadcast(paramString3, "com.tencent.msg.permission.pushnotify");
        }
        if (m != 0) {
          dispatchJsEvent(paramJsBridgeListener, paramString1, paramVarArgs);
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        continue;
      }
      return true;
      return false;
      label388:
      return true;
      label390:
      i += 1;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    Activity localActivity = this.mRuntime.a();
    this.b = (Long.toString(System.currentTimeMillis()) + Integer.toString(localActivity.hashCode()));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    localActivity.registerReceiver(this.a, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mRuntime.a().unregisterReceiver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.EventApiPlugin
 * JD-Core Version:    0.7.0.1
 */