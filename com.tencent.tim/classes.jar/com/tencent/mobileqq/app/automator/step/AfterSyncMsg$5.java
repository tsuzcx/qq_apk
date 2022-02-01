package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import kbp;
import mqq.app.MobileQQ;

class AfterSyncMsg$5
  implements Runnable
{
  AfterSyncMsg$5(AfterSyncMsg paramAfterSyncMsg) {}
  
  public void run()
  {
    int i = 1;
    String str;
    if (this.this$0.a.app.getApplication() != null)
    {
      str = this.this$0.a.app.getCurrentUin();
      if (!SettingCloneUtil.readValue(this.this$0.a.app.getApplication().getApplicationContext(), str, null, "qqsetting_lock_screen_whenexit_key", true)) {
        break label86;
      }
    }
    for (;;)
    {
      kbp.a(null, "CliOper", "", str, "0X80096F0", "0X80096F0", 0, 0, String.valueOf(i), "", "", "", false);
      return;
      label86:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg.5
 * JD-Core Version:    0.7.0.1
 */