package com.tencent.captchasdk;

import android.net.Uri;
import android.support.annotation.RequiresApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class j
  extends WebViewClient
{
  j(g paramg) {}
  
  @RequiresApi(api=21)
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    Uri localUri = paramWebResourceRequest.getUrl();
    if (localUri.getScheme().equals("tcwebscheme"))
    {
      g.a(this.a, localUri);
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    if (localUri.getScheme().equals("tcwebscheme"))
    {
      g.a(this.a, localUri);
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.captchasdk.j
 * JD-Core Version:    0.7.0.1
 */