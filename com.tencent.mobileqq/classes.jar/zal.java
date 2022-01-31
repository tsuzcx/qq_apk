import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class zal
  extends ShakeListener
{
  public void a()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null)
    {
      ScreenShot.a("MyShakeListener - top activity is null");
      return;
    }
    if (!localBaseActivity.mCurrentActivityShakeFlag)
    {
      ScreenShot.a("MyShakeListener - shake flag is false");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new zam(this, localBaseActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zal
 * JD-Core Version:    0.7.0.1
 */