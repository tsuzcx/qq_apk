package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import anot;
import aqfr;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import rwt;

class QRDisplayActivity$20$1
  implements Runnable
{
  QRDisplayActivity$20$1(QRDisplayActivity.20 param20, String paramString) {}
  
  public void run()
  {
    if (this.a.this$0.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!TextUtils.isEmpty(this.val$filePath)) {
            break;
          }
          rwt.ez(1, 2131698711);
        } while (this.a.this$0.type != 2);
        if (this.a.this$0.atU == 2) {}
        for (String str = "qr_wechat";; str = "qr_circle")
        {
          aqfr.b("Grp_share", "grpData_admin", str, 0, 0, new String[] { this.a.this$0.uin, String.valueOf(this.a.this$0.bvr), "1" });
          return;
        }
        if (this.a.this$0.atU != 2) {
          break;
        }
        WXShareHelper.a().b(this.val$filePath, this.a.this$0.cU, 0);
        if (this.a.this$0.type == 2)
        {
          anot.a(this.a.this$0.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_wechat", 0, 0, this.a.this$0.uin, "", String.valueOf(this.a.this$0.bvr), "");
          return;
        }
      } while (this.a.this$0.type != 5);
      anot.a(this.a.this$0.app, "CliOper", "", "", "0X8006676", "0X8006676", 0, 0, "", "", "", "");
      return;
      WXShareHelper.a().b(this.val$filePath, this.a.this$0.cU, 1);
      if (this.a.this$0.type == 2)
      {
        anot.a(this.a.this$0.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_circle", 0, 0, this.a.this$0.uin, "", String.valueOf(this.a.this$0.bvr), "");
        return;
      }
    } while (this.a.this$0.type != 5);
    anot.a(this.a.this$0.app, "CliOper", "", "", "0X8006677", "0X8006677", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.20.1
 * JD-Core Version:    0.7.0.1
 */