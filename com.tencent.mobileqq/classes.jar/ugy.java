import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class ugy
  implements Runnable
{
  public ugy(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    try
    {
      if ((VerifyPhoneNumActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        VerifyPhoneNumActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        VerifyPhoneNumActivity.a(this.a).c(2131435070);
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
 * Qualified Name:     ugy
 * JD-Core Version:    0.7.0.1
 */