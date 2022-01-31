package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

final class dl
  implements View.OnClickListener
{
  dl(EmbedWebBaseActivity paramEmbedWebBaseActivity) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.mWebView.canGoBack())
    {
      EmbedWebBaseActivity.access$502(this.a, true);
      this.a.mWebView.goBack();
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dl
 * JD-Core Version:    0.7.0.1
 */