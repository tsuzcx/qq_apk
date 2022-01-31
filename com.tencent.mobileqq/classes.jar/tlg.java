import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class tlg
  implements Runnable
{
  public tlg(RecentLoginDevActivity paramRecentLoginDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((RecentLoginDevActivity.a(this.a) == null) && (!this.a.isFinishing())) {
        RecentLoginDevActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tlg
 * JD-Core Version:    0.7.0.1
 */