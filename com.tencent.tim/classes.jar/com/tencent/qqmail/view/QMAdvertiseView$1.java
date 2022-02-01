package com.tencent.qqmail.view;

import Override;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAdvertiseView$1
  extends WebViewClient
{
  QMAdvertiseView$1(QMAdvertiseView paramQMAdvertiseView) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    QMLog.log(4, "QMAdvertiseView", "onPageFinished");
    if (QMAdvertiseView.access$200(this.this$0) != null) {
      JSApiUitil.initJsApi(QMAdvertiseView.access$200(this.this$0));
    }
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (JSApiUitil.handleJSRequest(paramString, new QMAdvertiseView.1.1(this, paramWebView))) {
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMAdvertiseView.1
 * JD-Core Version:    0.7.0.1
 */