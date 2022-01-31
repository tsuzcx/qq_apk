import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class cgm
  implements Runnable
{
  public cgm(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((DevlockPushActivity.a(this.a) != null) && (DevlockPushActivity.a(this.a).isShowing()))
      {
        DevlockPushActivity.a(this.a).dismiss();
        DevlockPushActivity.a(this.a).cancel();
      }
      DevlockPushActivity.a(this.a, null);
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
 * Qualified Name:     cgm
 * JD-Core Version:    0.7.0.1
 */