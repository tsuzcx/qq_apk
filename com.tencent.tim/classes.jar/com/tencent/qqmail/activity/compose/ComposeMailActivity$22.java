package com.tencent.qqmail.activity.compose;

import Override;
import android.graphics.Bitmap;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.activity.webviewexplorer.BaseSafeWebViewClient;
import com.tencent.qqmail.card.fragment.CardFragmentActivity;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;

class ComposeMailActivity$22
  extends BaseSafeWebViewClient
{
  ComposeMailActivity$22(ComposeMailActivity paramComposeMailActivity) {}
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.equals("qqmai://card/preview"))
    {
      paramWebView = CardFragmentActivity.createIntentToCardPlayPreview(this.this$0.composeMail.getCardData());
      this.this$0.startActivity(paramWebView);
      return true;
    }
    return super.shouldSafeOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.22
 * JD-Core Version:    0.7.0.1
 */