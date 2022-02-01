package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;

public final class SwiftBrowserTBSHandler$11
  implements Runnable
{
  public SwiftBrowserTBSHandler$11(String paramString1, String paramString2, WebView paramWebView, int paramInt1, int paramInt2, String paramString3) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.czw))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("TYPE", "4");
      localHashMap.put("mimeType", "text/html");
      localHashMap.put("encoding", "utf-8");
      localHashMap.put("baseUrl", this.czv);
      this.val$webView.getX5WebViewExtension().preLoad(this.czw, this.val$width, this.val$height, localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserTBSHandler", 2, "webView.getX5WebViewExtension().preLoad offline data:" + this.czv + ", sha1: " + this.czx);
      }
    }
    do
    {
      return;
      this.val$webView.getX5WebViewExtension().preLoad(this.czv, this.val$width, this.val$height, null);
    } while (!QLog.isColorLevel());
    QLog.d("SwiftBrowserTBSHandler", 2, "webView.getX5WebViewExtension().preLoad: " + this.czv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.11
 * JD-Core Version:    0.7.0.1
 */