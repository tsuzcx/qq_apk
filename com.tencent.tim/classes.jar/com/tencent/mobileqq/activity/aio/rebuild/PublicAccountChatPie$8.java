package com.tencent.mobileqq.activity.aio.rebuild;

import acja;
import android.os.Handler;
import android.text.TextUtils;
import anot;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import kaw;
import kbp;
import ycd;
import ydv;

public class PublicAccountChatPie$8
  implements Runnable
{
  public PublicAccountChatPie$8(ycd paramycd) {}
  
  public void run()
  {
    Object localObject = null;
    acja localacja = (acja)this.this$0.app.getManager(56);
    if (localacja != null) {
      localObject = localacja.b(this.this$0.sessionInfo.aTl);
    }
    boolean bool;
    if (localObject == null)
    {
      bool = this.this$0.Tk();
      this.this$0.Tj();
      if ((bool) && (TextUtils.isEmpty(this.this$0.mPromotionMsg)) && (localacja != null))
      {
        localObject = localacja.a(this.this$0.sessionInfo.aTl);
        if ((localObject != null) && (!TextUtils.isEmpty(((AccountDetail)localObject).summary))) {
          this.this$0.mPromotionMsg = ((AccountDetail)localObject).summary;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (ycd.c(this.this$0)))
      {
        kbp.a(this.this$0.app, "CliOper", "", "", "0X8004EFB", "0X8004EFB", 0, 0, "", "", "", "", false);
        this.this$0.bln = true;
        this.this$0.mHandler.sendEmptyMessage(3);
      }
      for (;;)
      {
        localObject = "0";
        if (bool) {
          localObject = "1";
        }
        long l = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
          QLog.d("struct_log_tag", 2, "PublicAccountChatPie :CliOper|" + this.this$0.sessionInfo.aTl + "|0X8005619|0X8005619" + 0 + "|" + 0 + "|" + Long.toString(l) + "|" + (String)localObject);
        }
        anot.a(this.this$0.app, "CliOper", "", this.this$0.sessionInfo.aTl, "0X8005619", "0X8005619", 0, 0, Long.toString(l), (String)localObject, "", "");
        return;
        if (!ycd.d(this.this$0)) {
          this.this$0.b.a(this.this$0.mActivity, this.this$0.app, this.this$0.app.getAccount(), this.this$0.sessionInfo.aTl, new ydv(this));
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.8
 * JD-Core Version:    0.7.0.1
 */