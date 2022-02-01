package com.tencent.open.wadl;

import asbt;
import asby;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class WadlJsBridgeCallBack$1
  implements Runnable
{
  public WadlJsBridgeCallBack$1(asby paramasby, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    try
    {
      this.h.loadUrl(this.cCE);
      if (QLog.isColorLevel()) {
        asbt.i(asby.TAG, "doJsCallback call:" + this.cCE);
      }
      return;
    }
    catch (Exception localException)
    {
      asbt.e(asby.TAG, "doJsCallback exception ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeCallBack.1
 * JD-Core Version:    0.7.0.1
 */