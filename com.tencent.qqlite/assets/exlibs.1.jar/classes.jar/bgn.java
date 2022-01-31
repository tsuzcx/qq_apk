import android.app.Dialog;
import com.tencent.mobileqq.activity.RegisterActivity;

public class bgn
  implements Runnable
{
  public bgn(RegisterActivity paramRegisterActivity) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (!this.a.isFinishing())) {
      this.a.a.dismiss();
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bgn
 * JD-Core Version:    0.7.0.1
 */