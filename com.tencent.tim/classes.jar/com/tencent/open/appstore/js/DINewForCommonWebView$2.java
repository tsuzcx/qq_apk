package com.tencent.open.appstore.js;

import android.os.Build.VERSION;
import arwf;
import arwt;
import com.tencent.smtt.sdk.WebView;

public class DINewForCommonWebView$2
  implements Runnable
{
  DINewForCommonWebView$2(DINewForCommonWebView paramDINewForCommonWebView, String paramString) {}
  
  public void run()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 19)
      {
        DINewForCommonWebView.a(this.this$0).loadUrl(this.anH);
        return;
      }
      DINewForCommonWebView.a(this.this$0).evaluateJavascript(this.anH, new arwf(this));
      return;
    }
    catch (Exception localException)
    {
      arwt.d("DINewForCommonWebView", "[jsCallBack] e>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.js.DINewForCommonWebView.2
 * JD-Core Version:    0.7.0.1
 */