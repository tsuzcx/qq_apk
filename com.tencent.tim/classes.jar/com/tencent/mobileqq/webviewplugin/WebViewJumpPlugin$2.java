package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import ardn;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public class WebViewJumpPlugin$2
  implements Runnable
{
  public WebViewJumpPlugin$2(ardn paramardn) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.mRuntime.getActivity();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.2
 * JD-Core Version:    0.7.0.1
 */