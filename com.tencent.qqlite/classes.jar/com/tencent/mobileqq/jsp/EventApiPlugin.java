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
import dwm;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventApiPlugin
  extends WebViewPlugin
{
  public static final String a = "com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT";
  static final String b = "broadcast";
  static final String c = "unique";
  static final String d = "event";
  static final String e = "data";
  static final String f = "domains";
  static final String g = "source";
  static final String h = "echo";
  static final String i = "url";
  static final String j = "options";
  static final String k = "com.tencent.msg.permission.pushnotify";
  BroadcastReceiver a = new dwm(this);
  public String l;
  
  public static void a(String paramString1, JSONObject paramJSONObject, ArrayList paramArrayList, String paramString2)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    localIntent.putExtra("event", paramString1);
    if (paramJSONObject != null) {
      localIntent.putExtra("data", paramJSONObject.toString());
    }
    localIntent.putStringArrayListExtra("domains", paramArrayList);
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("url", paramString2);
      label61:
      localIntent.putExtra("source", paramString1.toString());
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label61;
    }
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 22)
    {
      paramString = new JSONObject();
      if (paramMap != null) {}
      try
      {
        paramString.put("x", (Integer)paramMap.get("X"));
        paramString.put("y", (Integer)paramMap.get("Y"));
        dispatchJsEvent("qbrowserTitleBarClick", paramString, null);
        return true;
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "ClassCastException, " + paramMap.get("X") + ", " + paramMap.get("Y"));
          }
          localClassCastException.printStackTrace();
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "JSONException, " + paramMap.get("X") + ", " + paramMap.get("Y"));
          }
          localJSONException.printStackTrace();
        }
      }
    }
    if (paramInt == 23)
    {
      dispatchJsEvent("qbrowserOptionsButtonClick", null, null);
      return true;
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("event".equals(paramString2)) {
      if ((!"dispatchEvent".equals(paramString3)) || (paramVarArgs.length != 1)) {}
    }
    for (;;)
    {
      int m;
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
            break label393;
          }
          QLog.w(this.TAG, 2, "param event is requested");
          break label393;
        }
        paramString1 = paramString2.optJSONObject("data");
        paramVarArgs = paramString2.optJSONObject("options");
        int i1 = 1;
        boolean bool1 = true;
        paramString2 = new ArrayList();
        paramString3 = paramString3.getUrl();
        if (paramVarArgs != null)
        {
          boolean bool2 = paramVarArgs.optBoolean("echo", true);
          boolean bool3 = paramVarArgs.optBoolean("broadcast", true);
          paramVarArgs = paramVarArgs.optJSONArray("domains");
          bool1 = bool3;
          i1 = bool2;
          if (paramVarArgs != null)
          {
            m = 0;
            int n = paramVarArgs.length();
            bool1 = bool3;
            i1 = bool2;
            if (m < n)
            {
              String str = paramVarArgs.optString(m);
              if (TextUtils.isEmpty(str)) {
                break label395;
              }
              paramString2.add(str);
              break label395;
            }
          }
        }
        paramVarArgs = new JSONObject();
        paramVarArgs.put("url", paramString3);
        if ((paramString2.size() == 0) && (paramString3 != null))
        {
          paramString3 = Uri.parse(paramString3);
          if (paramString3.isHierarchical()) {
            paramString2.add(paramString3.getHost());
          }
        }
        paramString3 = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        paramString3.putExtra("broadcast", bool1);
        paramString3.putExtra("unique", this.l);
        paramString3.putExtra("event", paramJsBridgeListener);
        if (paramString1 != null) {
          paramString3.putExtra("data", paramString1.toString());
        }
        paramString3.putStringArrayListExtra("domains", paramString2);
        paramString3.putExtra("source", paramVarArgs.toString());
        BaseApplicationImpl.getContext().sendBroadcast(paramString3, "com.tencent.msg.permission.pushnotify");
        if (i1 != 0) {
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
      label393:
      return true;
      label395:
      m += 1;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    Activity localActivity = this.mRuntime.a();
    this.l = (Long.toString(System.currentTimeMillis()) + Integer.toString(localActivity.hashCode()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.EventApiPlugin
 * JD-Core Version:    0.7.0.1
 */