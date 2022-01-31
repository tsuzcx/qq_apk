package com.tencent.mobileqq.jsbridge;

import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

public class WebBridge
{
  public static final String a = "BaseWebActivity.WebBridge";
  public static final String b = "qqjsbridge";
  HashMap a = new HashMap();
  
  public void a(WebBridge.JsHandler paramJsHandler, String paramString)
  {
    this.a.put(paramString, paramJsHandler);
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.a.clear();
      return;
    }
    this.a.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WebBridge.JsBridgeListener paramJsBridgeListener)
  {
    paramString1 = (WebBridge.JsHandler)this.a.get(paramString1);
    if (paramString1 != null) {
      paramString1.call(paramString2, paramString3, paramJsBridgeListener);
    }
    while (paramJsBridgeListener == null) {
      return;
    }
    paramJsBridgeListener.a();
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return false;
        paramString = paramString.trim();
        if (Uri.parse(paramString).getScheme().equals("qqjsbridge")) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("BaseWebActivity.WebBridge", 2, "can no do with this url:" + paramString);
      return false;
      localObject = paramString.split("/");
      if (localObject.length >= 6) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("BaseWebActivity.WebBridge", 2, "url params error:url=" + paramString + ",params num=" + localObject.length);
    return false;
    String str1 = localObject[2];
    String str2 = localObject[3];
    String str3 = localObject[4];
    Object localObject = localObject[5];
    try
    {
      String str4 = URLDecoder.decode((String)localObject, "UTF-8");
      if (QLog.isColorLevel()) {
        QLog.i("BaseWebActivity.WebBridge", 2, "HandleUrl params objectName=" + str1 + ",methodName=" + str2 + ",callbackId=" + str3 + ",jsonParams=" + str4);
      }
      a(str1, str2, str4, new WebBridge.JsBridgeListener(paramWebView, str3, paramString));
      return true;
    }
    catch (UnsupportedEncodingException paramWebView)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseWebActivity.WebBridge", 2, "jsonParams UnsupportedEncodingException,jsonParams=" + (String)localObject);
      }
      paramWebView.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsbridge.WebBridge
 * JD-Core Version:    0.7.0.1
 */