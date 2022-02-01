package com.tencent.mobileqq.webview.swift;

import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class WebViewFragment$14
  implements Runnable
{
  WebViewFragment$14(WebViewFragment paramWebViewFragment, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "banner scroll to " + this.nM + " !");
    }
    if (!this.this$0.j.isPaused) {
      this.this$0.j.getView().scrollTo(0, this.nM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.14
 * JD-Core Version:    0.7.0.1
 */