import android.app.Dialog;
import com.tencent.mobileqq.activity.RegisterActivity;

public class dki
  implements Runnable
{
  public dki(RegisterActivity paramRegisterActivity) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (!this.a.isFinishing())) {
      this.a.a.dismiss();
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dki
 * JD-Core Version:    0.7.0.1
 */