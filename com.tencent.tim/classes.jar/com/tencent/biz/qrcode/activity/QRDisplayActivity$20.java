package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import rwt;

class QRDisplayActivity$20
  implements Runnable
{
  QRDisplayActivity$20(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    String str = "temp_qrcode_share_" + this.this$0.uin + ".png";
    str = rwt.a(this.this$0, str, this.this$0.cU);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.20.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.20
 * JD-Core Version:    0.7.0.1
 */