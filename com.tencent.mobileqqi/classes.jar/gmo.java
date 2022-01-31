import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class gmo
  implements Runnable
{
  public gmo(ShareAppLogActivity paramShareAppLogActivity) {}
  
  public void run()
  {
    try
    {
      if ((ShareAppLogActivity.a(this.a) != null) && (ShareAppLogActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        ShareAppLogActivity.a(this.a).dismiss();
        ShareAppLogActivity.a(this.a).cancel();
      }
      ShareAppLogActivity.a(this.a, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gmo
 * JD-Core Version:    0.7.0.1
 */