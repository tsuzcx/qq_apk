import android.app.Dialog;
import com.tencent.mobileqq.activity.RegisterBaseActivity;

public class tmc
  implements Runnable
{
  public tmc(RegisterBaseActivity paramRegisterBaseActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.a.a != null) && (this.a.a.isShowing())) {
        this.a.a.dismiss();
      }
      this.a.a = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmc
 * JD-Core Version:    0.7.0.1
 */