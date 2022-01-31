import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class bgn
  implements Runnable
{
  public bgn(RecentLoginDevActivity paramRecentLoginDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((RecentLoginDevActivity.a(this.a) != null) && (RecentLoginDevActivity.a(this.a).isShowing()))
      {
        RecentLoginDevActivity.a(this.a).dismiss();
        RecentLoginDevActivity.a(this.a).cancel();
      }
      RecentLoginDevActivity.a(this.a, null);
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
 * Qualified Name:     bgn
 * JD-Core Version:    0.7.0.1
 */