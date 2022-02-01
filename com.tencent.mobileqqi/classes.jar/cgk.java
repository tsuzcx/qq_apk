import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class cgk
  implements Runnable
{
  public cgk(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((DevlockPushActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        DevlockPushActivity.a(this.a, new QQProgressDialog(this.a, this.a.d()));
        DevlockPushActivity.a(this.a).b(2131562645);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cgk
 * JD-Core Version:    0.7.0.1
 */