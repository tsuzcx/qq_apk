package com.tencent.open.appcommon.js;

import arwt;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

class BaseInterface$2
  implements Runnable
{
  BaseInterface$2(BaseInterface paramBaseInterface, long paramLong, List paramList, WebView paramWebView) {}
  
  public void run()
  {
    String str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('batchCallback',{'guid':" + this.awB + ",'r':0,'data':" + this.JF.toString() + "})};";
    if (this.val$webView != null) {}
    try
    {
      this.val$webView.loadUrl(str);
      label58:
      arwt.i("BaseInterface", "Response<callBatch> AsyncInterface result : " + str);
      return;
      arwt.e("BaseInterface", "Response<callBatch> AsyncInterface result : webview is null !!!");
      return;
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseInterface.2
 * JD-Core Version:    0.7.0.1
 */