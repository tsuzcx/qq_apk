package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.text.TextUtils;
import ardk;

class WebSoService$4
  implements Runnable
{
  WebSoService$4(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState, String paramString, Handler paramHandler) {}
  
  public void run()
  {
    this.a.czO = ardk.qi(this.val$url);
    if (TextUtils.isEmpty(this.a.czO)) {
      return;
    }
    this.a.aCu = true;
    this.a.cZe = true;
    WebSoService.a(this.this$0, this.val$handler, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.4
 * JD-Core Version:    0.7.0.1
 */