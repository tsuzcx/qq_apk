import android.app.Dialog;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;

public class tmo
  implements Runnable
{
  public tmo(RegisterNewBaseActivity paramRegisterNewBaseActivity) {}
  
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
 * Qualified Name:     tmo
 * JD-Core Version:    0.7.0.1
 */