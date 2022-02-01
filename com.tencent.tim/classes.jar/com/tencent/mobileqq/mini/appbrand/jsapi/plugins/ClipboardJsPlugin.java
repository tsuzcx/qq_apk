package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class ClipboardJsPlugin
  extends BaseJsPlugin
{
  public static final String API_GET_CLIPBOARD_DATA = "getClipboardData";
  public static final String API_SET_CLIPBOARD_DATA = "setClipboardData";
  private static final Set<String> S_EVENT_MAP = new ClipboardJsPlugin.1();
  private static final String TAG = "[mini] ClipboardJsPlugin";
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[mini] ClipboardJsPlugin", 2, "handleNativeRequest: " + paramString1 + " |jsonParams: " + paramString2 + " |callbackId:" + paramInt);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString2);
      new Handler(Looper.getMainLooper()).post(new ClipboardJsPlugin.2(this, paramString1, paramJsRuntime, paramInt, localJSONObject1));
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject2 = new JSONObject();
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ClipboardJsPlugin
 * JD-Core Version:    0.7.0.1
 */