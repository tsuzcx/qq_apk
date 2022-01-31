import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class xlz
  implements DialogInterface.OnDismissListener
{
  public xlz(LoginView paramLoginView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginView.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlz
 * JD-Core Version:    0.7.0.1
 */