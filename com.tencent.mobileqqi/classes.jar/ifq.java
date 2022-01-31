import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkStandardDialogActivity;

public class ifq
  implements DialogInterface.OnDismissListener
{
  public ifq(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ifq
 * JD-Core Version:    0.7.0.1
 */