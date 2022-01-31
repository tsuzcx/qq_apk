import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.CheckMsgCount;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class cyf
  implements Runnable
{
  public cyf(CheckMsgCount paramCheckMsgCount) {}
  
  public void run()
  {
    CheckMsgCount.a(this.a).a.a().l();
    CheckMsgCount.b(this.a).a.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cyf
 * JD-Core Version:    0.7.0.1
 */