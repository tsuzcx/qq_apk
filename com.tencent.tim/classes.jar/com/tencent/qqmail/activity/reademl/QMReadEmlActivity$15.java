package com.tencent.qqmail.activity.reademl;

import Override;
import android.graphics.Bitmap;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.activity.webviewexplorer.SubscribeWebViewExplorer;
import com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewClient;

class QMReadEmlActivity$15
  extends QMScaleWebViewController.QMScaleWebViewClient
{
  QMReadEmlActivity$15(QMReadEmlActivity paramQMReadEmlActivity, QMScaleWebViewController paramQMScaleWebViewController)
  {
    super(paramQMScaleWebViewController);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramString = paramString.trim();
    if ((QMReadEmlActivity.access$4000(this.this$0)) && (paramString.startsWith("http://rescdn.qqmail.com/riasharebook/")))
    {
      paramWebView = SubscribeWebViewExplorer.createIntent(this.this$0, QMReadEmlActivity.access$3000(this.this$0).getInformation().getId(), paramString, QMReadEmlActivity.access$3000(this.this$0).getInformation().getSubject(), true, null, null);
      this.this$0.startActivity(paramWebView);
      return true;
    }
    if (paramString.contains("/cgi-bin/ftnExs_download?"))
    {
      paramWebView = WebViewExplorer.createIntent(QMReadEmlActivity.access$4100(this.this$0, paramString), "", QMReadEmlActivity.access$3200(this.this$0), false);
      this.this$0.startActivity(paramWebView);
      return true;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")) || (paramString.startsWith("www.")))
    {
      paramWebView = WebViewExplorer.createIntent(paramString, "", QMReadEmlActivity.access$3200(this.this$0), false);
      this.this$0.startActivity(paramWebView);
      return true;
    }
    return super.shouldSafeOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.15
 * JD-Core Version:    0.7.0.1
 */