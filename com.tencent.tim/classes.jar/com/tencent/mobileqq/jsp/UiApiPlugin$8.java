package com.tencent.mobileqq.jsp;

import ailq;
import aqez;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import org.json.JSONObject;

public class UiApiPlugin$8
  implements Runnable
{
  UiApiPlugin$8(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.this$0.bOH = this.val$json.optString("callback");
    aqez.a(this.this$0.mRuntime.getWebView(), new ailq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.8
 * JD-Core Version:    0.7.0.1
 */