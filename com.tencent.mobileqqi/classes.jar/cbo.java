import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AuthDevActivity;

public class cbo
  implements DialogInterface.OnDismissListener
{
  public cbo(AuthDevActivity paramAuthDevActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == AuthDevActivity.a(this.a)) {
      AuthDevActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbo
 * JD-Core Version:    0.7.0.1
 */