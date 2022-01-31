import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.SplashActivity;

public class blb
  implements DialogInterface.OnDismissListener
{
  public blb(SplashActivity paramSplashActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     blb
 * JD-Core Version:    0.7.0.1
 */