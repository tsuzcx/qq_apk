package com.tencent.biz.qrcode.activity;

import aqfr;
import rwt;

class QRDisplayActivity$12
  implements Runnable
{
  QRDisplayActivity$12(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    String str = "temp_qrcode_share_" + this.this$0.uin + ".png";
    try
    {
      str = rwt.a(this.this$0.getApplicationContext(), str, this.this$0.cU);
      this.this$0.runOnUiThread(new QRDisplayActivity.12.2(this, str));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (this.this$0.type == 2) {
        aqfr.b("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.this$0.uin, String.valueOf(this.this$0.bvr), "1" });
      }
      this.this$0.runOnUiThread(new QRDisplayActivity.12.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.12
 * JD-Core Version:    0.7.0.1
 */