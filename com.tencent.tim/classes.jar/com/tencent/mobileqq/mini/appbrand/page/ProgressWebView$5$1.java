package com.tencent.mobileqq.mini.appbrand.page;

import acfp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ProgressWebView$5$1
  implements Runnable
{
  ProgressWebView$5$1(ProgressWebView.5 param5) {}
  
  public void run()
  {
    QLog.e("ProgressWebView", 1, "savaPicToAlbum failed, because of picture downloadFailed");
    QQToast.a(ProgressWebView.access$300(this.this$1.this$0), 1, acfp.m(2131709972), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.5.1
 * JD-Core Version:    0.7.0.1
 */