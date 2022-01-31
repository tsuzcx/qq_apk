import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class aic
  implements Runnable
{
  public aic(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((DevlockPushActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        DevlockPushActivity.a(this.a, new QQProgressDialog(this.a, this.a.getTitleBarHeight()));
        DevlockPushActivity.a(this.a).b(2131363558);
      }
      if ((DevlockPushActivity.a(this.a) != null) && (!DevlockPushActivity.a(this.a).isShowing())) {
        DevlockPushActivity.a(this.a).show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aic
 * JD-Core Version:    0.7.0.1
 */