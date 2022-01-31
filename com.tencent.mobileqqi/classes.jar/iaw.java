import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkStandardDialogActivity;

public class iaw
  implements DialogInterface.OnDismissListener
{
  public iaw(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iaw
 * JD-Core Version:    0.7.0.1
 */