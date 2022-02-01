package com.tencent.mobileqq.webview.sonic;

import android.text.TextUtils;
import aqqj;
import aqze;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicSession;
import java.util.ArrayList;
import org.json.JSONObject;

public class SonicJsPlugin
  extends WebViewPlugin
  implements aqze
{
  public static final String METHOD_GET_DIFF_DATA = "getDiffData";
  public static final String METHOD_GET_SWIFT_HTTP_DIFF_DATA = "getSwiftHttpDiffData";
  public static final String METHOD_PRELOAD = "preload";
  public static final String METHOD_RELOAD = "reloadHttpData";
  public static final String PACKAGE_NAME_SONIC = "sonic";
  public static final String PACKAGE_NAME_SWIFT = "SwiftHttp";
  public static final String TAG = "SonicSdkImpl_SonicJsPlugin";
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "SwiftHttp", "sonic" };
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((!"SwiftHttp".equals(paramString2)) && (!"sonic".equals(paramString2))) {
      return false;
    }
    paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString2 == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, "handleJsRequest JSON = " + paramString2.toString());
    }
    paramJsBridgeListener = paramString2.optString("callback");
    if (("getSwiftHttpDiffData".equals(paramString3)) || ("getDiffData".equals(paramString3)))
    {
      if (TextUtils.isEmpty(paramJsBridgeListener))
      {
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      paramString1 = this.mRuntime.getWebView();
      if (paramString1 != null)
      {
        paramString2 = paramString1.getSonicClient();
        if ((paramString2 != null) && (paramString2.getSession() != null)) {
          paramString2.getDiffData(new SonicJsPlugin.1(this, paramString1, paramJsBridgeListener));
        }
      }
      return true;
    }
    if ("preload".equals(paramString3))
    {
      if (TextUtils.isEmpty(paramJsBridgeListener))
      {
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      paramString1 = new JSONObject();
    }
    for (;;)
    {
      boolean bool;
      try
      {
        paramString3 = paramString2.optString("url");
        bool = paramString2.optBoolean("isAccountRelated", true);
        if (!TextUtils.isEmpty(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SonicSdkImpl_SonicJsPlugin", 2, "handleJsRequest preload session, preload url = " + paramString3);
          }
          paramString2 = new SonicPreloadData(0, aqqj.a(BaseApplicationImpl.sApplication.getRuntime(), paramString3, ""), bool, 0L, 1);
          paramString3 = new ArrayList();
          paramString3.add(paramString2);
          if (!SonicPreloader.preload(paramString3)) {
            break label562;
          }
          i = 1;
          paramString1.put("result", i);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          return true;
        }
        paramString1.put("result", 0);
        callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      }
      catch (Exception paramString2)
      {
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "handleJsRequest preload session, exception, e =  " + paramString2.getMessage());
        try
        {
          paramString1.put("result", 0);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        }
        catch (Exception paramJsBridgeListener) {}
        continue;
      }
      return true;
      if ("reloadHttpData".equalsIgnoreCase(paramString3))
      {
        paramJsBridgeListener = paramString2.optString("callback");
        bool = paramString2.optBoolean("needData");
        if (TextUtils.isEmpty(paramJsBridgeListener))
        {
          QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "ReloadCallbackId id is null, so return");
          return true;
        }
        paramString1 = this.mRuntime.getWebView();
        if (paramString1 != null)
        {
          paramString2 = paramString1.getSonicClient();
          if ((paramString2 != null) && (paramString2.getSession() != null))
          {
            paramString1.getSonicClient().getSession().refresh();
            paramString2.getDiffData(new SonicJsPlugin.2(this, bool, paramString1, paramJsBridgeListener));
          }
        }
        return true;
      }
      return false;
      label562:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicJsPlugin
 * JD-Core Version:    0.7.0.1
 */