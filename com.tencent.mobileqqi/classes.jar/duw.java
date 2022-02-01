import android.app.Dialog;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;

public class duw
  implements Runnable
{
  public duw(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (!this.a.isFinishing())) {
      this.a.a.dismiss();
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     duw
 * JD-Core Version:    0.7.0.1
 */