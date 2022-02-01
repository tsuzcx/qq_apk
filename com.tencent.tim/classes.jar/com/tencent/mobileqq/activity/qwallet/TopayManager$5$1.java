package com.tencent.mobileqq.activity.qwallet;

import aagd;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import anot;
import aqha;
import aqju;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import zzn;
import zzq;

public class TopayManager$5$1
  implements Runnable
{
  TopayManager$5$1(TopayManager.5 param5, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    SelectMemberActivity localSelectMemberActivity = (SelectMemberActivity)this.this$0.eM.get();
    if ((localSelectMemberActivity == null) || (localSelectMemberActivity.isFinishing())) {
      return;
    }
    zzn.b(localSelectMemberActivity, false);
    if (this.val$resultCode == 0)
    {
      this.this$0.n.send(1, null);
      anot.a(aagd.getQQAppInterface(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.aio.send", 0, 0, "", "", "", "");
      int i = localSelectMemberActivity.getIntent().getIntExtra("iPayFrom", -1);
      if (QLog.isColorLevel()) {
        QLog.e("TopayManager", 2, "iPayFrom : " + i);
      }
      if (i == 1)
      {
        zzn.c(localSelectMemberActivity, this.this$0.eg, this.this$0.rU);
        return;
      }
      zzn.d(localSelectMemberActivity, this.this$0.eg, this.this$0.rU);
      return;
    }
    if (this.s != null) {}
    for (String str = this.s.getString("retmsg");; str = null)
    {
      if (TextUtils.isEmpty(str)) {
        str = localSelectMemberActivity.getResources().getString(2131696664);
      }
      for (;;)
      {
        aqha.a(localSelectMemberActivity, 231, null, str, localSelectMemberActivity.getResources().getString(2131721079), null, null, new zzq(this)).show();
        anot.a(aagd.getQQAppInterface(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.errwinshow", 0, 0, "", "", "", "");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TopayManager.5.1
 * JD-Core Version:    0.7.0.1
 */