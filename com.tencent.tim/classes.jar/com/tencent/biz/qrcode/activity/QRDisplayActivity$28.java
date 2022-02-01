package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import rwt;

class QRDisplayActivity$28
  implements Runnable
{
  QRDisplayActivity$28(QRDisplayActivity paramQRDisplayActivity, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    String str = rwt.a(this.this$0, this.val$filename, this.this$0.cU);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.28.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.28
 * JD-Core Version:    0.7.0.1
 */