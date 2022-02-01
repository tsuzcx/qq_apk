package com.tencent.qqmail.activity.readmail;

import android.webkit.JavascriptInterface;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewJavascriptInterface;

class ReadVirtualAdsMailFragment$9
  extends QMScaleWebViewController.QMScaleWebViewJavascriptInterface
{
  ReadVirtualAdsMailFragment$9(ReadVirtualAdsMailFragment paramReadVirtualAdsMailFragment, QMScaleWebViewController paramQMScaleWebViewController)
  {
    super(paramQMScaleWebViewController);
  }
  
  @JavascriptInterface
  public void getMailContentHtml(String paramString)
  {
    QMLog.log(4, ReadVirtualAdsMailFragment.TAG, "mWebViewController getMailContentHtml");
    ReadVirtualAdsMailFragment.access$1402(this.this$0, ReadVirtualAdsMailFragment.access$1500(this.this$0, paramString));
  }
  
  @JavascriptInterface
  public void hideLoadingTip() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.9
 * JD-Core Version:    0.7.0.1
 */