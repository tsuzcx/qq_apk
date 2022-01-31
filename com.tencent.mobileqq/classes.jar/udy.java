import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class udy
  implements Runnable
{
  public udy(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    try
    {
      if ((VerifyPhoneNumActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        VerifyPhoneNumActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        VerifyPhoneNumActivity.a(this.a).c(2131435053);
      }
      if ((VerifyPhoneNumActivity.a(this.a) != null) && (!VerifyPhoneNumActivity.a(this.a).isShowing())) {
        VerifyPhoneNumActivity.a(this.a).show();
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
 * Qualified Name:     udy
 * JD-Core Version:    0.7.0.1
 */