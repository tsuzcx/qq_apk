package com.tencent.mobileqq.mini.appbrand.page;

import acfp;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ProgressWebView$6$2
  implements Runnable
{
  ProgressWebView$6$2(ProgressWebView.6 param6) {}
  
  public void run()
  {
    File localFile = new File(this.this$1.val$tmpFilePath);
    if (localFile.exists())
    {
      ShareUtils.startSharePicToQQ(ProgressWebView.access$300(this.this$1.this$0), localFile.getAbsolutePath());
      return;
    }
    QLog.e("ProgressWebView", 1, "sharePicToQQ failed, because of picture downloadFailed");
    QQToast.a(ProgressWebView.access$300(this.this$1.this$0), 1, acfp.m(2131709977), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.6.2
 * JD-Core Version:    0.7.0.1
 */