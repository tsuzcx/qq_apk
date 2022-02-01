package com.tencent.mobileqq.activity.aio.rebuild;

import anot;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ybt;

public class NearbyChatPie$8
  implements Runnable
{
  public NearbyChatPie$8(ybt paramybt, String paramString) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.this$0.TAG, 4, "0X80052C5, " + this.Vv);
    }
    anot.a(this.this$0.app, "CliOper", "", "", "0X80052C5", "0X80052C5", 0, 0, this.this$0.sessionInfo.aTl, "", this.Vv, "");
    QQAppInterface localQQAppInterface = this.this$0.app;
    if (this.this$0.sessionInfo.cZ == 1001) {}
    for (String str = "0";; str = "1")
    {
      anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_send", 0, 0, str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8
 * JD-Core Version:    0.7.0.1
 */