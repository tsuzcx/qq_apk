package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import rwt;

class QRDisplayActivity$21
  implements Runnable
{
  QRDisplayActivity$21(QRDisplayActivity paramQRDisplayActivity, String paramString) {}
  
  public void run()
  {
    String str = rwt.a(this.this$0, this.val$filename, this.this$0.cU);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.21.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.21
 * JD-Core Version:    0.7.0.1
 */