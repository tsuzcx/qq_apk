import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.SubLoginActivity;

public class dms
  implements DialogInterface.OnDismissListener
{
  public dms(SubLoginActivity paramSubLoginActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dms
 * JD-Core Version:    0.7.0.1
 */