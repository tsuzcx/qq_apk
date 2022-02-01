package com.tencent.mobileqq.app.automator.step;

import awit;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDoingSomething;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import kxg;
import tog;

class TimerCheckMsgCount$1
  implements Runnable
{
  TimerCheckMsgCount$1(TimerCheckMsgCount paramTimerCheckMsgCount) {}
  
  public void run()
  {
    this.this$0.a.app.b().bEI();
    ((HotChatManager)this.this$0.a.app.getManager(60)).cJn();
    this.this$0.a.app.a().bEq();
    if (!awit.C(this.this$0.a.app)) {}
    while (!((Boolean)awit.f("kandian_report_user_apps_switch", Boolean.valueOf(false))).booleanValue())
    {
      return;
      try
      {
        TimerCheckMsgCount.a(this.this$0);
        ReadInJoyDoingSomething.aHE();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    try
    {
      kxg.aHH();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("QQInitHandler", 1, "TImerCheckMsgCount run: ", localException2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount.1
 * JD-Core Version:    0.7.0.1
 */