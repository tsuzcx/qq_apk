import android.app.Dialog;
import com.tencent.mobileqq.activity.RegisterActivity;

public class tol
  implements Runnable
{
  public tol(RegisterActivity paramRegisterActivity) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (!this.a.isFinishing())) {
      this.a.a.dismiss();
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tol
 * JD-Core Version:    0.7.0.1
 */