package com.tencent.open.appstore.js;

import android.os.Build.VERSION;
import arwh;
import arwt;
import com.tencent.smtt.sdk.WebView;

public class DownloadInterfaceNew$2
  implements Runnable
{
  DownloadInterfaceNew$2(DownloadInterfaceNew paramDownloadInterfaceNew, String paramString) {}
  
  public void run()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 19)
      {
        DownloadInterfaceNew.a(this.this$0).loadUrl(this.anH);
        return;
      }
      DownloadInterfaceNew.a(this.this$0).evaluateJavascript(this.anH, new arwh(this));
      return;
    }
    catch (Exception localException)
    {
      arwt.d("DownloadInterfaceNew", "[jsCallBack] e>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.js.DownloadInterfaceNew.2
 * JD-Core Version:    0.7.0.1
 */