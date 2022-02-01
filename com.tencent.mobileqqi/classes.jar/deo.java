import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class deo
  implements Runnable
{
  public deo(RecentLoginDevActivity paramRecentLoginDevActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     deo
 * JD-Core Version:    0.7.0.1
 */