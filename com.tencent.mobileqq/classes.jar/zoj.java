import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyReportManyApps;
import com.tencent.biz.pubaccount.readinjoy.logic.SMRM;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import cooperation.readinjoy.ReadInJoyHelper;

public class zoj
  implements Runnable
{
  public zoj(TimerCheckMsgCount paramTimerCheckMsgCount) {}
  
  public void run()
  {
    TimerCheckMsgCount.a(this.a).b.a().l();
    ((HotChatManager)TimerCheckMsgCount.b(this.a).b.getManager(59)).b();
    TimerCheckMsgCount.c(this.a).b.a().c();
    if (!ReadInJoyHelper.k(TimerCheckMsgCount.d(this.a).b)) {}
    for (;;)
    {
      SMRM.a().a(TimerCheckMsgCount.e(this.a).b);
      return;
      try
      {
        TimerCheckMsgCount.a(this.a);
        ReadInJoyReportManyApps.a();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zoj
 * JD-Core Version:    0.7.0.1
 */