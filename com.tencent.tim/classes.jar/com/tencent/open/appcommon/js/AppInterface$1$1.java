package com.tencent.open.appcommon.js;

import android.text.TextUtils;
import aruk;
import arwt;
import com.tencent.smtt.sdk.WebView;

public class AppInterface$1$1
  implements Runnable
{
  public AppInterface$1$1(aruk paramaruk, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.a.this$0.webView != null) && (!TextUtils.isEmpty(this.cCw))) {
        this.a.this$0.webView.loadUrl(this.cCw);
      }
      return;
    }
    catch (Exception localException)
    {
      arwt.d("AppInterface", "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.1.1
 * JD-Core Version:    0.7.0.1
 */