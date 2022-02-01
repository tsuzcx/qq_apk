package com.tencent.open.appcommon.js;

import aruu.a;
import arwt;
import com.tencent.smtt.sdk.WebView;

public class OpenJsBridge$OpenJsBridgeListener$2
  implements Runnable
{
  public OpenJsBridge$OpenJsBridgeListener$2(aruu.a parama, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    arwt.i("OpenJsBridge", "[onNoMatchMethod]AsyncInterface_end:javascript:window.JsBridge&&JsBridge.callback('interface." + this.cCB + "',{guid:" + this.this$0.abC + ",'r':-2,'data':'no such method'});");
    try
    {
      this.val$webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('interface." + this.cCB + "',{guid:" + this.this$0.abC + ",'r':-2,'data':'no such method'});");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener.2
 * JD-Core Version:    0.7.0.1
 */