import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.CheckMsgCount;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class flz
  implements Runnable
{
  public flz(CheckMsgCount paramCheckMsgCount) {}
  
  public void run()
  {
    CheckMsgCount.a(this.a).a.a().p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     flz
 * JD-Core Version:    0.7.0.1
 */