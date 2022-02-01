package com.tencent.mobileqq.webview.swift;

import com.tencent.biz.pubaccount.util.PreloadManager;
import java.net.MalformedURLException;
import java.net.URL;

class WebViewFragment$9
  implements Runnable
{
  WebViewFragment$9(WebViewFragment paramWebViewFragment) {}
  
  public void run()
  {
    try
    {
      URL localURL = new URL(this.this$0.mUrl);
      if (PreloadManager.a().er(localURL.getHost())) {
        this.this$0.Tn(true);
      }
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.9
 * JD-Core Version:    0.7.0.1
 */