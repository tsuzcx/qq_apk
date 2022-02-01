package com.tencent.qqmail.activity.readmail;

import android.webkit.JavascriptInterface;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.translate.TranslateUtil;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewJavascriptInterface;

class ReadMailFragment$117
  extends QMScaleWebViewController.QMScaleWebViewJavascriptInterface
{
  ReadMailFragment$117(ReadMailFragment paramReadMailFragment, QMScaleWebViewController paramQMScaleWebViewController)
  {
    super(paramQMScaleWebViewController);
  }
  
  @JavascriptInterface
  public void finish(String paramString)
  {
    super.finish(paramString);
    ReadMailFragment.access$18102(this.this$0, 2);
  }
  
  @JavascriptInterface
  public void getButtonClicked(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.this$0.isShareToWXWhileList()) {
      this.this$0.shareMailToWX(Integer.valueOf(paramString1).intValue(), paramString2, paramString3, paramString4, paramString5, 7);
    }
  }
  
  @JavascriptInterface
  public void getPlainText(String paramString)
  {
    ReadMailFragment.access$18200(this.this$0, TranslateUtil.filterPlainText(paramString));
  }
  
  @JavascriptInterface
  public long getScaleInfoId()
  {
    return ReadMailFragment.access$000(this.this$0).getInformation().getId();
  }
  
  @JavascriptInterface
  public void hideLoadingTip()
  {
    ReadMailFragment.access$18000(this.this$0, new ReadMailFragment.117.1(this));
    if (ReadMailFragment.access$2300(this.this$0) != null) {
      ReadMailFragment.access$2300(this.this$0).execJs("getPlainText();");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.117
 * JD-Core Version:    0.7.0.1
 */