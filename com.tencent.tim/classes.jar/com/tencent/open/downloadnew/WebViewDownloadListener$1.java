package com.tencent.open.downloadnew;

import android.os.Build.VERSION;
import aruf;
import arwt;
import arzy;
import arzz;
import com.tencent.smtt.sdk.WebView;

public class WebViewDownloadListener$1
  implements Runnable
{
  public WebViewDownloadListener$1(arzy paramarzy, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if ((this.h != null) && (this.cCE != null) && (aruf.a().aHc())) {
      try
      {
        arwt.v("WebViewDownloadListener", "wb.loadUrl(loadJs):" + this.cCE);
        if (Build.VERSION.SDK_INT < 19)
        {
          this.h.loadUrl(this.cCE);
          return;
        }
        this.h.evaluateJavascript(this.cCE, new arzz(this));
        return;
      }
      catch (Exception localException)
      {
        arwt.d("WebViewDownloadListener", "doJsCallBack >>> ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.WebViewDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */