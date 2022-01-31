package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

class eg
  implements View.OnClickListener
{
  eg(EmbedWebBaseActivity paramEmbedWebBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mWebView.canGoBack())
    {
      this.a.mWebView.goBack();
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.eg
 * JD-Core Version:    0.7.0.1
 */