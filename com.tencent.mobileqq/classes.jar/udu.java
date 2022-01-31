import android.app.Dialog;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;

public class udu
  implements Runnable
{
  public udu(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (!this.a.isFinishing())) {
      this.a.a.dismiss();
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     udu
 * JD-Core Version:    0.7.0.1
 */