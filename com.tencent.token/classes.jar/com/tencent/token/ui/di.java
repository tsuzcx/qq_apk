package com.tencent.token.ui;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class di
  extends WebChromeClient
{
  di(EmbedWebBaseActivity paramEmbedWebBaseActivity) {}
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if ((paramInt > 20) && (!this.a.mIsRefreshing) && (!EmbedWebBaseActivity.access$100(this.a)) && (paramInt < 90))
    {
      this.a.mIsRefreshing = true;
      EmbedWebBaseActivity.access$400(this.a, paramWebView);
    }
  }
  
  public final void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if ((paramWebView.getUrl() != null) && (paramWebView.getUrl().contains("sec_headline_content")))
    {
      this.a.sharetitle = paramString;
      this.a.shareurl = paramWebView.getUrl();
      this.a.mRightOptionLayout.setVisibility(0);
    }
    while (this.a.alsoShowMenu) {
      return;
    }
    this.a.mRightOptionLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.di
 * JD-Core Version:    0.7.0.1
 */