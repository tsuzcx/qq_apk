import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class bsh
  implements Runnable
{
  public bsh(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bsh
 * JD-Core Version:    0.7.0.1
 */