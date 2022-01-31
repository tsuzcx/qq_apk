import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;

public class czo
  implements DialogInterface.OnDismissListener
{
  public czo(LoginActivity paramLoginActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     czo
 * JD-Core Version:    0.7.0.1
 */