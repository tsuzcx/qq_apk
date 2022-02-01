package com.tencent.qqmail.note;

import Override;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.fragment.CardFragmentActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewClient;

class ReadNoteActivity$46
  extends QMScaleWebViewController.QMScaleWebViewClient
{
  ReadNoteActivity$46(ReadNoteActivity paramReadNoteActivity, QMScaleWebViewController paramQMScaleWebViewController)
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
    QMLog.log(4, "baggiotest", "readnote onPageFinished : " + paramString);
  }
  
  public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramString = paramString.trim();
    if (paramString.startsWith("tel:"))
    {
      DataCollector.logEvent("Event_Use_Content_Recognize");
      paramWebView = paramString.toString().replace("tel:", "");
      this.this$0.showTelDialog(paramWebView);
      return true;
    }
    if (paramString.startsWith("mailto:"))
    {
      DataCollector.logEvent("Event_Use_Content_Recognize");
      paramWebView = paramString.toString().replace("mailto:", "");
      this.this$0.showMailToDialog(paramWebView);
      return true;
    }
    if (paramString.startsWith("date:"))
    {
      DataCollector.logEvent("Event_Use_Content_Recognize");
      paramWebView = Uri.decode(paramString).toString().replace("date:", "");
      paramString = paramWebView.split(",")[0];
      long l = Long.parseLong(paramWebView.split(",")[1]);
      this.this$0.showCalendarDialog(paramString, Long.valueOf(l));
      return true;
    }
    if ((paramString.startsWith("http://i.mail.qq.com/cgi-bin/uma_ack_card?")) || (paramString.startsWith("https://i.mail.qq.com/cgi-bin/uma_ack_card?")))
    {
      DataCollector.logEvent("Event_Card_Thank");
      paramWebView = ReadNoteActivity.access$100(this.this$0).information.subject;
      paramString = this.this$0.getResources().getStringArray(2130968588);
      paramWebView = ComposeMailActivity.createIntentFromCard(QMSettingManager.sharedInstance().getDefaultNoteAccountID(), null, null, paramWebView, paramString[((int)(java.lang.Math.random() * paramString.length))]);
      this.this$0.startActivity(paramWebView);
      return true;
    }
    if ((paramString.startsWith("http://i.mail.qq.com/cgi-bin/uma_compose_card")) || (paramString.startsWith("https://i.mail.qq.com/cgi-bin/uma_compose_card")))
    {
      DataCollector.logEvent("Event_Card_Send_Too");
      paramWebView = CardFragmentActivity.createIntentToGallery(QMCardManager.shareInstance().getJumpCardDefaulType(), false);
      this.this$0.startActivity(paramWebView);
      return true;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")) || (paramString.startsWith("www.")))
    {
      DataCollector.logEvent("Event_Use_Content_Recognize");
      paramWebView = Uri.decode(paramString);
      this.this$0.openUrl(paramWebView);
      DataCollector.logEvent("Event_Content_Recognize_Open_Url");
      return true;
    }
    return super.shouldSafeOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.46
 * JD-Core Version:    0.7.0.1
 */