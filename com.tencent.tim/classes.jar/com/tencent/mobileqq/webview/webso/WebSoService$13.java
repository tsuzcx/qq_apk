package com.tencent.mobileqq.webview.webso;

import android.app.Activity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

final class WebSoService$13
  implements Runnable
{
  WebSoService$13(CustomWebView paramCustomWebView) {}
  
  public void run()
  {
    try
    {
      View localView = ((Activity)this.val$webView.getContext()).findViewById(2131371159);
      localView.animate().alpha(0.0F).setDuration(300L);
      localView.postDelayed(new WebSoService.13.1(this, localView), 300L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebSoService", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.13
 * JD-Core Version:    0.7.0.1
 */