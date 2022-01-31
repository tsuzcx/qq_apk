import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class zae
  implements Runnable
{
  public zae(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (this.a.runnableRemoveNotification != null)
    {
      this.a.runnableRemoveNotification = null;
      this.a.app.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zae
 * JD-Core Version:    0.7.0.1
 */