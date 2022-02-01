package com.tencent.open.export.js;

import android.text.TextUtils;
import arwt;
import com.tencent.smtt.sdk.WebView;

class VipDownloadInterface$3
  implements Runnable
{
  VipDownloadInterface$3(VipDownloadInterface paramVipDownloadInterface, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.webview != null) && (!TextUtils.isEmpty(this.anH))) {
        this.this$0.webview.loadUrl(this.anH);
      }
      return;
    }
    catch (Exception localException)
    {
      arwt.d(this.this$0.TAG, "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.export.js.VipDownloadInterface.3
 * JD-Core Version:    0.7.0.1
 */