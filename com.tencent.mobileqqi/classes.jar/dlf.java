import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;

public class dlf
  implements DialogInterface.OnDismissListener
{
  public dlf(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == RegisterPhoneNumActivity.a(this.a)) {
      RegisterPhoneNumActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dlf
 * JD-Core Version:    0.7.0.1
 */