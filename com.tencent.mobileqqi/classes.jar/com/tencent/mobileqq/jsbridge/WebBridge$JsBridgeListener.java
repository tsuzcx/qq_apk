package com.tencent.mobileqq.jsbridge;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import gdy;
import gdz;
import gea;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebBridge$JsBridgeListener
{
  public String a;
  WeakReference a;
  String b;
  
  public WebBridge$JsBridgeListener(WebView paramWebView, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseWebActivity.WebBridge", 2, "WebBridge onNoMatchMethod webView is null");
      }
      return;
    }
    localWebView.post(new gdz(this, localWebView));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseWebActivity.WebBridge", 2, "WebBridge onError,error msg=" + paramString);
    }
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseWebActivity.WebBridge", 2, "WebBridge onError webView is null");
      }
      return;
    }
    localWebView.post(new gea(this, paramString, localWebView));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseWebActivity.WebBridge", 2, "WebBridge onComplete webView is null");
      }
      return;
    }
    String str = paramJSONObject.toString();
    if (QLog.isColorLevel()) {
      QLog.i("BaseWebActivity.WebBridge", 2, "WebBridge onComplete,callbackId=" + this.jdField_a_of_type_JavaLangString + ",json=" + str);
    }
    localWebView.post(new gdy(this, paramJSONObject, localWebView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsbridge.WebBridge.JsBridgeListener
 * JD-Core Version:    0.7.0.1
 */