import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class gmm
  implements Runnable
{
  public gmm(ShareAppLogActivity paramShareAppLogActivity) {}
  
  public void run()
  {
    try
    {
      if (ShareAppLogActivity.a(this.a) == null)
      {
        ShareAppLogActivity.a(this.a, new QQProgressDialog(this.a.a(), this.a.d()));
        ShareAppLogActivity.a(this.a).b(2131562645);
      }
      ShareAppLogActivity.a(this.a).show();
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
 * Qualified Name:     gmm
 * JD-Core Version:    0.7.0.1
 */