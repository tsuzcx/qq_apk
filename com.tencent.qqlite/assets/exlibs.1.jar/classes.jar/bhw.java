import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;

public class bhw
  implements Runnable
{
  public bhw(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    ((PhoneContactManager)this.a.app.getManager(10)).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bhw
 * JD-Core Version:    0.7.0.1
 */