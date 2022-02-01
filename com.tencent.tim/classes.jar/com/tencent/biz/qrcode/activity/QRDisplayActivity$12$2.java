package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import aqfr;
import aqgv;
import avpw;
import avpw.d;
import com.tencent.mobileqq.app.QQAppInterface;
import rwt;

class QRDisplayActivity$12$2
  implements Runnable
{
  QRDisplayActivity$12$2(QRDisplayActivity.12 param12, String paramString) {}
  
  public void run()
  {
    if (this.a.this$0.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.val$finalFilePath))
    {
      if (this.a.this$0.type == 2) {
        aqfr.b("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.a.this$0.uin, String.valueOf(this.a.this$0.bvr), "1" });
      }
      rwt.ez(1, 2131698711);
      return;
    }
    String str;
    if (this.a.this$0.type == 2) {
      if (this.a.this$0.isQidianPrivateTroop) {
        str = this.a.this$0.getString(2131693308, new Object[] { this.a.this$0.aCr });
      }
    }
    for (;;)
    {
      avpw.d locald = avpw.d.a();
      locald.cMP = this.a.this$0.app.getAccount();
      locald.nickname = aqgv.n(this.a.this$0.app, this.a.this$0.app.getAccount());
      avpw.a(this.a.this$0, locald, this.val$finalFilePath, this.a.this$0.getString(2131693309), str, 1);
      return;
      str = this.a.this$0.getString(2131693307, new Object[] { this.a.this$0.aCr, this.a.this$0.uin });
      continue;
      if (this.a.this$0.type == 5) {
        str = this.a.this$0.getString(2131693306, new Object[] { this.a.this$0.aCr });
      } else if (this.a.this$0.type == 11) {
        str = this.a.this$0.getString(2131694563);
      } else {
        str = this.a.this$0.getString(2131693310);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.12.2
 * JD-Core Version:    0.7.0.1
 */