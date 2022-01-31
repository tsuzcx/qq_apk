import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dvc
  implements Runnable
{
  public dvc(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    try
    {
      if ((VerifyPhoneNumActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        VerifyPhoneNumActivity.a(this.a, new QQProgressDialog(this.a.a(), this.a.d()));
        VerifyPhoneNumActivity.a(this.a).b(2131562645);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dvc
 * JD-Core Version:    0.7.0.1
 */