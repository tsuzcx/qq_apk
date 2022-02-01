package com.tencent.mobileqq.troop.browser;

import aoye;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public class TroopWebviewPlugin$2
  implements Runnable
{
  public TroopWebviewPlugin$2(aoye paramaoye, String paramString) {}
  
  public void run()
  {
    SensorAPIJavaScript.returnToAio(this.this$0.mClient, this.this$0.mRuntime.getActivity(), this.cnv, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.TroopWebviewPlugin.2
 * JD-Core Version:    0.7.0.1
 */