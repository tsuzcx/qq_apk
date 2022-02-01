package com.tencent.open.appcommon.js;

import arwt;
import com.tencent.smtt.sdk.WebView;

class BaseInterface$3
  implements Runnable
{
  BaseInterface$3(BaseInterface paramBaseInterface, long paramLong, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    String str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('batchCallback',{guid:" + this.awB + ",'r':-2,'data':['" + this.val$msg + "']})};";
    arwt.e("Response<callBatch>", str);
    try
    {
      this.val$webView.loadUrl(str);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseInterface.3
 * JD-Core Version:    0.7.0.1
 */