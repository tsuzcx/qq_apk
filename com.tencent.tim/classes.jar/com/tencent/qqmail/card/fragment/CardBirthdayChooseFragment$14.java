package com.tencent.qqmail.card.fragment;

import Override;
import android.graphics.Bitmap;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.activity.webviewexplorer.BaseSafeWebViewClient;

class CardBirthdayChooseFragment$14
  extends BaseSafeWebViewClient
{
  CardBirthdayChooseFragment$14(CardBirthdayChooseFragment paramCardBirthdayChooseFragment) {}
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ("qqmai://card/preview".equals(paramString))
    {
      paramWebView = new CardPreviewFragment(2, CardBirthdayChooseFragment.access$1300(this.this$0), false);
      this.this$0.startFragment(paramWebView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.14
 * JD-Core Version:    0.7.0.1
 */