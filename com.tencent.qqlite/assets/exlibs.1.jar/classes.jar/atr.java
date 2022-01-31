import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;

public class atr
  implements DialogInterface.OnDismissListener
{
  public atr(LoginActivity paramLoginActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atr
 * JD-Core Version:    0.7.0.1
 */