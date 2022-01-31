import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;

public class atm
  implements DialogInterface.OnDismissListener
{
  public atm(LoginActivity paramLoginActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atm
 * JD-Core Version:    0.7.0.1
 */