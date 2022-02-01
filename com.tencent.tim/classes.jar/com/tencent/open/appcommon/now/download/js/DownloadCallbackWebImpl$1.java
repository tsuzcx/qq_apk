package com.tencent.open.appcommon.now.download.js;

import aruf;
import arvb;
import arwt;
import com.tencent.smtt.sdk.WebView;

public class DownloadCallbackWebImpl$1
  implements Runnable
{
  public DownloadCallbackWebImpl$1(arvb paramarvb, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if ((this.h != null) && (this.cCE != null) && (aruf.a().aHc())) {}
    try
    {
      this.h.loadUrl(this.cCE);
      return;
    }
    catch (Exception localException)
    {
      arwt.d("DownloadCallbackWebImpl", "doJsCallBack >>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadCallbackWebImpl.1
 * JD-Core Version:    0.7.0.1
 */