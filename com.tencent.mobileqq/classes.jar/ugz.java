import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class ugz
  implements Runnable
{
  public ugz(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    try
    {
      if ((VerifyPhoneNumActivity.a(this.a) != null) && (VerifyPhoneNumActivity.a(this.a).isShowing()))
      {
        VerifyPhoneNumActivity.a(this.a).dismiss();
        VerifyPhoneNumActivity.a(this.a).cancel();
      }
      VerifyPhoneNumActivity.a(this.a, null);
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
 * Qualified Name:     ugz
 * JD-Core Version:    0.7.0.1
 */