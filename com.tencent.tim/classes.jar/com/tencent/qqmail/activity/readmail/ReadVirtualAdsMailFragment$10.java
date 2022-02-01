package com.tencent.qqmail.activity.readmail;

import Override;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewClient;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.TitleBarWebView2;

class ReadVirtualAdsMailFragment$10
  extends QMScaleWebViewController.QMScaleWebViewClient
{
  ReadVirtualAdsMailFragment$10(ReadVirtualAdsMailFragment paramReadVirtualAdsMailFragment, QMScaleWebViewController paramQMScaleWebViewController)
  {
    super(paramQMScaleWebViewController);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onSafePageFinished(WebView paramWebView, String paramString)
  {
    super.onSafePageFinished(paramWebView, paramString);
    QMLog.log(4, ReadVirtualAdsMailFragment.TAG, "onPageFinished ");
    ReadVirtualAdsMailFragment.access$1200(this.this$0).loadUrl("javascript:window.App.getMailContentHtml(document.getElementsByTagName('html')[0].outerHTML);");
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$1600(this.this$0), true);
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$1800(this.this$0), true);
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$1900(this.this$0), true);
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$2000(this.this$0), true);
    paramWebView = "javascript:getMailAppHeaderBarHeight(" + QMUIKit.pxToDp(ReadVirtualAdsMailFragment.access$2100(this.this$0).getMeasuredHeight()) + ");";
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      ReadVirtualAdsMailFragment.access$1200(this.this$0).evaluateJavascript(paramWebView, null);
      return;
    }
    catch (IllegalStateException paramString)
    {
      ReadVirtualAdsMailFragment.access$1200(this.this$0).loadUrl("javascript:" + paramWebView);
    }
  }
  
  public void onSafePageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onSafePageStarted(paramWebView, paramString, paramBitmap);
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$1600(this.this$0), false);
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$1800(this.this$0), false);
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$1900(this.this$0), false);
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$2000(this.this$0), false);
  }
  
  public void onSafeReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    super.onSafeReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    QMLog.log(4, ReadVirtualAdsMailFragment.TAG, "onReceivedError");
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$1600(this.this$0), false);
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$1800(this.this$0), false);
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$1900(this.this$0), false);
    ReadVirtualAdsMailFragment.access$1700(this.this$0, ReadVirtualAdsMailFragment.access$2000(this.this$0), false);
  }
  
  public WebResourceResponse shouldSafeInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    QMLog.log(4, ReadVirtualAdsMailFragment.TAG, "shouldInterceptRequest " + paramWebResourceRequest.getUrl());
    String str = paramWebResourceRequest.getUrl().toString();
    if (FileUtil.isImageSuffix(FileUtil.getFileNameSuffix(str)))
    {
      QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultQQAccount();
      if (localQQMailAccount == null) {
        return super.shouldSafeInterceptRequest(paramWebView, paramWebResourceRequest);
      }
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.setAccountId(localQQMailAccount.getId());
      localDownloadInfo.setUrl(str);
      localDownloadInfo.setImageDownloadListener(new ReadVirtualAdsMailFragment.10.2(this, str));
      ImageDownloadManager.shareInstance().fetchImage(localDownloadInfo);
    }
    return super.shouldSafeInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (JSApiUitil.handleJSRequest(paramString, new ReadVirtualAdsMailFragment.10.1(this, paramWebView))) {}
    do
    {
      return true;
      paramWebView = AccountManager.shareInstance().getAccountList().getDefaultQQAccount();
    } while (paramWebView == null);
    paramWebView = WebViewExplorer.createIntent(paramString, "", paramWebView.getId(), false);
    this.this$0.startActivity(paramWebView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.10
 * JD-Core Version:    0.7.0.1
 */