import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ywy
  implements Runnable
{
  public ywy(BaseActivity paramBaseActivity) {}
  
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
 * Qualified Name:     ywy
 * JD-Core Version:    0.7.0.1
 */