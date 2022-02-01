package com.tencent.biz.webviewplugin;

import android.app.Activity;
import ardk;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import svv;

public class WebSoPlugin$2
  implements Runnable
{
  public WebSoPlugin$2(svv paramsvv, String paramString) {}
  
  public void run()
  {
    if ((ardk.rY(this.val$url)) && (this.this$0.mRuntime != null) && (this.this$0.mRuntime.getActivity() != null)) {
      this.this$0.mRuntime.getActivity().runOnUiThread(new WebSoPlugin.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.2
 * JD-Core Version:    0.7.0.1
 */