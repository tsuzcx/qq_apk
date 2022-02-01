import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class den
  implements Runnable
{
  public den(RecentLoginDevActivity paramRecentLoginDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((RecentLoginDevActivity.a(this.a) == null) && (!this.a.isFinishing())) {
        RecentLoginDevActivity.a(this.a, new QQProgressDialog(this.a.a(), this.a.d()));
      }
      if ((RecentLoginDevActivity.a(this.a) != null) && (!RecentLoginDevActivity.a(this.a).isShowing())) {
        RecentLoginDevActivity.a(this.a).show();
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
 * Qualified Name:     den
 * JD-Core Version:    0.7.0.1
 */