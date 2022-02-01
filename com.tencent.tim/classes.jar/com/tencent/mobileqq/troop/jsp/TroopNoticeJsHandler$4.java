package com.tencent.mobileqq.troop.jsp;

import apmj;
import com.tencent.smtt.sdk.WebView;

public class TroopNoticeJsHandler$4
  implements Runnable
{
  public TroopNoticeJsHandler$4(apmj paramapmj, WebView paramWebView, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.e != null) {
      this.e.loadUrl("javascript: " + this.val$callback + "(" + this.adB + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.4
 * JD-Core Version:    0.7.0.1
 */