package com.tencent.mobileqq.webviewplugin;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

@Deprecated
public class JsBridgeListener
{
  public long a;
  WeakReference a;
  
  public JsBridgeListener(WebView paramWebView, long paramLong, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onPermissionDenied");
    }
    if (this.jdField_a_of_type_Long == -1L) {}
    WebView localWebView;
    do
    {
      return;
      localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localWebView == null);
    localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':2,'result':'Permission denied'})");
  }
  
  @Deprecated
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_Long == -1L) {}
    WebView localWebView;
    do
    {
      return;
      localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localWebView == null);
    if (paramObject == null)
    {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':0});");
      return;
    }
    if (((paramObject instanceof Number)) || ((paramObject instanceof Boolean))) {}
    for (paramObject = paramObject.toString();; paramObject = "'" + paramObject.toString().replace("\\", "\\\\").replace("'", "\\'") + "'")
    {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':0,'result':" + paramObject + "});");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onNoMatchMethod");
    }
    if (this.jdField_a_of_type_Long == -1L) {}
    WebView localWebView;
    do
    {
      return;
      localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localWebView == null);
    localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':1,'result':'" + paramString + "'})");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.JsBridgeListener
 * JD-Core Version:    0.7.0.1
 */