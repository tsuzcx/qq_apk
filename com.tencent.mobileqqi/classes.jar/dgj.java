import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;

public class dgj
  implements Runnable
{
  public dgj(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    ((PhoneContactManager)this.a.b.getManager(10)).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dgj
 * JD-Core Version:    0.7.0.1
 */