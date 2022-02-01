package com.tencent.mobileqq.activity.aio.tips;

import aizp;
import android.widget.Toast;
import anot;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import yjh;
import yjm;

public class TroopAssistTipsBar$1
  implements Runnable
{
  public TroopAssistTipsBar$1(yjm paramyjm) {}
  
  public void run()
  {
    if ((yjm.a(this.this$0).cs(yjm.a(this.this$0).aTl) != 2) && (yjm.a(this.this$0).cs(yjm.a(this.this$0).aTl) != 3)) {}
    do
    {
      do
      {
        return;
        if (aizp.a().L(yjm.a(this.this$0), yjm.a(this.this$0).aTl)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopAssistTipsBar", 2, "getTroopAssistTipInRange false, return ");
      return;
      if (this.this$0.e != null) {
        this.this$0.e.cancel();
      }
    } while (!yjm.a(this.this$0).a(this.this$0, new Object[0]));
    aizp.a().an(yjm.a(this.this$0), yjm.a(this.this$0).aTl);
    anot.a(yjm.a(this.this$0), "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.1
 * JD-Core Version:    0.7.0.1
 */