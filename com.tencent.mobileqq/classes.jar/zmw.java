import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.CheckMsgCount;
import com.tencent.mobileqq.app.message.MultiMsgProxy;

public class zmw
  implements Runnable
{
  public zmw(CheckMsgCount paramCheckMsgCount) {}
  
  public void run()
  {
    CheckMsgCount.a(this.a).b.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zmw
 * JD-Core Version:    0.7.0.1
 */