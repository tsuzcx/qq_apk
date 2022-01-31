import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;

public class tqb
  implements Runnable
{
  public tqb(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    ((PhoneContactManager)this.a.app.getManager(10)).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqb
 * JD-Core Version:    0.7.0.1
 */