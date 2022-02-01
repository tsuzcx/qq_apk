package com.tencent.qqmail.activity.webviewexplorer;

import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;

class WebViewExplorer$10
  implements Runnable
{
  WebViewExplorer$10(WebViewExplorer paramWebViewExplorer) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(1000L);
    this.this$0.webViewSafeBar.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.10
 * JD-Core Version:    0.7.0.1
 */